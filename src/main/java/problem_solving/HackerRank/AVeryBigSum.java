package problem_solving.HackerRank;

import java.util.Arrays;


public class AVeryBigSum {
    public static void main(String[] args) {
        long [] arr = {2,5,8,};
        System.out.println(bigSum(arr));
    }

    private static long bigSum(long[] ar) {
        return Arrays.stream(ar).reduce(Long::sum).orElseThrow(RuntimeException::new);
    }
}
