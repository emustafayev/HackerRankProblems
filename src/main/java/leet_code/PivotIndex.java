package leet_code;

public class PivotIndex {

    public static void main(String[] args) {

        System.out.println(pivotIndex3(new int[]{1, 7, 3, 6, 5, 6, 22}));
//        System.out.println(pivotIndex2(new int[]{1, 2, 3}));
    }


    //   [1,7,3,6,5,6]
//   3
    public static int pivotIndex1(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            if (sumLeft(nums, i) == sumRight(nums, i)) return i;
        }
        return -1;
    }

    private static int sumRight(int[] nums, int i) {
        int sum = 0;
        for (int j = i + 1; j < nums.length; j++) {
            sum += nums[j];
        }
        return sum;
    }

    private static int sumLeft(int[] nums, int i) {
        int sum = 0;
        for (int j = 0; j < i; j++) {
            sum += nums[j];
        }
        return sum;
    }

    //   [1,7,3,6,5,6]

    public static int pivotIndex2(int[] nums) {

        int s1 = 0, s2 = 0;

        for (int num : nums) s2 += num;

        for (int i = 0; i < nums.length; i++) {
            System.out.println(s1 + " " + s2);
            if (i == 0) s1 = 0;
            else s1 += nums[i - 1];  // compute left side

            s2 = s2 - nums[i]; // compute right side by  subtracting left side one by one

            if (s1 == s2) return i; // if them equal at index i return
        }
        return -1;
    }

//  1, 7, 3, 6, 5, 6, 22
    public static int pivotIndex3(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        int total = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            System.out.println(total + " " + sum);
            if (total * 2 == sum - nums[i]) // ?????
                return i;

            total += nums[i];
        }

        return -1;
    }
}