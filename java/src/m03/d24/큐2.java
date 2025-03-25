package m03.d24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 큐2 {
    private static final StringBuilder result = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue queue = new Queue();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i <n; i++){
            String[] l = br.readLine().split(" ");
            if (l.length >= 2){
                queue.push(Integer.parseInt(l[1]));
                continue;
            }
            switch (l[0]){
                case "pop":
                    queue.pop();
                    break;
                case "size":
                    queue.size();
                    break;
                case "empty":
                    queue.empty();
                    break;
                case "front":
                    queue.front();
                    break;
                case "back":
                    queue.back();
                    break;
                default:
                    System.out.println("에러");
                    break;
            }
        }
        System.out.println(result.toString());

    }

    private static class Queue{
        private final int MAX_SIZE = 2000001;
        private final int[] arr = new int[MAX_SIZE];
        private int start = 0;
        private int end = 0;

        public void push(int data){
            arr[end] = data;
            end++;
        }
        public void pop(){
            if (start == end){
                result.append(-1).append("\n");
                return;
            }
            result.append(arr[start]).append("\n");
            start++;
        }
        public void size(){
            result.append(end - start).append("\n");
        }
        public void empty(){
            if (start == end){
                result.append(1).append("\n");
                return;
            }
            result.append(0).append("\n");
        }
        public void front(){
            if (start == end){
                result.append(-1).append("\n");
                return;
            }
            result.append(arr[start]).append("\n");
        }
        public void back(){
            if (start == end){
                result.append(-1).append("\n");
                return;
            }
            result.append(arr[end - 1]).append("\n");
        }
    }
}
