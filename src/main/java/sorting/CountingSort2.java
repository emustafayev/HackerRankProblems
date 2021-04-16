package sorting;

import java.util.Arrays;

public class CountingSort2 {

    public static void main(String[] args) {
        int[] arr = new int[]{0, 63, 25, 73, 1, 98, 73, 56, 84, 86, 57, 16, 83, 8, 25, 81, 56, 9, 53, 98, 67, 99, 12, 83 ,89, 80, 91, 39, 86, 76, 85, 74};
        System.out.println(Arrays.toString(countingSort(arr)));
    }

    // Complete the countingSort function below.
    static int[] countingSort(int[] arr) {
        int[] frequency = new int[100];
        for (int j : arr) {
            frequency[j]++;
        }

        int[] res = new int[arr.length];
        int counter = 0;

        for (int i = 0; i < frequency.length; i++){
            if (frequency[i] > 0){
                for (int j = 0;j < frequency[i];j++){
                    res[counter++] = i;
                }
            }
        }
        return res;
    }
}
