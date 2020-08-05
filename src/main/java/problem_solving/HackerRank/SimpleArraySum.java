package problem_solving.HackerRank;

import java.util.Arrays;

public class SimpleArraySum {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        System.out.println(sumOfArr(arr));
    }

    private static int sumOfArr(int[] arr) {
        return Arrays.stream(arr)
                .boxed()
                .reduce(Integer::sum)
                .orElseThrow(RuntimeException::new);
    }
}
