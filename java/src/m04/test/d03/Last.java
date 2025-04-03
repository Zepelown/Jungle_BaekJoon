package m04.test.d03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Last {
    private static int[][] graph;
    private static int n,k,s,goalX,goalY;
    private static TreeMap<Integer, List<Node>> nodes;
    private static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                .toArray();
        n = input[0];
        k = input[1];
        graph = new int[n][n];
        nodes = new TreeMap<>();
        for (int i = 1; i <= k; i++) {
            nodes.put(i,new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                    .toArray();
            for (int j = 0; j < nums.length; j++) {
                graph[i][j] = nums[j];
                if (nums[j] != 0){
                    nodes.get(nums[j]).add(new Node(i,j));
                }
            }
        }
//        System.out.println(nodes);
        input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                .toArray();
        s = input[0];
        goalX = input[1];
        goalY = input[2];

        for (int i = 0; i < s; i++) {
            for(var j :nodes.entrySet()){
                if (graph[goalX-1][goalY-1] != 0){
                    System.out.println(graph[goalX-1][goalY-1]);
                    return;
                }
                int virusNum = j.getKey();
                bfs(virusNum);
            }
        }
        System.out.println(graph[goalX-1][goalY-1]);
    }
    private static void bfs(int virusNum){
        if (nodes.get(virusNum).isEmpty()){
            return;
        }
        Queue<Node> queue = new ArrayDeque<>(nodes.get(virusNum));
        int size = nodes.get(virusNum).size();
        for (int i = 0; i < size; i++) {
            Node poll = queue.poll();
            for (int j = 0; j < 4; j++) {
                int nextX = poll.x + dir[j][0];
                int nextY = poll.y + dir[j][1];
                if (!check(nextX, nextY)) {
                    continue;
                }
                queue.add(new Node(nextX,nextY));
                graph[nextX][nextY] = virusNum;
                nodes.get(virusNum).add(new Node(nextX,nextY));
            }
        }

    }
    private static boolean check(int x, int y) {
        if (x < 0 || y < 0 || x >= n || y >= n || graph[x][y] != 0) {
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
