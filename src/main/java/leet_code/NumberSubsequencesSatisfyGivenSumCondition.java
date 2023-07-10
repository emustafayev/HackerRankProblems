package leet_code;

import java.util.Arrays;

public class NumberSubsequencesSatisfyGivenSumCondition {

    public static void main(String[] args) {
        System.out.println(numSubseq(new int[]{3, 5, 6, 7}, 9));
    }

    /**
     * You are given an array of integers nums and an integer target.
     * <p>
     * Return the number of non-empty subsequences of nums such that
     * the sum of the minimum and maximum element on it is less or
     * equal to target. Since the answer may be too large, return it modulo 109 + 7.
     *
     * @param nums
     * @param target
     * @return
     */


    public static int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);

        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            int till = target - nums[i];
            int j = i;
            while (j < nums.length && nums[j] <= till) {
                j++;
                res++;
            }
        }
        return res;
    }
}
