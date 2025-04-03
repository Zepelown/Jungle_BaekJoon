package m04.d02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 동전2_2294 {
    static int[] dp;
    static int[] coin;
    static int n,k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = s[0];
        k = s[1];
        dp = new int[k+1];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0]=0;
        coin = new int[n];
        for (int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < n; i++) {
            search(coin[i]);
        }
        System.out.println(dp);
    }

    private static void search(int current){
        if (current > k){
            return;
        }
        for (int i = 0; i < n; i++) {
            dp[current]= Math.min(dp[current], dp[current-coin[i]]+1);
            search(current+coin[i]);
        }

    }
}
