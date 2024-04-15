package leet_code.till_april;

import java.util.Arrays;

public class ThreeSumClosest {

    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    }

    private static int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        int rL = -10000;
        int rU = 10000;

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int l = i + 1;
            int h = nums.length - 1;
            while (l < h) {
                int sum = nums[i] + nums[l] + nums[h];
                if (sum == target) {
                    return sum;
                } else if (sum > target) {
                    rU = Math.min(rU, sum);
                    h--;
                } else {
                    rL = Math.max(rL, sum);
                    l++;
                }
            }
        }

        if (Math.abs(target - rU) < Math.abs(target - rL)) {
            return rU;
        } else {
            return rL;
        }
    }

}
