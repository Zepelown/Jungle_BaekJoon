package m04.d01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 특정거리의도시찾기_18352 {
    private static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    private static int[] distance;
    private static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int v = s[0];
        int e = s[1];
        int k = s[2];
        int x = s[3];

        for (int i = 0; i < v; i++) {
            graph.add(new ArrayList<>());
        }
        distance = new int[v];
        visited = new boolean[v];

        for (int i = 0; i < e; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            graph.get(start-1).add(end-1);
        }
        bfs(x-1);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < distance.length; i++) {
            if (distance[i] == k) {
                result.add(i + 1);
            }
        }
        if (result.isEmpty()) {
            System.out.println(-1);
        } else {
            Collections.sort(result);
            for (int city : result) {
                System.out.println(city);
            }
        }

    }
    private static void bfs(int start){
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(start);
        visited[start] = true;
        while (!deque.isEmpty()){
            Integer poll = deque.pollFirst();
            for (var i : graph.get(poll)){
                if (!visited[i]){
                    deque.add(i);
                    visited[i] = true;
                    distance[i] = distance[poll] + 1;
                }
            }
        }
    }
}
