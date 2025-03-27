package m03.d27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class second_1966_프린터_큐_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                    .toArray();
            int n = s[0];
            int m = s[1];

            int[] priorities = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                    .toArray();

            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            Deque<Document> queue = new ArrayDeque<>();
            for (int j = 0; j < n; j++) {
                pq.add(priorities[j]);
                queue.add(new Document(j,priorities[j]));
            }
            int max = pq.poll();

            int result = 0;
            while (true){
//                System.out.println(queue.peek().priority);
                if (queue.peek().priority == max) {
                    result++;
                    if (queue.peek().index == m){
                        break;
                    }
                    queue.pollFirst();
                    max = pq.poll();
                    continue;
                }
                queue.add(queue.pollFirst());
            }
            System.out.println(result);
        }
    }
    private static class Document implements Comparable<Document>{
        int index;
        int priority;

        public Document(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }

        @Override
        public int compareTo(Document o) {
            return 0;
        }
    }
}
