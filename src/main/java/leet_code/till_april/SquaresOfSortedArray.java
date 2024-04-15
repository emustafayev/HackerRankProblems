package leet_code.till_april;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class SquaresOfSortedArray {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortedSquares2(new int[]{-1,2,2})));
    }
    // Working
    public static int[] sortedSquares2(int[] nums) {
        int l = 0, r = nums.length - 1;
        int[] ans = new int[nums.length];
        int a = nums.length - 1;
        while (l < r) {
            int first = nums[l] * nums[l];
            int last = nums[r] * nums[r];
            if (first > last) {
                ans[a--] = first;
                l++;
            }
            else if (last > first) {
                ans[a--] = last;
                r--;
            }else {
                ans[a--] = last;
                ans[a--] = first;
                l++;
                r--;
            }
        }
        if (l==r) ans[a] = nums[r] * nums[r]; // else in while loop throw exception if (l<=r) in while loop.
                                              // Last statement try to write two same number o and -1 index
        return ans;
    }


    // Not working
    public static int[] sortedSquares1(int[] nums) {
        Deque<Integer> negativeS = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                negativeS.add(nums[i] * nums[i]);

            } else if (nums[i] >= 0) {
                System.out.println("I worked");
                int positiveS = nums[i] * nums[i];
                System.out.println(negativeS);
                result.add(negativeS.size() > 0 ? negativeS.getLast() < positiveS ? negativeS.pollLast() : positiveS : positiveS);
            }
        }
        System.out.println(result);
        throw new IllegalArgumentException("Not finished yet");
    }
}
