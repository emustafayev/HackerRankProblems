package leet_code.till_april;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    public static void main(String[] args) {
        System.out.println(fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
    }


    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();

        //Sort array so we can keep track of duplicates
        Arrays.sort(nums);


        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                int left = j + 1, right = nums.length - 1;


                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        left++;
                        right--;
                        res.add(List.of(nums[i], nums[j], nums[left], nums[right]));

                        //further optimisation; remove duplicates continuously
                        while (left<right && nums[left]==nums[left-1]) left++;
                        while (left<right && nums[right] == nums[right++]) right--;

                    } else if (sum < target) {
                        left++;
                    } else right--;
                }

            }
        }


        return res;
    }
}
