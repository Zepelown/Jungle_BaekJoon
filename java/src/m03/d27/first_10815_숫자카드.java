package m03.d27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class first_10815_숫자카드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                .toArray();
        int m = Integer.parseInt(br.readLine());
        int[] goals = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                .toArray();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
        }
        for (var i : goals){
            if (set.contains(i)){
                System.out.print("1 ");
                continue;
            }
            System.out.print("0 ");
        }
    }
}
