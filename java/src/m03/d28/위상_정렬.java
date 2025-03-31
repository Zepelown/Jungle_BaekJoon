package m03.d28;

import java.util.*;

public class 위상_정렬 {
    private static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    private static final int MAX_SIZE = 6; // 정점 개수
    private static int[] inDegrees = new int[MAX_SIZE];

    public static void main(String[] args) {
        // 그래프 초기화
        for (int i = 0; i < MAX_SIZE; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선 정보 추가 (유향 그래프)
        addEdge(5, 2);
        addEdge(5, 0);
        addEdge(4, 0);
        addEdge(4, 1);
        addEdge(2, 3);
        addEdge(3, 1);

        // 진입 차수 계산
        for (int i = 0; i < MAX_SIZE; i++) {
            for (int neighbor : graph.get(i)) {
                inDegrees[neighbor]++;
            }
        }

        // 위상 정렬 수행
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new ArrayDeque<>();

        // 진입 차수가 0인 노드 큐에 추가
        for (int i = 0; i < inDegrees.length; i++) {
            if (inDegrees[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.add(node);

            for (int neighbor : graph.get(node)) {
                inDegrees[neighbor]--;
                if (inDegrees[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        // 사이클 검출
        if (result.size() != MAX_SIZE) {
            System.out.println("사이클 발생: 위상 정렬 불가능");
            return;
        }

        // 결과 출력
        System.out.println("위상 정렬 결과: " + result);
    }

    private static void addEdge(int from, int to) {
        graph.get(from).add(to);
    }
}
