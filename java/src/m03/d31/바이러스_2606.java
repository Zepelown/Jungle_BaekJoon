package m03.d31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class 바이러스_2606 {
    private static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());
        for (int i = 0; i < v; i++) {
            graph.add(new ArrayList<>());
        }
        visited = new boolean[v];

        for (int i = 0; i < e; i++) {
            int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                    .toArray();
            int start = s[0] - 1;
            int end = s[1] - 1;
            graph.get(start).add(end);
            graph.get(end).add(start);
        }
        System.out.println(bfs(0));
    }

    private static int bfs(int start){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        visited[start] = true;
        int result = 0;
        while (!queue.isEmpty()){
            Integer poll = queue.poll();
            for (var i : graph.get(poll)){
                if (!visited[i]){
                    queue.add(i);
                    result++;
                    visited[i] = true;
                }
            }
        }
        return result;
    }

}
