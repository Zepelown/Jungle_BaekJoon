package m03.d25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class 가운데를_말해요_1655_2 {
    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        MinHeap minHeap = new MinHeap();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            minHeap.insert(num);
        }
        minHeap.printHeap();
        System.out.println(result);
    }

    private static class MinHeap{
        private int[] arr = new int[100002];
        private int size = 0;

        public void insert(int data){
            arr[++size] = data; // 새로운 데이터를 힙의 마지막에 추가
            heapify(size); // 위로 힙 정렬 수행
        }

        public void printHeap() {
            for (int i = 1; i <= size; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
        private void heapify(int index){
            while (index > 1 && arr[index] < arr[parent(index)]) { // 부모보다 작으면 교환
                swap(index, parent(index));
                index = parent(index); // 부모 인덱스로 이동
            }
        }
        private void swap(int index, int anotherIndex){
            int temp = arr[index];
            arr[index] = arr[anotherIndex];
            arr[anotherIndex] = temp;
        }
        private int parent(int index){
            return index / 2;
        }
        private int leftChild(int index){
            return index * 2;
        }
        private int rightChild(int index){
            return index *2 + 1;
        }
    }
}
