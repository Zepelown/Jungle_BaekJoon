package m03.d24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class 원의영역_10000_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Circle> circles = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int[] circle = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int center = circle[0];
            int r = circle[1];
            circles.add(new Circle(center, r));
        }

        ArrayList<Position> positions = new ArrayList<>();
        for (var i : circles) {
            positions.add(new Position(i.start, '('));
            positions.add(new Position(i.end, ')'));
        }

        Collections.sort(positions);

        Stack<Position> stack = new Stack<>();
        int result = 1; // 초기 외부 영역

        for (var i : positions) {
            int x = i.x;
            char type = i.type;

            if (type == '(') {
                // 열린 괄호 처리
                if (!stack.isEmpty()) {
                    // 스택에 원이 있다면 포함 관계로 인해 내부 영역 추가
                    result++;
                }
                stack.push(i);
            } else {
                // 닫힌 괄호 처리
                stack.pop();
                if (!stack.isEmpty()) {
                    // 스택에 남아있는 원이 있다면 내부 영역 추가
                    result++;
                }
            }
        }

        System.out.println(result);
    }

    private static class Position implements Comparable<Position> {
        int x;
        char type;

        public Position(int x, char type) {
            this.x = x;
            this.type = type;
        }

        @Override
        public int compareTo(Position o) {
            int compare = Integer.compare(this.x, o.x);
            if (compare == 0) {
                return Character.compare(this.type, o.type); // 열린 괄호 우선 정렬
            }
            return compare;
        }
    }

    private static class Circle {
        int center;
        int r;
        int start;
        int end;

        public Circle(int center, int r) {
            this.center = center;
            this.r = r;
            this.start = center - r;
            this.end = center + r;
        }
    }
}
