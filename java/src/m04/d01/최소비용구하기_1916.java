package m04.d01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class 최소비용구하기_1916 {
    private static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    private static int v, e;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        v = Integer.parseInt(br.readLine());
        e = Integer.parseInt(br.readLine());

        for (int i = 0; i < v; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int start = s[0]-1;
            int end = s[1]-1;
            int weight = s[2];
            graph.get(start).add(new Node(end, weight));
//            graph.get(end).add(new Node(start,weight));
        }
        int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int start = s[0];
        int end = s[1];
        dijkstra(start-1,end-1);
    }

    private static void dijkstra(int start, int end){
        PriorityQueue<Node> queue = new PriorityQueue<>();
        int[] dist = new int[v];
        Arrays.fill(dist, Integer.MAX_VALUE);

        boolean[] visited = new boolean[v];
        dist[start] = 0;
        queue.add(new Node(start,0));
        while (!queue.isEmpty()){
            Node current = queue.poll();
            if (visited[current.x]){
                continue;
            }
            visited[current.x] = true;
            for (var next : graph.get(current.x)){

                if (dist[next.x] > dist[current.x] + next.weight){
                    dist[next.x] = dist[current.x] + next.weight;
                    queue.add(new Node(next.x, dist[next.x]));
                }
            }
        }
//        System.out.println(Arrays.toString(dist));
        System.out.println(dist[end]);
    }

    static class Node implements Comparable<Node>{
        int x;
        int weight;

        public Node(int x, int weight) {
            this.x = x;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(weight,o.weight);
        }
    }
}
