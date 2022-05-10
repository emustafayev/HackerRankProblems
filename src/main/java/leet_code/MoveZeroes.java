package leet_code;

import java.util.Arrays;

public class MoveZeroes {

    public static void main(String[] args) {
        int[] arr = new int[]{0, 0, 0, 1};

        moveZeroes2(arr);

        System.out.println(Arrays.toString(arr));
    }

    private static void moveZeroes2(int[] nums) {
        int zeroCount = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroCount++;
            } else if (zeroCount > 0) {
                swap(nums, i, i - zeroCount);  // menimle 3 evvelki indexdekini deyisdir. 3 evveldeki index 0 olur hemise(0 sayi qeder get geriye)
            }
        }
    }


    //  cant move multiple zeros((
    public static void moveZeroes1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int zeroCount = 0;
            if (nums[i] == 0) {
                zeroCount++; // no need to swap 0 with 0
                for (int j = i; j < nums.length - zeroCount; j++) {
                    swap(nums, j, j + 1);
                }
            }
        }
    }

    private static void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
