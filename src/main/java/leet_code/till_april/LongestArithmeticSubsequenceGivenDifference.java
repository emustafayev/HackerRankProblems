package leet_code.till_april;


//
//
//        Given an integer array arr and an integer difference,
//        return the length of the longest subsequence in arr which is an arithmetic
//        sequence such that the difference between adjacent elements in the subsequence equals difference.
//
//        A subsequence is a sequence that can be derived from arr
//        by deleting some or no elements without changing the order of the remaining elements.
//
//
//
//        Example 1:
//
//        Input: arr = [1,2,3,4], difference = 1
//        Output: 4
//        Explanation: The longest arithmetic subsequence is [1,2,3,4].
//        Example 2:
//
//        Input: arr = [1,3,5,7], difference = 1
//        Output: 1
//        Explanation: The longest arithmetic subsequence is any single element.
//        Example 3:
//
//        Input: arr = [1,5,7,8,5,3,4,2,1], difference = -2
//        Output: 4
//        Explanation: The longest arithmetic subsequence is [7,5,3,1].


public class LongestArithmeticSubsequenceGivenDifference {
    public static void main(String[] args) {
        longestSubsequence(new int[]{1, 5, 7, 8, 5, 3, 4, 2, 1}, -2);
    }
    public static int helper(int index, int prev, int[] arr, int diff) {
        int n = arr.length;
        if (index >= n) {
            return 0;
        }

        int take = 0;
        int notake = 0;
        if (prev == -10000) {
            notake = helper(index + 1, prev, arr, diff);
            take = 1 + helper(index + 1, arr[index], arr, diff);
        } else {
            notake = helper(index + 1, prev, arr, diff);
            if (arr[index] - prev == diff) {
                take = 1 + helper(index + 1, arr[index], arr, diff);
            }
        }
        return Math.max(take, notake);
    }

    public static int longestSubsequence(int[] arr, int difference) {
        int n = arr.length;
        return helper(0, -10000, arr, difference);
    }

}
