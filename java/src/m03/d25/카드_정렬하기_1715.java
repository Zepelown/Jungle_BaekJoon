package m03.d25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 카드_정렬하기_1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Double> pq = new PriorityQueue<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            double num = Float.parseFloat(br.readLine());
            pq.add(num);
        }
        if (pq.size() == 1) {
            System.out.printf("0");
        } else if (pq.size() == 2) {
            Double poll = pq.poll();
            System.out.printf("%.0f", pq.peek() + poll);
        } else {
            // 셋팅 단계
            double current, prev;
            double result = 0;
            while (!pq.isEmpty()) {
                prev = pq.poll();
                current = pq.poll();
                double sum = prev + current;
                result += sum;
                pq.add(sum);
                if (pq.size() == 1) {
                    System.out.printf("%.0f", result);
                    break;
                }

            }
        }

    }
}
