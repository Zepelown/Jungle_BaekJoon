package m04.test.d03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;

public class Second {
    private static int[][] graph;
    private static int n;
    private static boolean[][] visited;
    private static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static ArrayList<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            char[] array = br.readLine().toCharArray();
            for (int j = 0; j < array.length; j++) {
                graph[i][j] = Integer.parseInt(String.valueOf(array[j]));
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && graph[i][j] == 1){
                    result.add(dfs(i,j));
                }
            }
        }
        Collections.sort(result);
        StringBuilder res = new StringBuilder();
        res.append(result.size()).append("\n");
        for (var i : result){
            res.append(i).append("\n");
        }
        System.out.println(res);
    }

    private static int dfs(int startX, int startY) {
        ArrayDeque<Node> stack = new ArrayDeque<>();
        int result = 0;
        visited[startX][startY] = true;
        stack.addLast(new Node(startX, startY));
        while (!stack.isEmpty()) {
            Node poll = stack.pollLast();
            result++;
            for (int i = 0; i < 4; i++) {
                int nextX = poll.x + dir[i][0];
                int nextY = poll.y + dir[i][1];
                if (!check(nextX, nextY)) {
                    continue;
                }
                stack.addLast(new Node(nextX,nextY));
                visited[nextX][nextY] = true;
            }
        }

        return result;
    }

    private static boolean check(int x, int y) {
        if (x < 0 || y < 0 || x >= n || y >= n || visited[x][y] || graph[x][y] == 0) {
            return false;
        }
        return true;
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
