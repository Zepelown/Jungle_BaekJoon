package m03.d25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class 최대_힙_11279 {
    static StringBuilder result = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Float> queue = new PriorityQueue<>(Collections.reverseOrder());
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++){
            float num = Float.parseFloat(br.readLine());
            if(num != 0.0){
                queue.add(num);
                continue;
            }
            if(queue.isEmpty()){
                result.append(0).append("\n");
                continue;
            }
            result.append(Math.round(queue.poll())).append("\n");
        }
        System.out.println(result);
    }
}
