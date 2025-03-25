package m03.d24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class 카드2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new ArrayDeque<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++){
            queue.add(i+1);
        }
        while (queue.size() != 1){
            queue.poll();
            Integer front = queue.poll();
            queue.add(front);
        }
        System.out.println(queue.peek());
    }
}
