package m03.d31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class 아침_산책_21606 {
    private static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    private static char[] paths;
    private static int outInResult = 0;
    private static int inInResult = 0;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine());
        paths = br.readLine().toCharArray();
        visited = new boolean[v];
        for (int i = 0; i < v; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < v - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            graph.get(start).add(end);
            graph.get(end).add(start);
            if (paths[start] == '1' && paths[end] == '1') {
                inInResult += 2;
            }
        }

        for (int i = 0; i < v; i++) {
            if (paths[i] == '0' && !visited[i]) {
                int res = dfs(i);
                outInResult += res * (res - 1);
            }
        }
        System.out.println(outInResult + inInResult);
    }

    private static int dfs(int start) {
        //첫 시작점은 위에서 검사한다는 가정
        Deque<Integer> stack = new ArrayDeque<>();
        stack.add(start);
        int result = 0;
        while (!stack.isEmpty()) {
            int pop = stack.pop();
            for (int neighbor : graph.get(pop)) {
                if (paths[neighbor] == '0') {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        stack.push(neighbor);
                    }
                } else {
                    result++;
                }
            }
        }
        return result;
    }
}
