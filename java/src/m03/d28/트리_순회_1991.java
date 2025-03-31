package m03.d28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class 트리_순회_1991 {
    static HashMap<String, Node> tree = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            String parent = s[0];
            String left = s[1];
            String right = s[2];
            tree.put(parent,new Node(left, right));
        }
        first("A");
        System.out.println();
        second("A");
        System.out.println();
        last("A");

    }

    public static void first(String start){
        if (start.equals(".")){
            return;
        }
        System.out.print(start);
        first(tree.get(start).left);
        first(tree.get(start).right);
    }
    public static void second(String start){
        if (start.equals(".")){
            return;
        }
        second(tree.get(start).left);
        System.out.print(start);
        second(tree.get(start).right);
    }

    public static void last(String start){
        if (start.equals(".")){
            return;
        }
        last(tree.get(start).left);
        last(tree.get(start).right);
        System.out.print(start);
    }

    private static class Node {
        String left;
        String right;

        public Node(String left, String right) {
            this.left = left;
            this.right = right;
        }
    }
}
