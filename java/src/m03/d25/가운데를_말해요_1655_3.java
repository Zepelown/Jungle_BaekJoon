package m03.d25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class 가운데를_말해요_1655_3 {
    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> leftHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> rightHeap = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (leftHeap.isEmpty() || num <= leftHeap.peek()) {
                leftHeap.add(num);
            } else {
                rightHeap.add(num);
            }
            if (leftHeap.size() > rightHeap.size() + 1) {
                rightHeap.add(leftHeap.poll());
            } else if (rightHeap.size() > leftHeap.size()) {
                leftHeap.add(rightHeap.poll());
            }

            result.append(leftHeap.peek()).append("\n");
        }
        System.out.println(result);
    }
}
