package leet_code.till_april;

public class RemoveDuplicatesSortedArray {
//
//    Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique
//    element appears only once. The relative order of the elements should be kept the same.
//    Then return the number of unique elements in nums.
//
//    Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:
//
//    Change the array nums such that the first k elements of nums contain the unique elements in the order they were
//    present in nums initially. The remaining elements of nums are not important as well as the size of nums.
//    Return k.

//
//    int[] nums = [...]; // Input array
//    int[] expectedNums = [...]; // The expected answer with correct length
//
//    int k = removeDuplicates(nums); // Calls your implementation
//
//    assert k == expectedNums.length;
//    for (int i = 0; i < k; i++) {
//        assert nums[i] == expectedNums[i];
//    }


    public static void main(String[] args) {
        System.out.println(removeDuplicates2(new int[]{0,0,1,1,1,2,2,3,3,4}));
        System.out.println(removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
    }



    public static int removeDuplicates(int[] nums) {
        int count = 1;
        for (int i = 1; i < nums.length; i++)
            if (nums[i-1] != nums[i]) nums[count++] = nums[i]; // compare it with previous int
        return count;
    }

    public static int removeDuplicates2(int[] nums){
        int slow = 0;

        for(int fast= 1; fast < nums.length; fast++){
            if(nums[fast] != nums[slow]) //compare it with previous moved
                nums[++slow] = nums[fast];

        }
        return slow + 1;
    }



}
