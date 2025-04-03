package m04.test.d03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class First {
    private static int row, col;
    private static char[][] graph;
    private static boolean[][] visited;
    private static int[] dirGaro = {0,1};
    private static int[] dirSero = {1,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                .toArray();
        row = s[0];
        col = s[1];
        graph = new char[row][col];
        visited = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            char[] array = br.readLine().toCharArray();
            graph[i] = array;
        }
        int result = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!visited[i][j]){
                    result+= bfs(i, j);
                }
            }
        }
        System.out.println(result);
    }
    private static int bfs(int startX, int startY){
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(startX, startY));
        visited[startX][startY] = true;
        int result = 1;
        while (!queue.isEmpty()){
            Node poll = queue.poll();
            int nextX, nextY;
            switch (graph[poll.x][poll.y]){
                case '-':
                    nextX = poll.x + dirGaro[0];
                    nextY = poll.y + dirGaro[1];
                    if (!check(nextX,nextY)|| graph[nextX][nextY] != '-'){
                        continue;
                    }
                    queue.add(new Node(nextX,nextY));
                    visited[nextX][nextY] = true;
                    break;
                case '|':
                    nextX = poll.x + dirSero[0];
                    nextY = poll.y + dirSero[1];
                    if (!check(nextX,nextY)|| graph[nextX][nextY] != '|'){
                        continue;
                    }
                    queue.add(new Node(nextX,nextY));
                    visited[nextX][nextY] = true;
                    break;
            }
        }
        return result;
    }
    private static boolean check(int x, int y){
        if (x < 0 || y < 0 || x >= row || y >= col || visited[x][y]){
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
