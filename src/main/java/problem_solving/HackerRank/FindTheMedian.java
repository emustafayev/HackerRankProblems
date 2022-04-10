package problem_solving.HackerRank;

import java.util.Arrays;
import java.util.List;

public class FindTheMedian {

    public static void main(String[] args) {

//        System.out.println(findMedian(Arrays.asList(5, 3, 1, 2, 4)));

        partition(new int[]{5, 3, 1, 2, 4},0,4,2);

    }



    public static int findMedian(List<Integer> arr) {
        // Write your code here
        int[] array = arr.stream().mapToInt(x -> x).toArray();
        for (int i = 0; i < array.length; i++) {
            int j = i;
            int currVal = array[i];
            while (j >= 1 && array[j - 1] > currVal) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = currVal;
        }
        System.out.println(Arrays.toString(array));
        return array[arr.size() / 2];
    }


    private static void quickSelect() {

    }

    private static void partition(int[] arr, int left, int right,int pivotIndex) {
        int pivotVal = arr[pivotIndex];

        //Swap pivot val to the end
        arr[pivotIndex] = arr[right];
        arr[right] = pivotVal;

        System.out.println("Worked");
        int storeIndex = left;

        for (int i = left; i <right - 1; i++) {
            if (arr[i] < pivotVal) {
                int temp = arr[storeIndex];
                arr[i] = arr[storeIndex];
                arr[storeIndex] = temp;
                storeIndex++;
            }
            System.out.println(Arrays.toString(arr));
        }
    }

}
