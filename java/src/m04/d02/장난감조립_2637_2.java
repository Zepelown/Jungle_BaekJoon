package m04.d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class 장난감조립_2637_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());
        ArrayList<Node> graph = new ArrayList<>();
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < v; i++) {
            map.put(i, true);
        }
        for (int i = 0; i < e; i++) {
            int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                    .toArray();
            int end = s[1] - 1;
            int start = s[0] - 1;
            int amount = s[2];
            map.put(start,false);
            graph.add(new Node(start, end, amount));
        }
        Collections.sort(graph);
//        System.out.println(temp);
        int[] dp = new int[v];
        dp[v - 1] = 1;
        for (var i : graph) {
            dp[i.end] = dp[i.end] + dp[i.start] * i.cost;
        }
//        System.out.println(Arrays.toString(dp));
        for (var i : map.entrySet()){
            if (i.getValue()){
                System.out.println((i.getKey() + 1) + " " + dp[i.getKey()]);
            }
        }
    }

    private static class Node implements Comparable<Node> {
        int start;
        int end;
        int cost;

        public Node(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            int compare = -Integer.compare(start, o.start);
            if (compare == 0) {
                return -Integer.compare(end, o.end);
            }
            return compare;
        }
    }
}
