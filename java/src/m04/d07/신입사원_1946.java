package m04.d07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class 신입사원_1946 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            ArrayList<Score> scores = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                int doc = s[0];
                int interview = s[1];
                scores.add(new Score(doc,interview));
            }
            Collections.sort(scores);
            int interviewScoreCut = scores.get(0).interview;
            int result = n;
            for (int j = 1; j < n; j++) {
                Score currentScore = scores.get(j);
                if (interviewScoreCut < currentScore.interview){
                    result--;
                } else {
                    interviewScoreCut = currentScore.interview;
                }
            }
            System.out.println(result);
        }
    }
    private static class Score implements Comparable<Score> {
        int doc;
        int interview;

        public Score(int doc, int interview) {
            this.doc = doc;
            this.interview = interview;
        }

        @Override
        public int compareTo(Score o) {
            int compare = Integer.compare(doc, o.doc);
            if (compare == 0) {
                return Integer.compare(interview, o.interview);
            }
            return compare;
        }
    }
}
