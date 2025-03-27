package m03.d26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class 철로_13334_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        ArrayList<Road> roads = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                    .toArray();
            roads.add(new Road(Math.min(s[0], s[1]), Math.max(s[0], s[1])));
        }
        Collections.sort(roads);
        int d = Integer.parseInt(br.readLine());
        PriorityQueue<Double> pq = new PriorityQueue<>();
        int result = 0;

        for (var pos : roads) {
            double start = pos.start;
            double end = pos.end;

            while (!pq.isEmpty() && pq.peek() < end - d) {
                pq.poll();
            }

            // 현재 선로의 시작점을 큐에 추가
            if (start >= end - d){
                pq.add(start);
            }

            // 큐의 크기가 현재 범위 내 포함된 선로의 개수
            result = Math.max(result, pq.size());
        }
        System.out.println(result);
    }

    private static class Road implements Comparable<Road> {
        double start;
        double end;

        public Road(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Road o) {
            int compare = Double.compare(end, o.end);
            if (compare == 0) {
                return Double.compare(start, o.start);
            }
            return compare;
        }
    }
}
