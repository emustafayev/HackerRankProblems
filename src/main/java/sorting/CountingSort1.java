package sorting;

import java.util.Arrays;

public class CountingSort1 {

    public static void main(String[] args) {
        int[] arr = new int[]{63, 25, 73, 1, 98, 73, 56, 84, 86, 57, 16, 83, 8, 25, 81, 56, 9, 53, 98, 67, 99, 12, 83 ,89, 80, 91, 39, 86, 76, 85, 74};
        System.out.println(Arrays.toString(countingSort(arr)));
    }

    // Complete the countingSort function below.
    static int[] countingSort(int[] arr) {
        int[] res = new int[100];
        for (int j : arr) {
            res[j]++;
        }
        return res;
    }
}
