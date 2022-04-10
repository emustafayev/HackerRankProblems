package problem_solving.HackerRank;

import java.util.Arrays;
import java.util.List;

public class AlmostSorted {

    public static void main(String[] args) {
        almostSorted(Arrays.asList(1, 5, 4, 3, 2, 6));
    }

    public static void almostSorted(List<Integer> arr) {
        // Write your code here
        int[] d = arr.stream().mapToInt(x -> x).toArray();

        int n = d.length;

        if (isSorted(d) || n == 2) {
            System.out.println("Yes");
            return;
        }

        int i, j;
        for (i = 0; i < n - 1 && d[i] < d[i + 1]; ++i) ;
        for (j = n - 1; j > 0 && d[j - 1] < d[j]; --j) ;
        System.out.println(i + " " + j);

        //try swap
        swap(d, i, j);
        if (isSorted(d)) {
            System.out.println("yes\nswap " + (i + 1) + " " + (j + 1));
            return;
        }

        //try reverse
        int l = i + 1; // add 1 because we already swap one time for checking swapping; line 29
        int r = j + 1;

        while (l < r) swap(d, l++, r--);

        if (isSorted(d)) {
            System.out.println("yes\nreverse " + (i + 1) + " " + (j + 1));
            return;
        }

        System.out.println("no");


    }

    private static void swap(int[] d, int i, int j) {
        int temp = d[i];
        d[i] = d[j];
        d[j] = temp;
    }


    private static boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
