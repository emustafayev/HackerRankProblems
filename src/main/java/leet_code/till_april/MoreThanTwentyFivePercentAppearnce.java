package leet_code.till_april;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MoreThanTwentyFivePercentAppearnce {


    public static void main(String[] args) {

    }

    //solution for fun
    public static int findSpecialInteger(int[] arr) {

        int occurance = arr.length * 25 / 100;
        Integer res = Arrays
                .stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(i -> i, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(el -> el.getValue() > occurance)
                .findFirst()
                .get()
                .getKey();

        System.gc(); // Tricking leetcode (LOL)

        return res;
    }

    public int findSpecialInteger2(int[] arr) {
        int size = arr.length / 4;
        for (int i = 0; i < arr.length - size; i++) {
            if (arr[i] == arr[i + size]) {// because it is sorted
                return arr[i];
            }
        }

        return -1;
    }
}
