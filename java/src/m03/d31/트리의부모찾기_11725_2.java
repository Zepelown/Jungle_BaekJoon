package m03.d31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class 트리의부모찾기_11725_2 {
    private static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    private static boolean[] visited;
    private static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine());
        parents = new int[v];
        visited = new boolean[v];
        for (int i = 0; i < v; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < v - 1; i++) {
            int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                    .toArray();
            graph.get(s[0]-1).add(s[1]-1);
            graph.get(s[1]-1).add(s[0]-1);
        }
        dfs(0);
        for (int i = 1; i < parents.length; i++) {
            System.out.println(parents[i]+1);
        }
    }
    private static void dfs(int start){
        visited[start] = true;
        for (var i : graph.get(start)){
            if (!visited[i]){
                parents[i] = start;
                dfs(i);
            }
        }
    }
}
