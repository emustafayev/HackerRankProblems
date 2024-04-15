package leet_code.till_april;

import java.util.Arrays;

public class RunningSumof1dArray {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(runningSum(new int[]{1, 2, 3, 4})));

    }

    // [1,2,3,4]
    // [1,3,6,10]
    public static int[] runningSum(int[] nums) {
        var numsCopy = nums.clone();
        for (int i = 1; i <= nums.length; i++) {
            nums[i-1] = runningS(numsCopy, i);
        }
        return nums;
    }

    private static int runningS(int[] nums, int i) {
        int sum = 0;
        for (int j = 0; j < i; j++) {
            sum += nums[j];
        }
        return sum;
    }
    public static int[] runningSum2(int[] nums) {

        int[] result = new int[nums.length];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += nums[i];
            result[i] = count;
        }
        return result;
    }
}
