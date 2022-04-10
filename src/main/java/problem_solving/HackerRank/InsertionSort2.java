package problem_solving.HackerRank;

import java.util.Arrays;
import java.util.List;

public class InsertionSort2 {

    public static void main(String[] args) {
        insertionSortPart2(6, Arrays.asList(1, 4, 3, 5, 6, 2));
    }


    public static void insertionSortPart2(int n, List<Integer> arr) {

        int[] array = arr.stream()
                .mapToInt(x -> x)
                .toArray();

        for (int i = 1; i < n; i++) {
//          1, 4, 3, 5, 6, 2

            int j = i;
            int currEl = array[i]; // We need to put this value to its place

            while (j >= 1 && currEl < array[j - 1]) { // If my element is smaller, swap it to left by swapting other elements
                array[j] = array[j - 1];  // swap previous and curr element
                j--; // go back to see if there is bigger then current element
            }
            if (!isSorted(array, i - 1)) { // loop invariant
                System.out.println("sorting went wrong at index: " + i);
                break;
            }
            array[j] = currEl; // j decrement last time end of the loop and point to index of currElement
            printArray(array);
        }
    }

    private static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    private static boolean isSorted(int[] pArray, int pIndex) {  // loop invarianting
        if (pIndex == 0) {
            return true;
        }
        boolean sorted = true;

        for (int i = 0; i < pIndex; i++) {
            if (pArray[i] > pArray[i + 1]) {
                sorted = false;
                break;
            }
        }
        return sorted;

    }
}
