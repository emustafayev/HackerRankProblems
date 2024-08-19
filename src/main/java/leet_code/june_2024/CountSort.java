package leet_code.june_2024;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class CountSort {
    public static int[] countSort(int[] inputArray) {
        int N = inputArray.length;
        int M = 0;

        //FOUND MAX ELEMENT
        for (int i = 0; i < N; i++) {
            M = Math.max(M, inputArray[i]);
        }

        //create count array
        int[] countArray = new int[M + 1];

        //count each element in count array
        for (int i = 0; i < N; i++) {
            countArray[inputArray[i]]++;
        }

        //????
        for (int i = 1; i <= M; i++) {
            countArray[i] += countArray[i - 1];
        }

        int[] outputArray = new int[N];

        for (int i = N - 1; i >= 0; i--) {
            outputArray[countArray[inputArray[i]] - 1] = inputArray[i];
            countArray[inputArray[i]]--;
        }

        return outputArray;
    }

    public static void main(String[] args) {

        System.out.println(LocalDateTime.now().toString());

        //        int[] inputArray = {4, 3, 12, 1, 5, 5, 3, 9};
//        int[] outputArray = countSort(inputArray);
//
//        for (int i = 0; i < inputArray.length; i++) {
//            System.out.print(outputArray[i] + " ");
//        }
    }
}
