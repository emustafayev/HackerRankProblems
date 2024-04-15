package leet_code.till_april;

public class RemoveElement {

//    Given an integer array nums and an integer val, remove all occurrences of val in nums in-place.
//    The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.
//
//    Consider the number of elements in nums which are not equal to val be k, to get accepted,
//    you need to do the following things:
//
//    Change the array nums such that the first k elements of nums contain the elements which are not equal to val.
//    The remaining elements of nums are not important as well as the size of nums.
//    Return k.

    public static void main(String[] args) {

        System.out.println(removeElement(new int[]{3,2,2,3},3));

    }

    //  Input: nums = [3,2,2,3], val = 3
    //  Output: 2, nums = [2,2,_,_]
    public static int removeElement(int[] nums, int val) {
        int counter = 0;
        for (int i = 0; i < nums.length; i++)
            if (nums[i] != val) nums[counter++] = nums[i];
        return counter;
    }
}
