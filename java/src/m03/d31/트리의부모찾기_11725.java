package m03.d31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class 트리의부모찾기_11725 {
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine());
        parents = new int[v + 1];
        for (int i = 1; i <= v; i++) {
            parents[i] = i;
        }
        ArrayList<Edge> edges = new ArrayList<>();
        for (int i = 2; i <= v; i++) {
            int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                    .toArray();
            if (s[0] == 1){
                parents[s[1]] = 1;
            } else if (s[1] == 1){
                parents[s[0]] = 1;
            } else {
                edges.add(new Edge(s[0],s[1]));
            }

        }
        Collections.sort(edges);
        for (var i : edges){
            union(i.start, i.end);
        }

        for (int i = 2; i <= v; i++) {
            System.out.println(parents[i]);
        }
    }

    private static void union(int a, int b) {
        if (a == 1) {
            parents[b] = a;
        } else if (b == 1) {
            parents[a] = b;
        } else if (parents[a] != a && parents[b] == b) {
            parents[b] = a;
        } else if (parents[b] != b && parents[a] == a) {
            parents[a] = b;
        } else {
            parents[b] = a;
        }
    }
    private static class Edge implements Comparable<Edge>{
        int start;
        int end;

        public Edge(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Edge o) {
            int compare = Integer.compare(start, o.start);
            if (compare == 0){
                return Integer.compare(end,o.end);
            }
            return compare;
        }
    }
}
