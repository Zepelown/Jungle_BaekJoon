package m03.d25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class 요세푸스_문제_0 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new ArrayDeque<>();
        int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                .toArray();
        int n = s[0];
        int k = s[1];
        for (int i = 0; i < n; i++) {
            queue.add(i+1);
        }
        int count = 0;
        ArrayList<Integer> result = new ArrayList<>();
        while(!queue.isEmpty()){
            Integer poll = queue.poll();
            count++;
            if (count == k){
                count = 0;
                result.add(poll);
                continue;
            }
            queue.add(poll);
        }
        StringBuilder printer = new StringBuilder();
        printer.append("<");
        for (int i = 0; i < result.size(); i++){
            printer.append(result.get(i));
            if (i != n-1){
                printer.append(", ");
            }
        }
        printer.append(">");
        System.out.println(printer);
    }
}
