package m03.d27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class second_1966_프린터_큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        PriorityQueue<Document> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < t; i++) {
            int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                    .toArray();
            int n = s[0];
            int m = s[1];

            int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                    .toArray();

            for (int j = 0; j < n; j++) {
                pq.add(new Document(j,nums[j]));
            }
            int result = 1;
            while (true){
                if (pq.peek().index == m){
                    break;
                }
                Document poll = pq.poll();
                result++;
            }
            System.out.println(result);
            pq.clear();
        }
    }

    private static class Document implements Comparable<Document>{
        int index;
        int priority;
        boolean visited = false;

        public Document(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }

        @Override
        public int compareTo(Document o) {
            int compare = Integer.compare(priority, o.priority);
            if (compare == 0){
                return Boolean.compare(visited,o.visited);
            }
            return compare;
        }
    }
}
