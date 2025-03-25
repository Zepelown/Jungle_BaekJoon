package m03.d24;

public class 연결리스트 {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        // 요소 추가
        linkedList.add(10);
        linkedList.add(20);
        linkedList.add(30);

        System.out.println("Initial List:");
        linkedList.printList(); // 출력: 10 -> 20 -> 30 -> null

        // 특정 위치에 요소 추가
        linkedList.add(1, 15);

        System.out.println("After adding at index 1:");
        linkedList.printList(); // 출력: 10 -> 15 -> 20 -> 30 -> null

        // 특정 값 제거
        linkedList.remove(20);

        System.out.println("After removing value 20:");
        linkedList.printList(); // 출력: 10 -> 15 -> 30 -> null

        // 특정 위치 제거
        linkedList.removeAt(1);

        System.out.println("After removing at index 1:");
        linkedList.printList(); // 출력: 10 -> 30 -> null

        // 특정 값 포함 여부 확인
        System.out.println("Contains value 30? " + linkedList.contains(30)); // true

        // 특정 위치의 값 반환
        System.out.println("Value at index 1: " + linkedList.get(1)); // 출력: 30

        // 연결 리스트 크기 확인
        System.out.println("Size of list: " + linkedList.size()); // 출력: 2
    }
    static class LinkedList {
        // Node 클래스 정의
        static class Node {
            int value;      // 노드의 값
            Node next;      // 다음 노드를 가리키는 참조

            Node(int value) {
                this.value = value;
                this.next = null;
            }
        }

        private Node head;  // 연결 리스트의 시작 노드
        private int size;   // 연결 리스트의 크기

        public LinkedList() {
            this.head = null;
            this.size = 0;
        }

        // 1. 요소 추가 (끝에 추가)
        public void add(int value) {
            Node newNode = new Node(value);
            if (head == null) {
                head = newNode; // 첫 번째 노드 설정
            } else {
                Node current = head;
                while (current.next != null) {
                    current = current.next; // 마지막 노드까지 이동
                }
                current.next = newNode; // 새로운 노드를 마지막에 추가
            }
            size++;
        }

        // 2. 요소 추가 (특정 위치에 추가)
        public void add(int index, int value) {
            if (index < 0 || index > size) {
                throw new IndexOutOfBoundsException("Index out of bounds");
            }

            Node newNode = new Node(value);
            if (index == 0) { // 첫 번째 위치에 추가
                newNode.next = head;
                head = newNode;
            } else {
                Node current = head;
                for (int i = 0; i < index - 1; i++) {
                    current = current.next; // 삽입 위치 직전까지 이동
                }
                newNode.next = current.next;
                current.next = newNode;
            }
            size++;
        }

        // 3. 요소 제거 (특정 값 제거)
        public boolean remove(int value) {
            if (head == null) return false;

            if (head.value == value) { // 첫 번째 노드가 제거 대상인 경우
                head = head.next;
                size--;
                return true;
            }

            Node current = head;
            while (current.next != null && current.next.value != value) {
                current = current.next; // 제거 대상 직전까지 이동
            }

            if (current.next == null) return false; // 값이 없는 경우

            current.next = current.next.next; // 제거 대상 건너뛰기
            size--;
            return true;
        }

        // 4. 요소 제거 (특정 위치 제거)
        public int removeAt(int index) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException("Index out of bounds");
            }

            int removedValue;

            if (index == 0) { // 첫 번째 노드 제거
                removedValue = head.value;
                head = head.next;
            } else {
                Node current = head;
                for (int i = 0; i < index - 1; i++) {
                    current = current.next; // 제거 대상 직전까지 이동
                }
                removedValue = current.next.value;
                current.next = current.next.next;
            }

            size--;
            return removedValue;
        }

        // 5. 특정 값 포함 여부 확인
        public boolean contains(int value) {
            Node current = head;
            while (current != null) {
                if (current.value == value) return true;
                current = current.next;
            }
            return false;
        }

        // 6. 특정 위치의 값 반환
        public int get(int index) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException("Index out of bounds");
            }

            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.next; // 원하는 위치까지 이동
            }

            return current.value;
        }

        // 7. 연결 리스트 크기 반환
        public int size() {
            return size;
        }

        // 8. 연결 리스트 출력
        public void printList() {
            Node current = head;
            while (current != null) {
                System.out.print(current.value + " -> ");
                current = current.next;
            }
            System.out.println("null");
        }


    }


}
