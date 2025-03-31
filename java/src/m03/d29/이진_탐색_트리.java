package m03.d29;

public class 이진_탐색_트리 {
    public static void main(String[] args) {
        BST tree = new BST();
        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);

        System.out.println("삭제 전 중위순회:");
        tree.inorder(tree.root);  // 20 30 40 50 70

        tree.delete(30);
        System.out.println("\n30 삭제 후:");
        tree.inorder(tree.root);  // 20 40 50 70
    }

    private static class BST {
        Node root;

        public void delete(int data) {
            root = deleteRec(root, data);
        }

        public void insert(int data) {
            root = insertRec(root, data);
        }

        public void inorder(Node node){
            if (node == null){
                return;
            }
            inorder(node.left);
            System.out.print(node.data + " ");
            inorder(node.right);
        }

        private Node deleteRec(Node root, int data) {
            if (root == null) return root;

            if (data < root.data)
                root.left = deleteRec(root.left, data);
            else if (data > root.data)
                root.right = deleteRec(root.right, data);
            else {
                // Case 1: 자식이 없는 노드
                if (root.left == null && root.right == null)
                    return null;

                // Case 2: 하나의 자식을 가진 노드
                if (root.left == null)
                    return root.right;
                else if (root.right == null)
                    return root.left;

                // Case 3: 두 개의 자식을 가진 노드
                root.data = minValue(root.right); // 후계자 값 복사
                root.right = deleteRec(root.right, root.data); // 후계자 삭제
            }
            return root;
        }

        private int minValue(Node root) {
            int minv = root.data;
            while (root.left != null) {
                minv = root.left.data;
                root = root.left;
            }
            return minv;
        }

        // 삽입 메서드 (재귀적 구현)
        private Node insertRec(Node root, int data) {
            if (root == null) {
                root = new Node(data);
                return root;
            }
            if (data < root.data)
                root.left = insertRec(root.left, data);
            else if (data > root.data)
                root.right = insertRec(root.right, data);
            return root;
        }


    }

    private static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }


}
