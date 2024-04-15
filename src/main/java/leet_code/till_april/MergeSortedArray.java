package leet_code.till_april;

import java.util.Arrays;

public class MergeSortedArray {

//    You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n,
//    representing the number of elements in nums1 and nums2 respectively.
//
//    Merge nums1 and nums2 into a single array sorted in non-decreasing order.

    public static void main(String[] args) {

        int[] arr = new int[]{1, 2, 3, 0, 0, 0};
        merge(arr, 3, new int[]{2, 5, 6}, 3);

        System.out.println(Arrays.toString(arr));
    }


    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int tail1 = m - 1;
        int tail2 = n - 1;

        int finished =  m  + n - 1;

        while (tail1 >= 0 && tail2 >= 0){
            nums1[finished--] = nums1[tail1] > nums2[tail2] ?
                    nums1[tail1--] : nums2[tail2--];


        }
        while (tail2 >= 0) {
            nums1[finished--] = nums2[tail2--];
        }

    }
}
