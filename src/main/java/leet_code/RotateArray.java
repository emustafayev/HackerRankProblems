package leet_code;

import java.util.Arrays;

public class RotateArray {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        rotate2(arr,3);
//        System.out.println(Arrays.toString(arr));
    }


    public static void rotate2(int[] nums, int k) {
        k = k % nums.length;

        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);

        System.out.println(Arrays.toString(nums));

    }

    private static void reverse(int[] nums, int l, int r) {
        while (l<r){
            swap(nums,l,r);
            l++;
            r--;
        }
    }

    private static void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
//    Visualisation of solution (Smart guy figure this out, not me)


//    reverse "----->-->" we can get "<--<-----"
//    reverse "<--" we can get "--><-----"
//    reverse "<-----" we can get "-->----->"


    //    [5,6,7,1,2,3,4]   --- 7
    //not working
    public static void rotate(int[] nums, int k) {
        int realRotate = k % nums.length;

        String rawString = convertRawString(nums);
        System.out.println(rawString);
        String resString = rawString.substring(realRotate+1) + rawString.substring(0,realRotate+1);



        System.out.println(resString);


    }

    private static String convertRawString(int[] nums) {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(nums).forEach(sb::append);
        return sb.toString();
    }
}
