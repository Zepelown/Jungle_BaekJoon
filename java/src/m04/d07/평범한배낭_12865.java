package m04.d07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class 평범한배낭_12865 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = s[0];
        int k = s[1];
        ArrayList<Item> list = new ArrayList<>();
        int maxW = 0;
        for (int i = 0; i < n; i++) {
            s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int w = s[0];
            int v = s[1];
            Item item = new Item(w, v);
            list.add(item);
            maxW += w;
        }
        // dp[j] 배낭 용량이 j일 때, 얻을 수 있는 최대 가치
        // 배열 크기를 k+1로 설정해 용량 제한을 정확히 반영
        int[] dp = new int[k + 1];
        // 아이템 순회 : 각 아이템에 처리
        // 역방향 순회 j = k -> w
        // 정방향 순회시 동일 아이템 중복 선택 문제를 방지
        // j >= w 현재 아이템을 넣을 수 있는 용량만 처리
        // 점화식 : dp[j] = max(기존 값, 현재 아이템 포함 시 가치)
        // dp[j-w] + v : 현재 아이템을 추가하기 전 용량(j-w)의 최대 가치 + 현재 가치
        for (Item item : list) {
            int w = item.w;
            int v = item.v;
            for (int j = k; j >= w; j--) {
                dp[j] = Math.max(dp[j], dp[j - w] + v);
            }
        }
        System.out.println(dp[k]);
    }

    private static class Item {
        int w;
        int v;

        public Item(int w, int v) {
            this.w = w;
            this.v = v;
        }
    }
}
