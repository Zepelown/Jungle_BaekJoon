package m03.d24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 최대힙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    }

    public static class MaxHeap {
        private int[] heap;
        private int size;
        private int maxSize;

        // Constructor
        public MaxHeap(int maxSize) {
            this.maxSize = maxSize;
            this.size = 0;
            heap = new int[this.maxSize + 1];
            heap[0] = Integer.MAX_VALUE; // Sentinel value for easier comparisons
        }

        // Helper methods
        private int parent(int pos) { return pos / 2; }
        private int leftChild(int pos) { return 2 * pos; }
        private int rightChild(int pos) { return (2 * pos) + 1; }
        private void swap(int fpos, int spos) {
            int temp = heap[fpos];
            heap[fpos] = heap[spos];
            heap[spos] = temp;
        }

        // Insert an element into the heap
        public void insert(int element) {
            if (size >= maxSize) return; // Heap is full
            heap[++size] = element;
            int current = size;

            // Heapify up
            while (heap[current] > heap[parent(current)]) {
                swap(current, parent(current));
                current = parent(current);
            }
        }

        // Remove and return the maximum element
        public int extractMax() {
            if (size == 0) return Integer.MIN_VALUE; // Heap is empty
            int max = heap[1];
            heap[1] = heap[size--];
            downHeapify(1);
            return max;
        }

        // Heapify down
        private void downHeapify(int pos) {
            if (pos > size / 2) return; // If it's a leaf node, stop

            int largest = pos;
            if (leftChild(pos) <= size && heap[leftChild(pos)] > heap[largest]) {
                largest = leftChild(pos);
            }
            if (rightChild(pos) <= size && heap[rightChild(pos)] > heap[largest]) {
                largest = rightChild(pos);
            }

            if (largest != pos) {
                swap(pos, largest);
                downHeapify(largest);
            }
        }

        // Print the heap
        public void print() {
            for (int i = 1; i <= size / 2; i++) {
                System.out.println("Parent: " + heap[i] +
                        " Left Child: " + (2 * i <= size ? heap[2 * i] : "null") +
                        " Right Child: " + (2 * i + 1 <= size ? heap[2 * i + 1] : "null"));
            }
        }

        public static void main(String[] args) {
            MaxHeap maxHeap = new MaxHeap(15);
            maxHeap.insert(5);
            maxHeap.insert(3);
            maxHeap.insert(17);
            maxHeap.insert(10);
            maxHeap.insert(84);
            maxHeap.insert(19);

            maxHeap.print();

            System.out.println("Max value: " + maxHeap.extractMax());
        }
    }
}
