package problem_solving.HackerRank;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class AbsolutePermutation {

    public static void main(String[] args) {
        System.out.println(absolutePermutation(95, 22));

    }

    public static List<Integer> absolutePermutation(int n, int k) {
        // Write your code here

        List<Integer> arr = new ArrayList<>();

        if (k == 0) {
            IntStream.range(1, n + 1)
                    .boxed()
                    .forEach(arr::add);
        } else if (n % (2 * k) != 0 || 2 * k > n) {
            arr.add(-1);
        } else {
            final boolean[] add = {true};
            IntStream.range(1, n + 1)
                    .boxed()
                    .forEach(i -> {
                        if (add[0]) arr.add(k + i);
                        else arr.add(Math.abs(k - i));

                        if (i % k == 0) {
                            add[0] = !add[0];
                        }
                    });
        }

        // 1 2 3 4  ==>>> 3 4 1 2
        // k = 2   =>>>
        // i + k; i + k; i - k; i - k;
        // i % k == 0 ? change operation
        return arr;

        //1 2 3
        // k = 2
    }


}
