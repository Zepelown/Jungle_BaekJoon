package m03.d31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class 연산자_끼워넣기_14888 {
    private static int[] numbers, operates;
    private static int n;
    private static int resultMax = Integer.MIN_VALUE;
    private static int resultMin = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        operates = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        dfs(new ArrayList<>());
        System.out.println(resultMax);
        System.out.println(resultMin);
    }

    private static void dfs(ArrayList<Integer> currentOperates) {
        if (currentOperates.size() == n - 1) {
            int calculate = calculate(currentOperates);
            resultMax = Math.max(resultMax, calculate);
            resultMin = Math.min(resultMin, calculate);
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (operates[i] != 0) {
                currentOperates.add(i);
                operates[i]--;
                dfs(currentOperates);
                currentOperates.remove(currentOperates.size() - 1);
                operates[i]++;
            }
        }
    }

    public static int calculate(ArrayList<Integer> currentOperates) {
        int temp = numbers[0];
        int operateIndex = 0;
        for (int i = 1; i < n; i++) {
            int next = numbers[i];
            switch (currentOperates.get(operateIndex++)) {
                case 0:
                    temp = temp + next;
                    break;
                case 1:
                    temp = temp - next;
                    break;
                case 2:
                    temp = temp * next;
                    break;
                case 3:
                    temp = temp / next;
                    break;
            }
        }
        return temp;
    }
}
