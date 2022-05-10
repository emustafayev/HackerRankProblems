package leet_code;

import java.util.Arrays;

public class TwoSumII {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(twoSum2(new int[]{0,0,3,4}, 0)));
    }

    private static int[] twoSum2(int[] numbers, int target) {

        int[] res = new int[2];

        int left = 0, right = numbers.length-1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum == target){
                res[0] = left+1;
                res[1] = right+1;
                return res;
            }
            else if (sum > target){
                right--;
            }else left++;
        }
        throw new IllegalArgumentException("Never should reach here");
    }


    // returns timeout
    public static int[] twoSum1(int[] numbers, int target) {

        int[] res = new int[2];

        for (int i = 0; i < numbers.length; i++) {
            res[0] = i + 1;
            for (int j = i+1; j <numbers.length; j++) {
                if (numbers[res[0]-1] + numbers[j]==target){
                    res[1] = j + 1;
                    return res;
                }
            }
        }
        throw new IllegalArgumentException("Never should reach here");
    }
}
