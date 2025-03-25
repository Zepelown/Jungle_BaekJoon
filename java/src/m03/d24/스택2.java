package m03.d24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 스택2 {
    private static StringBuilder result = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack stack = new Stack();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i <n; i++) {
            String[] l = br.readLine().split(" ");
            if (l.length >= 2) {
                stack.push(Integer.parseInt(l[1]));
                continue;
            }
            switch (l[0]) {
                case "pop":
                    stack.pop();
                    break;
                case "size":
                    stack.size();
                    break;
                case "empty":
                    stack.empty();
                    break;
                case "top":
                    stack.top();
                    break;
                default:
                    System.out.println("에러");
                    break;
            }
        }
        System.out.println(result);

    }

    private static class Stack{
        private final int MAX_SIZE = 10001;
        private int[] arr = new int[MAX_SIZE];
        private int size = 0;

        public void push(int data){
            arr[size] = data;
            size++;
        }
        public void pop(){
            if (size == 0){
                result.append(-1).append("\n");
                return;
            }
            result.append(arr[--size]).append("\n");
        }
        public void size(){
            result.append(size).append("\n");
        }
        public void empty(){
            if (size == 0){
                result.append(1).append("\n");
                return;
            }
            result.append(0).append("\n");
        }
        public void top(){
            if (size == 0){
                result.append(-1).append("\n");
                return;
            }
            result.append(arr[size-1]).append("\n");
        }
    }
}
