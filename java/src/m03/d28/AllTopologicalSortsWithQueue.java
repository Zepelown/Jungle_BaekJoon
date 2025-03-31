package m03.d28;

import java.util.*;

public class AllTopologicalSortsWithQueue {
    public static void main(String[] args) {
        // 그래프 정의
        Map<String, List<String>> graph = new HashMap<>();
        graph.put("A", Arrays.asList("B", "C"));
        graph.put("B", Arrays.asList("D"));
        graph.put("C", Arrays.asList("D"));
        graph.put("D", Arrays.asList());

        // 모든 가능한 위상 정렬 결과를 저장할 리스트
        List<List<String>> totalResult = new ArrayList<>();

        // 진입 차수 계산
        Map<String, Integer> inDegree = new HashMap<>();
        for (String node : graph.keySet()) {
            inDegree.put(node, 0);
        }
        for (String node : graph.keySet()) {
            for (String neighbor : graph.get(node)) {
                inDegree.put(neighbor, inDegree.get(neighbor) + 1);
            }
        }

        // 모든 가능한 위상 정렬 탐색
        findAllTopologicalSorts(graph, inDegree, new ArrayList<>(), totalResult);

        // 결과 출력
        System.out.println("모든 가능한 위상 정렬 결과:");
        for (List<String> result : totalResult) {
            System.out.println(result);
        }
    }

    static void findAllTopologicalSorts(Map<String, List<String>> graph, Map<String, Integer> inDegree,
                                        List<String> currentPath, List<List<String>> totalResult) {
        boolean hasNextNode = false;

        // 진입 차수가 0인 노드를 모두 탐색
        for (String node : inDegree.keySet()) {
            if (inDegree.get(node) == 0) { // 선택 가능한 노드
                hasNextNode = true;

                // 현재 노드를 선택하고 상태 업데이트
                currentPath.add(node);
                inDegree.put(node, -1); // 방문 표시

                // 선택한 노드의 인접 노드들의 진입 차수를 감소시킴
                for (String neighbor : graph.getOrDefault(node, Collections.emptyList())) {
                    inDegree.put(neighbor, inDegree.get(neighbor) - 1);
                }

                // 재귀 호출로 다음 단계 탐색
                findAllTopologicalSorts(graph, inDegree, currentPath, totalResult);

                // 상태 복구 (백트래킹)
                currentPath.remove(currentPath.size() - 1);
                inDegree.put(node, 0); // 방문 해제
                for (String neighbor : graph.getOrDefault(node, Collections.emptyList())) {
                    inDegree.put(neighbor, inDegree.get(neighbor) + 1);
                }
            }
        }

        // 더 이상 선택할 노드가 없으면 현재 경로를 결과에 추가
        if (!hasNextNode && currentPath.size() == inDegree.size()) {
            totalResult.add(new ArrayList<>(currentPath));
        }
    }
}
