package m04.d01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class 탈출_3055 {
    private static int row, col;
    private static char[][] graph;
    private static int[][] dir = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

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
                    startNode = new Node(i, j, false);
                } else if (array[j] == 'D') {
                    endNode = new Node(i, j, false);
                }
            }
        }
        bfs(startNode, endNode);
    }

    private static void bfs(Node startNode, Node endNode) {
        Deque<Node> nodeDeque = new ArrayDeque<>();
        int time = 0;
        int waterNodeSize = 0;
        //초기 물 셋팅
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (graph[i][j] == '*') {
                    nodeDeque.add(new Node(i, j, true));
                    waterNodeSize++;
                }
            }
        }

        nodeDeque.add(startNode);
        graph[startNode.x][startNode.y] = 'S';
        int nodeDequeSize = 1;
        while (true) {
            //도달을 못하는 조건
            if (nodeDeque.isEmpty()) {
                System.out.println("KAKTUS");
                return;
            }

            //물부터 퍼지게 하기
            int newWaterNodeSize=0;
            for (int i = 0; i < waterNodeSize; i++) {
                Node node = nodeDeque.pollFirst();
                for (int j = 0; j < 4; j++) {
                    int nextX = node.x + dir[j][0];
                    int nextY = node.y + dir[j][1];
                    if (nextX < 0 || nextY < 0 || nextX >= row
                            || nextY >= col || graph[nextX][nextY] != '.') {
                        continue;
                    }
                    graph[nextX][nextY] = '*';
                    nodeDeque.add(new Node(nextX, nextY, true));
                    newWaterNodeSize++;
                }
            }
            waterNodeSize = newWaterNodeSize;
            // 고슴도치 움직이기
            int newNodeSize = 0;
            for (int i = 0; i < nodeDequeSize; i++) {
                Node node = nodeDeque.pollFirst();
                if (node.x == endNode.x && node.y == endNode.y) {
                    System.out.println(time);
                    return;
                }
                for (int j = 0; j < 4; j++) {
                    int nextX = node.x + dir[j][0];
                    int nextY = node.y + dir[j][1];
                    if (nextX < 0 || nextY < 0 || nextX >= row
                            || nextY >= col || graph[nextX][nextY] == '*'
                            || graph[nextX][nextY] == 'X'
                            || graph[nextX][nextY] == 'S') {
                        continue;
                    }
                    graph[nextX][nextY] = 'S';
                    nodeDeque.add(new Node(nextX, nextY, false));
                    newNodeSize++;
                }
            }
            nodeDequeSize = newNodeSize;
            time++;
        }
    }

    private static class Node {
        int x;
        int y;
        boolean isWater;

        public Node(int x, int y, boolean isWater) {
            this.x = x;
            this.y = y;
            this.isWater = isWater;
        }
    }
}
