package m03.d31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 이분_그래프_1707 {
    private static ArrayList<ArrayList<Integer>> graph;
    private static int[] color; // 0: 미방문, 1: 첫 번째 색상, 2: 두 번째 색상

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken()); // 정점 수
            int e = Integer.parseInt(st.nextToken()); // 간선 수

            graph = new ArrayList<>();
            for (int j = 0; j <= v; j++) { // 1-based index
                graph.add(new ArrayList<>());
            }
            color = new int[v + 1]; // 정점 번호는 1부터 시작

            for (int j = 0; j < e; j++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                graph.get(start).add(end);
                graph.get(end).add(start); // 무방향 그래프
            }

            boolean isBipartite = true;

            // 모든 정점에 대해 DFS 수행 (연결 요소 처리)
            for (int j = 1; j <= v; j++) {
                if (color[j] == 0) { // 아직 방문하지 않은 경우
                    if (!dfs(j, 1)) { // 첫 번째 색상으로 시작
                        isBipartite = false;
                        break;
                    }
                }
            }

            System.out.println(isBipartite ? "YES" : "NO");
        }
    }

    private static boolean dfs(int node, int c) {
        color[node] = c; // 현재 노드에 색상 할당

        for (int neighbor : graph.get(node)) {
            if (color[neighbor] == 0) { // 아직 방문하지 않은 경우
                if (!dfs(neighbor, 3 - c)) { // 현재 색상의 반대색으로 칠함
                    return false;
                }
            } else if (color[neighbor] == color[node]) { // 인접한 노드와 같은 색이면 이분 그래프 아님
                return false;
            }
        }

        return true;
    }
}
