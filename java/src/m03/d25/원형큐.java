package m03.d25;

public class 원형큐 {
    public static class CircularQueue {
        private int[] queue;  // 큐를 저장할 배열
        private int front;    // 큐의 첫 번째 요소를 가리키는 포인터
        private int rear;     // 큐의 마지막 요소를 가리키는 포인터
        private int size;     // 큐의 최대 크기

        // 생성자: 큐의 크기를 초기화
        public CircularQueue(int size) {
            this.size = size;
            this.queue = new int[size];
            this.front = -1;  // 초기에는 비어있으므로 -1로 설정
            this.rear = -1;
        }

        // 큐가 비어있는지 확인
        public boolean isEmpty() {
            return front == -1;
        }

        // 큐가 가득 찼는지 확인
        public boolean isFull() {
            return (rear + 1) % size == front;
        }

        // 요소 삽입 (enqueue)
        public void enQueue(int element) {
            if (isFull()) {
                System.out.println("Queue is full");
                return;
            }
            if (isEmpty()) {  // 첫 번째 삽입 시 front를 0으로 설정
                front = 0;
            }
            rear = (rear + 1) % size;  // rear를 순환하도록 설정
            queue[rear] = element;
            System.out.println("Inserted: " + element);
        }

        // 요소 제거 (dequeue)
        public int deQueue() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            int element = queue[front];
            if (front == rear) {  // 큐에 하나의 요소만 남아있을 경우 초기 상태로 재설정
                front = -1;
                rear = -1;
            } else {
                front = (front + 1) % size;  // front를 순환하도록 설정
            }
            System.out.println("Removed: " + element);
            return element;
        }

        // 큐의 내용을 출력
        public void display() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return;
            }
            System.out.print("Queue elements: ");
            int i = front;
            while (true) {
                System.out.print(queue[i] + " ");
                if (i == rear) break;  // rear에 도달하면 출력 종료
                i = (i + 1) % size;   // 인덱스를 순환하도록 설정
            }
            System.out.println();
        }

        public static void main(String[] args) {
            CircularQueue cq = new CircularQueue(5);

            cq.enQueue(10);
            cq.enQueue(20);
            cq.enQueue(30);
            cq.enQueue(40);
            cq.enQueue(50);

            cq.display();

            cq.deQueue();
            cq.deQueue();

            cq.display();

            cq.enQueue(60);
            cq.enQueue(70);

            cq.display();
        }
    }

}
