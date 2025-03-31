package m03.d28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DFS와_BFS_1260_ {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int v = s[0];
        int e = s[1];
        int start = s[2];
        Graph graph = new Graph(v, e);

        for (int i = 0; i < e; i++) {
            int[] s1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int st = s1[0];
            int end = s1[1];
            graph.push(st - 1, end - 1);
        }
        graph.dfs(start - 1);
        graph.bfs(start - 1);
    }

    private static class Graph {
        private ArrayList<ArrayList<Integer>> graph;

        public Graph(int v, int e) {
            graph = new ArrayList<>();
            for (int i = 0; i < v; i++) {
                graph.add(new ArrayList<>());
            }
        }

        public void push(int start, int end) {
            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        public void dfs(int start) {
            sort();
            Stack<Integer> stack = new Stack<>();
            boolean[] visited = new boolean[graph.size()];
            stack.add(start);
            StringBuilder result = new StringBuilder();
            while (!stack.isEmpty()) {
                int pop = stack.pop();
                if (!visited[pop]){ //dfs는 노드를 처리할 때(스택에서 꺼낼 때) 방문 처리
                    result.append(pop + 1).append(" ");
                    visited[pop] = true;
                    // 스택 기반으로 작성할 때, 재귀와 똑같은 순서를 맞추기 위해 역순으로 삽입해야 한다.
                    for (int i = graph.get(pop).size() - 1; i >= 0; i--) {
                        int neighbor = graph.get(pop).get(i);
                        if (!visited[neighbor]) {       // 방문하지 않은 노드만 추가
                            stack.push(neighbor);
                        }
                    }
                }


            }
            System.out.println(result);
        }

        public void bfs(int start) {
            Queue<Integer> queue = new ArrayDeque<>();
            boolean[] visited = new boolean[graph.size()];
            queue.add(start);
            visited[start] = true;
            StringBuilder result = new StringBuilder();
            while (!queue.isEmpty()) {
                int poll = queue.poll();
                result.append(poll + 1).append(" ");
                for (int i : graph.get(poll)) {
                    if (!visited[i]) {
                        queue.add(i);
                        visited[i] = true;
                    }
                }
            }
            System.out.println(result);
        }

        private void sort() {
            for (var i : graph) {
                Collections.sort(i);
            }
        }

    }
}
