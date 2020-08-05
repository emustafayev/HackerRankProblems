package problem_solving.HackerRank;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ClimbingLeaderboard {
    static class Score{
        private final int val;

        Score(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        //climbingLeaderboard(new int[]{})
    }

    static int[] climbingLeaderboard(int[] scores, int[] alice){
        List<Score> distinct_scores = Arrays.stream(scores)
                .distinct()
                .mapToObj(Score::new)
                .collect(Collectors.toList());

        return Arrays.stream(alice).map(s->calculate_score(distinct_scores,s)).toArray();
    }

    private static int calculate_score(List<Score> distinct_scores, int s) {
        int index = Collections.binarySearch(distinct_scores,new Score(s),(a, b)->b.val-a.val);
        if (index>0) return index+1;
        if (index==0) return 1;
        return Math.abs(index);
    }
}
