package m03.d31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

//11:30
public class 미로_탐색_2178 {
    private static int[][] graph;
    private static int n, m;
    private static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = s[0];
        m = s[1];
        graph = new int[n][m];
        for (int i = 0; i < n; i++) {
            char[] array = br.readLine().toCharArray();
            for (int j = 0; j < array.length; j++) {
                graph[i][j] = Integer.parseInt(String.valueOf(array[j]));
            }
        }
        System.out.println(bfs());
    }

    private static int bfs() {
        Deque<Position> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];

        visited[0][0] = true;
        queue.add(new Position(0, 0,1));
        while (!queue.isEmpty()) {
            Position poll = queue.poll();
            if (poll.x == n - 1 && poll.y == m - 1) {
                return poll.current_distance;
            }
            for (int i = 0; i < 4; i++) {
                int nextX = poll.x + dir[i][0];
                int nextY = poll.y + dir[i][1];
                if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m
                        || visited[nextX][nextY] || graph[nextX][nextY] == 0) {
                    continue;
                }
                visited[nextX][nextY] = true;
                queue.add(new Position(nextX, nextY, poll.current_distance+1));

            }
        }
        return -1;
    }

    private static class Position {
        int x;
        int y;
        int current_distance;

        public Position(int x, int y, int current_distance) {
            this.x = x;
            this.y = y;
            this.current_distance = current_distance;
        }
    }
}
