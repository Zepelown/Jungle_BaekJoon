package m04.d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 장난감조립_2637 {
    private static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());
        for (int i = 0; i < v; i++) {
            graph.add(new ArrayList<>());
        }
        int startMiddle=-1;
        for (int i = 0; i < e; i++) {
            int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                    .toArray();
            int end = s[1]-1;
            int start = s[0]-1;
            int amount = s[2];
            if (i == 0){
                startMiddle = start;
            }
            for (int j = 0; j < amount; j++) {
                graph.get(start).add(end);
            }
        }

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(v-1);
        TreeMap<Integer, Integer> test = new TreeMap<>();
        while (!queue.isEmpty()){
            int poll = queue.poll();
            test.put(poll, test.getOrDefault(poll,0)+1);
            for (var i : graph.get(poll)){
                queue.add(i);
            }
        }

//        System.out.println(Arrays.toString(inDegrees));
//        System.out.println(result);
//        System.out.println(test);
        for(var i : test.entrySet()){
            if (i.getKey() == startMiddle){
                break;
            }
            System.out.println((i.getKey() + 1) + " " + i.getValue());
        }
    }
}
