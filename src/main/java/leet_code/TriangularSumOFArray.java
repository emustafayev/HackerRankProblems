package leet_code;

public class TriangularSumOFArray {

    public static void main(String[] args) {

        System.out.println(triangularSum2(new int[]{1, 2, 3, 4, 5}));

    }

    public static int triangularSum(int[] nums) {

        // [1,2,3,4,5]
        for (int i = nums.length; i > 0; i--) {
            for (int j = 0; j < i - 1; j++) {
                nums[j] = (nums[j] + nums[j + 1]) % 10; // calculate new arrays elements
            }
        }
        return nums[0];
    }


    // recursion
    public static int triangularSum2(int[] nums) {
        if (nums.length == 1) return nums[0];
        int[] next = new int[nums.length - 1];

        for (int i = 0; i < nums.length - 1; i++) {
            next[i] = (nums[i] + nums[i + 1]) % 10;
        }
        return triangularSum2(next);
    }

}