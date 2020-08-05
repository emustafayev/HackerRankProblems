package problem_solving.HackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EqualizeTheArray {
    public static void main(String[] args) {
        System.out.println(equalizeArray(new int[]{3, 3, 2, 1, 3}));
    }

    // Complete the equalizeArray function below.
    static int equalizeArray(int[] arr) {                     // 1:1,2:1,3:2
        List<Long> collect = new ArrayList<>(Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(i -> i, Collectors.counting()))
                .values());
        Long maxValue = collect.stream().sorted()
                .max((o1, o2) -> (int) (o1 - o2)).orElseThrow(RuntimeException::new);
        return (int)(collect.stream().reduce(Long::sum).orElseThrow(RuntimeException::new) - maxValue);
    }
}
