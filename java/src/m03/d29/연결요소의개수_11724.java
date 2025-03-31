package m03.d29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class 연결요소의개수_11724 {
    private static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    private static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int v = s[0];
        int e = s[1];

        for (int i = 0; i < v; i++) {
            graph.add(new ArrayList<>());
        }
        visited = new boolean[v];

        for (int i = 0; i < e; i++) {
            int[] edge = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            graph.get(edge[0]-1).add(edge[1]-1);
            graph.get(edge[1]-1).add(edge[0]-1);
        }
        int result = 0;
        for (int i = 0; i < v; i++) {
            if (!visited[i]){
                dfs(i);
                result++;
            }

        }
        System.out.println(result);
    }
    private static void dfs(int start){
        visited[start] = true;
        for (var i : graph.get(start)){
            if (!visited[i]){
                dfs(i);
            }
        }
    }
}
