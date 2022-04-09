package problem_solving.HackerRank;

import java.util.Arrays;
import java.util.List;

public class InsertionSortTutorial {
    public static void main(String[] args) {
        insertionSort1(5, Arrays.asList(2, 4, 6, 8, 3));
    }


    public static void insertionSort1(int n, List<Integer> arr) {
        // Write your code here
        int[] array = arr.stream()
                .mapToInt(x -> x)
                .toArray();

        int insert = array[n-1];
        for (int i = n - 2; i >= 0; i--) {

            array[i + 1] = Math.max(insert, array[i]);

            printArr(array);

        }
    }

    private static void printArr(int[] arr){
        StringBuilder out = new StringBuilder();
        for (int j : arr) {
            out.append(j).append(" ");
        }

        System.out.println(out.substring(0,out.length() - 1));
    }
}
