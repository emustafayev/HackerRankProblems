package problem_solving.HackerRank;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MinMaxSum {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        findMinMuxSum(arr);
    }

    private static void findMinMuxSum(int[] arr) {
        long sum = Arrays.stream(arr)
                .mapToLong(el->(long)el).sum();

        List<Long> sums = Arrays.stream(arr).boxed()
                .mapToLong(el -> sum - el).boxed()
                .collect(Collectors.toList());

        System.out.println(
                String.format("%d %d",sums.stream().min(Comparator.comparingLong(a -> a))
                        .orElseThrow(RuntimeException::new),
                        sums.stream().max(Comparator.comparingLong(a -> a))
                        .orElseThrow(RuntimeException::new))
        );
    }
}
