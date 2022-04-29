package problem_solving.HackerRank;

import java.util.Arrays;
import java.util.List;

public class RunningTimeOfAlgorithms {

    public static void main(String[] args) {
        System.out.println(runningTime(Arrays.asList(2, 1, 3, 1, 2)));
    }


    public static int runningTime(List<Integer> arr) {
        // Write your code here

        int[] array = arr.stream()
                .mapToInt(x -> x)
                .toArray();

        int swapCount = 0;
        //insertion sort by from left to right
        for (int i = 0; i < array.length; i++) {
            //          1, 4, 3, 5, 6, 2

            int j = i;
            int currEl = array[i]; // We need to put this value to its place

            while (j >= 1 && currEl < array[j-1]) { // logic: compare current element with previous, if smaller,
                                                    // move that element to position of current el(check j if it is begining of array or not
                array[j] = array[j-1];
                j--;
                swapCount ++;
            }
            array[j] = currEl;
        }

        return swapCount;

    }
}
