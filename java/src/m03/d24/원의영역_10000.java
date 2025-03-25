package m03.d24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class 원의영역_10000 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Circle> circles = new ArrayList<>();
        for(int i = 0; i < n; i++){
            int[] circle = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int center = circle[0];
            int r = circle[1];
            circles.add(new Circle(center,r));
        }
        Collections.sort(circles);
        for (var i : circles){
            System.out.println(i.start +" " + i.end);
        }
        Stack<Circle> stack = new Stack<>();
        int result = 0;
        for(var i : circles){
            if (!stack.isEmpty() && !i.isCover(stack.firstElement())){
                result += calculateCircle(stack,result);
            }
            stack.push(i);
        }
        if(!stack.isEmpty()){
            result += calculateCircle(stack,result);
        }
        System.out.println(result);
    }

    public static int calculateCircle(Stack<Circle> stack, int result){
        int max_dist = stack.firstElement().calculateDist();
        int inner_dist = 0;
        while (stack.size() > 1){
            Circle pop = stack.pop();
            inner_dist += pop.calculateDist();
            result++;
        }
        if (inner_dist == max_dist){
            result++;
        }
        stack.pop();
        result++;

        return result;
    }

    private static class Circle implements Comparable<Circle>{
        int center;
        int r;
        int start;
        int end;

        public Circle(int center, int r) {
            this.center = center;
            this.r = r;
            this.start = center-r;
            this.end = center+r;
        }

        @Override
        public int compareTo(Circle o) {
            int compare = Integer.compare(start, o.start);
            if (compare == 0){
                return -Integer.compare(end,o.end);
            }
            return compare;
        }

        public boolean isCover(Circle o){
            if (this.start < o.start || this.end > o.end){
                return false;
            }
            return true;
        }

        public int calculateDist(){
            return 2 * r;
        }
    }
}
