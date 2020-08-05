package problem_solving.HackerRank;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class DiagonalDifference {
    public static void main(String[] args) {
        List<List<Integer>> list = Arrays.asList(
                Arrays.asList(11, 2, 4),
                Arrays.asList(4, 5, 6),
                Arrays.asList(10, 8, -12)
        );
        System.out.println(findDiagDiff(list));
    }

    private static int findDiagDiff(List<List<Integer>> list) {
        return Math.abs(IntStream.range(0,list.size())
                .map(n->
                        list.get(n).get(n)-list.get(n).get(list.size()-n-1))
                .sum());
    }
}
