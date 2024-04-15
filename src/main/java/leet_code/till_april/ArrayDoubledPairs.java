package leet_code.till_april;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayDoubledPairs {

    public static void main(String[] args) {

        List<String> l1 = Arrays.asList("A", "B","C", "D");
        List<String> l2 = Arrays.asList("A", "B");

        List<String> res = l1
                .stream()
                .filter(el -> l2.stream().anyMatch(e -> e != el))
                .collect(Collectors.toList());

        System.out.println(res);

    }
//    Given an integer array of even length arr, return true if it is possible to reorder arr such that
//    arr[2 * i + 1] = 2 * arr[2 * i] for every 0 <= i < len(arr) / 2, or false otherwise.



    public static boolean canReorderDoubled(int[] arr) {



        throw new IllegalArgumentException("not impl yet");
    }
}
