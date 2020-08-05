package problem_solving.HackerRank;

import java.util.stream.IntStream;

public class MinimumSwaps {
    public static void main(String[] args) {
        minimumSwaps(new int[]{1,2,4,3,5,6});
    }

    static int minimumSwaps(int[] arr){  // 1,2,4,3,5,6;
        int[] swapCount = {0};
        IntStream.range(0,arr.length).forEach(i->{

            while (arr[i]!=(i+1)){
                int tempI = arr[i]+1;
                int temp = arr[i];

                arr[i] = arr[tempI];
                arr[tempI] = temp;

                swapCount[0]++;

            }
        });
        return swapCount[0];
    }
}
