package leet_code.till_april;

public class BinarySearch1 {


    public static void main(String[] args) {
        System.out.println(search(new int[]{-1, 0, 3, 5, 9, 12}, 11));

    }


    public static int search(int[] nums, int target) {

        int pivot;
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            pivot = l + (r - l) / 2;
            if (nums[pivot] == target) return pivot;
            if (nums[pivot] > target) r = pivot - 1;
            else l = pivot + 1;
        }
        return -1;
    }
}
