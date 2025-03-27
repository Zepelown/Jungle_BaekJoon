package m03.d26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 막대기_17608 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            stack.push(num);
        }
        int front = 0;
        int result = 0;
        while (!stack.isEmpty()){
            Integer pop = stack.pop();
            if (front >= pop){
                continue;
            }
            front = pop;
            result++;
        }
        System.out.println(result);
    }
}
