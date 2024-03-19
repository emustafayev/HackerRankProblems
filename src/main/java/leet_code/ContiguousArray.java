package leet_code;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {

    //Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.
    //
    //
    //
    //Example 1:
    //
    //Input: nums = [0,1]
    //Output: 2
    //Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.
    //Example 2:
    //
    //Input: nums = [0,1,0]
    //Output: 2
    //Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.

//    1,2,1,0,1,2,1,2,3
//    1,1,0,0,1,1,0,1,1


    public static void main(String[] args) {

        System.out.println(findMaxLength(new int[]{1,1,0,0,1,1,0,1,1}));
        System.out.println(findMaxLength(new int[]{1,0}));
        System.out.println(findMaxLength(new int[]{1,0,1}));
        System.out.println(findMaxLength(new int[]{0,1,1,0,1,1,1,0}));


    }

    public static int findMaxLength(int[] nums) {

        int runningSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int maxSubArr = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                runningSum++;
            } else {
                runningSum--;
            }
            if (runningSum == 0) {
                maxSubArr = Math.max(maxSubArr, i + 1);
            }

            Integer previous = map.get(runningSum);
            if (previous == null) {
                map.put(runningSum, i);
            } else {
                maxSubArr = Math.max(maxSubArr, i - previous);
            }
        }

        return maxSubArr  == Integer.MIN_VALUE ? 0 : maxSubArr;
    }


}
