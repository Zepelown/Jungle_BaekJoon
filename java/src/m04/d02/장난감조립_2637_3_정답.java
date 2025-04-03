package m04.d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 장난감조립_2637_3_정답 {
    private static ArrayList<ArrayList<Node>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());
        for (int i = 0; i < v; i++) {
            graph.add(new ArrayList<>());
        }
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < v; i++) {
            map.put(i, true);
        }
        for (int i = 0; i < e; i++) {
            int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                    .toArray();
            int end = s[1] - 1;
            int start = s[0] - 1;
            int cost = s[2];
            map.put(start, false);
            graph.get(start).add(new Node(end, cost));
        }
        int[] inDegrees = new int[v];
        for (int i = 0; i < v; i++) {
            for (var j : graph.get(i)) {
                inDegrees[j.end]++;
            }
        }

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(v - 1);
        ArrayList<Integer> arr = new ArrayList<>();
        while (!queue.isEmpty()) {
            int poll = queue.poll();
            arr.add(poll);
            for (var i : graph.get(poll)) {
                inDegrees[i.end]--;
                if (inDegrees[i.end] == 0) {
                    queue.add(i.end);
                }
            }
        }
        int[] dp = new int[v];
        dp[v - 1] = 1;
        for (var i : arr) {
            for (var j : graph.get(i)) {
                dp[j.end] = dp[j.end] + dp[i] * j.cost;
            }
        }
        for (var i : map.entrySet()) {
            if (i.getValue()) {
                System.out.println((i.getKey() + 1) + " " + dp[i.getKey()]);
            }
        }
    }

    private static class Node {
        int end;
        int cost;

        public Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
    }
}
