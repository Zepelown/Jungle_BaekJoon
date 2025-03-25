package m03.d24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class 원의영역_10000_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Position> positions = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int[] circle = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int center = circle[0];
            int r = circle[1];
            positions.add(new Position(center - r, '('));
            positions.add(new Position(center + r, ')'));
        }
        Collections.sort(positions);

        int result = 1;
        Stack<Position> stack = new Stack<>();
        for (int i = 0; i < positions.size(); i++) {
            Position current = positions.get(i);
            if (current.type == '(') { // 시작점
                if (!stack.isEmpty() && stack.peek().x == current.x) {
                    stack.peek().isConnected = true; // 접촉 여부 설정
                }
                stack.push(current);
                continue;
            }
            Position prev = stack.peek();
            if (prev.isConnected){
                result += 2;
            } else {
                result ++;
            }
            stack.pop();
            if (!stack.isEmpty() && i + 1 < positions.size()) {
                Position next = positions.get(i + 1);
                if (next.x != current.x) {
                    stack.peek().isConnected = false;
                }
            }
        }

        System.out.println(result);
    }

    private static class Position implements Comparable<Position> {
        int x;
        char type;
        boolean isConnected = false;

        public Position(int x, char type) {
            this.x = x;
            this.type = type;
        }

        @Override
        public int compareTo(Position o) {
            int compare = Integer.compare(this.x, o.x);
            if (compare == 0) {
                return -Character.compare(this.type, o.type);
            }
            return compare;
        }
    }
}
