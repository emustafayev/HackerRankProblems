package leet_code.october2024;

public class TwoSmallestNumber {

    public static void main(String[] args) {


        findTwoSmallest(new int[]{3, 4, 5, 1, -1, 3});
        findTwoSmallest(new int[]{3, 4, 5, 1, 3, 1});
        findTwoSmallest(new int[]{1, 2, 3});
        findTwoSmallest(new int[]{1, 2, 3, 1});

    }

    private static void findTwoSmallest(int[] arr) {

        int min1 = arr[0];
        int min2 = arr[1];

        if (arr[0] > arr[1]) {
            min1 = arr[1];
            min2 = arr[0];

        }


        for (int i = 1; i < arr.length; i++) {
            if (min1 > arr[i]) {
                min2 = min1;
                min1 = arr[i];
            } else if (min2 > arr[i]) {
                min2 = arr[i];
            }
        }
        System.out.println(min1 + " " + min2);

    }
}
