package m04.d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class 줄세우기_2252 {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static LinkedList<Integer> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int v = Integer.parseInt(input[0]);
        int e = Integer.parseInt(input[1]);

        visited = new boolean[v];
        for (int i = 0; i < v; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            String[] edge = br.readLine().split(" ");
            int start = Integer.parseInt(edge[0]) - 1;
            int end = Integer.parseInt(edge[1]) - 1;
            graph.get(start).add(end);
        }

        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                dfs(i);
            }
        }

        for (int node : result) {
            System.out.print((node + 1) + " ");
        }
    }

    private static void dfs(int start) {
        visited[start] = true;
        for (int next : graph.get(start)) {
            if (!visited[next]) {
                dfs(next);
            }
        }
        result.addFirst(start);
    }
}
