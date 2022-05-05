package leet_code;

public class SearchInsertPosition {

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1,3,5,6}, 2));
    }


    public static int searchInsert(int[] nums, int target) {

        int l = 0;
        int r = nums.length - 1;
        int pivot;

        while (l <= r) {
            pivot = l + (r - l) / 2;
            if (nums[pivot] == target) return pivot;
            if (nums[pivot] > target) r = pivot - 1;
            else l = pivot + 1;
        }

        return l;
    }
}
