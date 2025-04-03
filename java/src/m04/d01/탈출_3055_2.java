package m04.d01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class 탈출_3055_2 {
    private static int row, col;
    private static char[][] graph;
    private static int[][] dir = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    private static boolean[][] visited;
    private static boolean canReach = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                .toArray();
        row = s[0];
        col = s[1];
        graph = new char[row][col];
        Node startNode = null, endNode = null;
        for (int i = 0; i < row; i++) {
            char[] array = br.readLine().toCharArray();
            graph[i] = array;
            for (int j = 0; j < array.length; j++) {
                if (array[j] == 'S') {
                    startNode = new Node(i, j);
                } else if (array[j] == 'D') {
                    endNode = new Node(i, j);
                }
            }
        }
        int waterBfsTime = waterBfs(endNode);
        int bfsTime = bfs(startNode, endNode);
        if (canReach) {
            //무조건 고슴도치 bfs가 통함
            System.out.println(bfsTime);
        } else {
            if (waterBfsTime < bfsTime) {
                System.out.println("KAKTUS");
            } else {
                System.out.println(bfsTime);
            }
        }
    }

    private static int bfs(Node startNode, Node endNode) {
        Deque<Node> deque = new ArrayDeque<>();
        visited = new boolean[row][col];
        int time = 0;
        deque.add(startNode);
        while (!deque.isEmpty()) {
            int nodeDequeSize = deque.size();
            for (int i = 0; i < nodeDequeSize; i++) {
                Node node = deque.pollFirst();
                if (node.x == endNode.x && node.y == endNode.y) {
                    return time;
                }
                for (int j = 0; j < 4; j++) {
                    int nextX = node.x + dir[j][0];
                    int nextY = node.y + dir[j][1];
                    if (nextX < 0 || nextY < 0 || nextX >= row
                            || nextY >= col || graph[nextX][nextY] == '*'
                            || graph[nextX][nextY] == 'X'
                            || visited[nextX][nextY]) {
                        continue;
                    }
                    deque.add(new Node(nextX, nextY));
                }
            }
            time++;
        }
        return time;
    }

    private static int waterBfs(Node endNode) {
        Deque<Node> deque = new ArrayDeque<>();
        visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (graph[i][j] == '*') {
                    deque.add(new Node(i, j));
                    visited[i][j] = true;
                }
            }
        }
        int time = 0;
        while (countEndNearBlank(endNode) < 4 && !deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                Node node = deque.pollFirst();
                for (int j = 0; j < 4; j++) {
                    int nextX = node.x + dir[j][0];
                    int nextY = node.y + dir[j][1];
                    if (nextX < 0 || nextY < 0 || nextX >= row
                            || nextY >= col || graph[nextX][nextY] != '.' || visited[nextX][nextY]) {
                        continue;
                    }
                    visited[nextX][nextY] = true;
                    deque.add(new Node(nextX, nextY));
                }
            }
            time++;
        }
        if (countEndNearBlank(endNode) != 4) {
            canReach = true;
        }
        return time;
    }

    private static int countEndNearBlank(Node endNode) {
        int countNotBlank = 0;
        for (int i = 0; i < 4; i++) {
            int nextX = endNode.x + dir[i][0];
            int nextY = endNode.y + dir[i][1];
            if (nextX < 0 || nextY < 0 || nextX >= row
                    || nextY >= col || graph[nextX][nextY] != '.'
                    || visited[nextX][nextY]) {
                countNotBlank++;
            }
        }
        return countNotBlank;
    }

    private static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
