package m03.d28;

import java.util.*;

public class 모든_위상_정렬 {
    private static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    private static final int MAX_SIZE = 6; // 정점 개수
    private static int[] inDegrees = new int[MAX_SIZE];
    private static List<List<Integer>> allResults = new ArrayList<>(); // 모든 위상 정렬 결과 저장

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

        // 모든 가능한 위상 정렬 탐색
        findAllTopologicalSorts(new ArrayList<>());

        // 결과 출력
        System.out.println("모든 가능한 위상 정렬 결과:");
        for (List<Integer> result : allResults) {
            System.out.println(result);
        }
    }

    private static void findAllTopologicalSorts(List<Integer> currentPath) {
        boolean hasNextNode = false;

        // 현재 진입 차수가 0인 노드를 모두 탐색
        for (int i = 0; i < MAX_SIZE; i++) {
            if (inDegrees[i] == 0) { // 선택 가능한 노드
                hasNextNode = true;

                // 현재 노드를 선택하고 상태 업데이트
                currentPath.add(i);
                inDegrees[i]--; // 방문 표시

                // 선택한 노드의 인접 노드들의 진입 차수를 감소시킴
                for (int neighbor : graph.get(i)) {
                    inDegrees[neighbor]--;
                }

                // 재귀 호출로 다음 단계 탐색
                findAllTopologicalSorts(currentPath);

                // 상태 복구 (백트래킹)
                currentPath.remove(currentPath.size() - 1);
                inDegrees[i]++; // 방문 해제
                for (int neighbor : graph.get(i)) {
                    inDegrees[neighbor]++;
                }
            }
        }

        // 더 이상 선택할 노드가 없으면 현재 경로를 결과에 추가
        if (!hasNextNode && currentPath.size() == MAX_SIZE) {
            allResults.add(new ArrayList<>(currentPath));
        }
    }

    private static void addEdge(int from, int to) {
        graph.get(from).add(to);
    }
}
