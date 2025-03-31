package m03.d28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class 최소_스패닝_트리_1197 {
    // 음수라는 단어에 집착해서 벨만 포드 했다가 망함.. 크루스칼이랑 프림하는게 맞음
    // 크루스칼이랑 프림은 음수 가중치 처리 가능
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int v = s[0];
        int e = s[1];
        Graph graph = new Graph();
        for (int i = 0; i < e; i++){
            int[] s1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int num = s1[0];
            int start = s1[1];
            int end = s1[2];
            graph.push(new Edge(num,start,end));
        }

        System.out.println(Arrays.toString(graph.bellman(v,e,0)));
    }
    private static class Graph{
        private static double[] dist;
        private ArrayList<Edge> graph = new ArrayList<>();

        public void push(Edge edge){
            graph.add(edge);
        }

        public double[] bellman(int v, int e, int source){
            dist = new double[v];
            for (int i = 0; i < v; i++){
                dist[i] = Double.MAX_VALUE;
            }
            dist[source] = 0;
            for (int i = 0; i < v-1; i++) {
                for (var edge : graph) {
                    int start = edge.start-1;
                    int end = edge.end-1;
                    double weight = edge.weight;

                    if (dist[end] > dist[start] + weight){
                        dist[end] = dist[start] + weight;
                    }
                }
            }

            for (int i = 0; i < e; i++){
                Edge edge = graph.get(i);
                int start = edge.start-1;
                int end = edge.end-1;
                double weight = edge.weight;

                if (dist[end] > dist[start] + weight){
                    return null;
                }
            }

//            double result = Double.MAX_VALUE;
//            for (int i = 0; i < v; i++){
//                result = Math.min(result, dist[i]);
//            }

            return dist;
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
            return Double.compare(this.weight, o.weight);
        }
    }
}
