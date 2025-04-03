package m04.d01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

//3:27
public class 미로만들기_2655 {
    private static char[][] graph;
    private static int v;
    private static int[][] dir = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        v = Integer.parseInt(br.readLine());
        graph = new char[v][v];
        for (int i = 0; i < v; i++) {
            char[] array = br.readLine().toCharArray();
            graph[i] = array;
        }
        bfs(0, 0);
    }

    private static void bfs(int startX, int startY) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        boolean[][] visited = new boolean[v][v];

        visited[startX][startY] = true;
        queue.add(new Node(startX, startY,  0));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.x == v - 1 && node.y == v - 1) {
                System.out.println(node.passCountBlackRoom);
                return;
            }
            for (int i = 0; i < 4; i++) {
                int nextX = node.x + dir[i][0];
                int nextY = node.y + dir[i][1];
                if (nextX < 0 || nextY < 0 || nextX >= v || nextY >= v
                        || visited[nextX][nextY]) {
                    continue;
                }
                if (graph[nextX][nextY] == '0') {
                    queue.add(new Node(nextX, nextY, node.passCountBlackRoom + 1));
                } else {
                    queue.add(new Node(nextX, nextY, node.passCountBlackRoom));
                }

                visited[nextX][nextY] = true;
            }
        }
    }

    private static class Node implements Comparable<Node> {
        int x;
        int y;
        int passCountBlackRoom;

        public Node(int x, int y,int passCountBlackRoom) {
            this.x = x;
            this.y = y;
            this.passCountBlackRoom = passCountBlackRoom;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(passCountBlackRoom, o.passCountBlackRoom);
        }
    }
}
