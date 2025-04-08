package m04.d07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class 행렬곱셈순서_11049 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Matrix> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int row = s[0];
            int col = s[1];
            arr.add(new Matrix(row, col));
        }
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i < n; i++) {
            dp[i][i] = 0; // 자기 자신은 곱셈 비용 0
        }


        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= n - i; j++) {
                int end = j + i - 1;
                dp[j][end] = Integer.MAX_VALUE;
                for (int k = j; k < end; k++) {
                    int cost = dp[j][k] + dp[k + 1][end] + (arr.get(j).row * arr.get(k).col * arr.get(end).col);
                    dp[j][end] = Math.min(dp[j][end], cost);
                }
            }
        }
        System.out.println(dp[0][n - 1]);
    }

    private static class Matrix {
        int row;
        int col;

        public Matrix(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
