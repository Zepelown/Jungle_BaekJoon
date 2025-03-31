package m03.d31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 아침_산책_21606_2 {
    private static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    private static char[] paths;
    private static int outInResult = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine());
        paths = br.readLine().toCharArray();
        for (int i = 0; i < v; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < v-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken())-1;
            int end = Integer.parseInt(st.nextToken())-1;
            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        for (int i = 0; i < v; i++) {
            if (paths[i] == '0'){
                dfs(v,i);
            }
        }
        System.out.println(outInResult);
    }
    private static void dfs(int v, int start){
        //첫 시작점은 위에서 검사한다는 가정
        Deque<Integer> stack = new ArrayDeque<>();
        boolean[] visited = new boolean[v];
        stack.add(start);
        while (!stack.isEmpty()){
            int pop = stack.pop();
            visited[pop] = true;
            if (paths[pop] == '1' && pop != start){
                outInResult++;
                continue;
            }
            for (int neighbor : graph.get(pop)) {
                if (!visited[neighbor]) {
                    stack.push(neighbor);
                }
            }
        }
    }
}
