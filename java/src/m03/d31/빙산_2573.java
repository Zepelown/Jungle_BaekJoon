package m03.d31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//시작 09:40
// 끝 11:23
public class 빙산_2573 {
    private static int row, col;
    private static int[][] graph;
    private static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static ArrayList<Node> nodes;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                .toArray();
        row = s[0];
        col = s[1];
        graph = new int[row][col];
        nodes = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            int[] status = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                    .toArray();
            graph[i] = status;
            for (int j = 0; j < status.length; j++) {
                if (graph[i][j] != 0) {
                    nodes.add(new Node(i, j, graph[i][j]));
                }
            }
        }
        int time = 0;
        while (true) {
            visited = new boolean[row][col];

            oneYearLater();
            time++;

            int count = 0;
            for (var i : nodes) {
                if (!visited[i.x][i.y] && i.height != 0) {
                    dfs(i.x, i.y);
                    count++;
                }
            }
//            System.out.printf(Arrays.toString(graph));
            if (count >= 2) {
                break;
            }
            if (nodes.isEmpty()){
                System.out.println(0);
                return;
            }

        }
        System.out.println(time);
    }

    private static void oneYearLater() {
        for (var node : nodes) {
            if (node.height == 0) {
                continue;
            }
            if (node.closeZeroAmount != 4) {
                int newCloseZeroAmount = 0;
                for (int i = 0; i < 4; i++) {
                    int nextX = node.x + dir[i][0];
                    int nextY = node.y + dir[i][1];
                    if (checkOutOfGraph(nextX, nextY)) {
                        continue;
                    }
                    if (graph[nextX][nextY] == 0) {
                        newCloseZeroAmount++;
                    }
                }
                node.closeZeroAmount = newCloseZeroAmount;
            }
            if (node.height < node.closeZeroAmount) {
                node.height = 0;
            } else {
                node.height -= node.closeZeroAmount;
            }
        }

        Iterator<Node> iterator = nodes.iterator();
        while (iterator.hasNext()) {
            Node node = iterator.next();
            if (node.height == 0) {
                iterator.remove();
            }
            graph[node.x][node.y] = node.height;
        }
    }

    private static void dfs(int startX, int startY) {
        Deque<Position> stack = new ArrayDeque<>();
        visited[startX][startY] = true;
        stack.add(new Position(startX, startY));
        while (!stack.isEmpty()) {
            Position position = stack.pollLast();
            for (int i = 0; i < 4; i++) {
                int nextX = position.x + dir[i][0];
                int nextY = position.y + dir[i][1];
                if (graph[nextX][nextY] == 0
                        || checkOutOfGraph(nextX, nextY)
                        || visited[nextX][nextY]) {
                    continue;
                }
                stack.add(new Position(nextX, nextY));
                visited[nextX][nextY] = true;
            }
        }
    }

    private static boolean checkOutOfGraph(int x, int y) {
        return x < 0 || y < 0 || x >= row || y >= col;
    }

    private static class Node implements Comparable<Node> {
        int x;
        int y;
        int height;
        int closeZeroAmount = 0;

        public Node(int x, int y, int height) {
            this.x = x;
            this.y = y;
            this.height = height;
        }

        @Override
        public int compareTo(Node o) {
            int compare = Integer.compare(x, o.x);
            if (compare == 0) {
                return Integer.compare(y, o.y);
            }
            return compare;
        }
    }

    private static class Position {
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
