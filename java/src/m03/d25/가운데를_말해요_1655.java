package m03.d25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class 가운데를_말해요_1655 {
    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        ArrayList<Integer> buffer = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            pq.add(num);
            int res = Integer.MAX_VALUE;
            if (pq.size() % 2 == 0) {
                int mid_left_iter = (pq.size() / 2) - 1;
                int mid_right_iter = (pq.size() / 2);

                for (int j = 0; j < mid_right_iter; j++) {
                    if (j == mid_left_iter) {
                        res = Math.min(res, pq.peek());
                    }
                    Integer poll = pq.poll();
                    buffer.add(poll);
                }
                res = Math.min(res, pq.peek());
                pq.addAll(buffer);
                buffer.clear();
                result.append(res).append('\n');
                continue;
            }

            int mid = (int) (double) (pq.size() / 2);
            for (int j = 0; j < mid; j++) {
                Integer poll = pq.poll();
                buffer.add(poll);
            }
            res = Math.min(res, pq.peek());
            pq.addAll(buffer);
            buffer.clear();


            result.append(res).append('\n');
        }
        System.out.println(result);
    }
}
