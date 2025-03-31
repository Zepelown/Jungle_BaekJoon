package m03.d28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class 최소_스패닝_트리_1197_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int v = s[0];
        int e = s[1];
        Graph graph = new Graph(v,e);
        for (int i = 0; i < e; i++){
            int[] s1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int start = s1[0];
            int end = s1[1];
            int weight = s1[2];
            graph.push(new Edge(start,end,weight));
        }
        ArrayList<Edge> result = graph.kru(v);
        double ret = 0;
        for (var i : result){
            ret +=i.weight;
        }
        System.out.printf("%.0f",ret);
    }

    private static class Graph{
        private ArrayList<Edge> graph = new ArrayList<>();
        private int[] parents;
        public Graph(int v, int e){
            parents = new int[v+1];
            for (int i = 1; i <= v; i++) {
                parents[i] = i;
            }
        }
        public void push(Edge edge){
            graph.add(edge);
        }

        public ArrayList<Edge> kru(int v){
            Collections.sort(graph);
            ArrayList<Edge> result = new ArrayList<>();

            for (var i : graph){
                int start = i.start;
                int end = i.end;
                double weight = i.weight;

                int startRoot = find(start);
                int endRoot = find(end);
                if (startRoot != endRoot){
                    result.add(i);
                    union(start,end);
                }
            }
            return result;
        }
        private int find(int current){
            if (parents[current] == current){
                return current;
            }
            return parents[current]= find(parents[current]);
        }
        private void union(int a, int b){
            int rootA = find(a);
            int rootB = find(b);
            if (rootA != rootB) {
                parents[rootB] = rootA;
            }
        }
    }

    private static class Edge implements Comparable<Edge>{
        int start;
        int end;
        double weight;

        public Edge(int start, int end, double weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Double.compare(weight,o.weight);
        }
    }
}
