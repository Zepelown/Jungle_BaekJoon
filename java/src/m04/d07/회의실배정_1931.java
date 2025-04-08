package m04.d07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class 회의실배정_1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Meeting> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            list.add(new Meeting(s[0], s[1]));
        }
        Collections.sort(list);
        int result = 0;
        int end = -1;
        for (var i : list) {
            if (end <= i.start) {
                end = i.end;
                result++;
            }
        }
        System.out.println(result);
    }

    private static class Meeting implements Comparable<Meeting> {
        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meeting o) {
            int compare = Integer.compare(end, o.end);
            if (compare == 0) {
                return Integer.compare(start, o.start);
            }
            return compare;
        }
    }
}
