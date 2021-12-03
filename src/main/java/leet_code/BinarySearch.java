package leet_code;


public class BinarySearch {
    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{-1, 0, 3, 5, 9, 12}, 9));
        System.out.println(binarySearch2(new int[]{-1, 0, 3, 5, 9, 12}, 9));
    }

    public static int binarySearch(int[] nums, int target) {
        int pivot, left = 0, right = nums.length - 1;
        while (left <= right) {
            pivot = left + (right - left) / 2;
            if (nums[pivot] == target) return pivot;
            if (target < nums[pivot]) right = pivot - 1;
            else left = pivot + 1;
        }
        return -1;
    }


    public static int binarySearch2(int[] nums, int target) {

        int left = 0, right = nums.length - 1;
        return search(nums, left, right, target);
    }

    private static int search(int[] nums, int left, int right, int target) {
        int pivot = left + (right - left) / 2;
        if (nums[pivot] == target) return pivot;
        if (nums[pivot] > target) right = pivot - 1;
        else left = pivot + 1;
        return search(nums, left, right, target);
    }


}
