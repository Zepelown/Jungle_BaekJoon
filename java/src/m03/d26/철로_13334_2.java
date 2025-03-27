package m03.d26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class 철로_13334_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
//        PriorityQueue<Position> positions = new PriorityQueue<>();
        ArrayList<Position> positions = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                    .toArray();
            positions.add(new Position(s[0], s[1]));
        }
        Collections.sort(positions);
        int d = Integer.parseInt(br.readLine());
        int result = 0;

        for (int i = 0; i < n; i++) {
            int temp = 0;
            Position standard = positions.get(i);
            double startDistPos = standard.end - d;
            double endDistPos = standard.end;
            for (int j = 0; j <= i; j++) {
                if (positions.get(j).canInclude(startDistPos, endDistPos)) {
                    temp++;
                }
            }
            standard.visited = true;
//            printPositions(positions,temp);
            result = Math.max(result, temp);
        }
        System.out.println(result);
    }

    private static void printPositions(ArrayList<Position> positions, int temp) {
        System.out.println("Positions 상태:");
        for (var pos : positions) {
            System.out.printf("Start: %.1f, End: %.1f, Visited: %b%n", pos.start, pos.end, pos.visited);
        }
        System.out.println("result : " + temp);
        System.out.println();
    }


    private static class Position implements Comparable<Position> {
        double start;
        double end;
        boolean visited = false;

        public Position(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public boolean canInclude(double startDist, double endDist) {
            if ((start >= startDist && start <= endDist)
                    && (end <= endDist && end >= startDist)) {
                return true;
            }
            return false;
        }

        @Override
        public int compareTo(Position o) {
            int compare = Double.compare(end, o.end);
            if (compare == 0) {
                return Double.compare(start, o.start);
            }
            return compare;
        }
    }
}
