package m03.d26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class 철로_13334 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Position> positions = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                    .toArray();
            positions.add(new Position(s[0],s[1]));
        }
        int d = Integer.parseInt(br.readLine());
        int result = 0;
        for (int i = 0; i < n; i++){
            int temp = 0;
            Position standard = positions.poll();
            standard.visited = true;
            double startDist = standard.start;
            double endDist = startDist + d;
            if (standard.canInclude(startDist,endDist)){
                temp++;
            }
            //
            for (var pos : positions){
                if(pos.canInclude(startDist,endDist)) {
                    temp++;
                }
            }
            //
            result = Math.max(temp, result);
            positions.add(standard);
            printPositions(positions,temp);
        }
        System.out.println(result);
    }
    private static void printPositions(PriorityQueue<Position> positions, int temp) {
        System.out.println("Positions 상태:");
        for (Position pos : positions) {
            System.out.printf("Start: %.1f, End: %.1f, Visited: %b%n", pos.start, pos.end, pos.visited);
        }
        System.out.println("result : " + temp);
        System.out.println();
    }


    private static class Position implements Comparable<Position>{
        double start;
        double end;
        boolean visited = false;

        public Position(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public boolean canInclude(double startDist, double endDist){
            if ((start >= startDist && start <= endDist)
                    &&(end <= endDist && end >= startDist)){
                return true;
            }
            return false;
        }

        @Override
        public int compareTo(Position o) {
            int compare1 = Boolean.compare(this.visited, o.visited);
            if (compare1 == 0){
                int compare = Double.compare(start, o.start);
                if(compare == 0){
                    return Double.compare(end,o.end);
                }
                return compare;
            }
            return compare1;
        }
    }
}
