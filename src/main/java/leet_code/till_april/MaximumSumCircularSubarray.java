package leet_code.till_april;

public class MaximumSumCircularSubarray {


//    Given a circular integer array nums of length n, return the maximum possible sum of a non-empty subarray of nums.
//
//    A circular array means the end of the array connects to the beginning of the array. Formally,
//    the next element of nums[i] is nums[(i + 1) % n] and the previous element of nums[i] is nums[(i - 1 + n) % n].
//
//    A subarray may only include each element of the fixed buffer nums at most once. Formally,
//    for a subarray nums[i], nums[i + 1], ..., nums[j], there does not exist i <= k1, k2 <= j with k1 % n == k2 % n.
//


    public static void main(String[] args) {
//        System.out.println(maxSubarraySumCircular(new int[]{1, -2, 3, -2}));
//        System.out.println(maxSubarraySumCircular2(new int[]{6,9,-3}));
        System.out.println(maxSubarraySumCircular2(new int[]{-3, -2, -3}));
    }


    //    Time Limit Exceeded
    public static int maxSubarraySumCircular(int[] nums) { //1, -2, 3, -2
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%d ",nums[(i + j) % n]);
                sum += nums[(i + j) % n];
                if (max < sum) max = sum;
            }
            System.out.println();
            sum = 0;
        }
        return max;
    }

    public static int maxSubarraySumCircular2(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {
                if ((i + j) >= n) {

                    System.out.printf("%d ",nums[(i + j) % n]);

                    sum += nums[(i + j) % n];
                    if (max < sum) max = sum;
                }
            }
            System.out.println();
            sum = 0;
        }
        return max;
    }



    public int maxSubarraySumCircular3(int[] nums) {
        //calculating max Subarray sum using kadane's Algo (linear array)
        int max=Integer.MIN_VALUE, sum=0, total=0;
        for(int x:nums){
            sum+=x;
            max=Math.max(max,sum);
            if(sum<0)
                sum=0;
            total+=x; //calculating sum of elements of nums
        }

        int max2=0;
        sum=0;
        for(int x:nums){
            max=Math.max(max,total+max2); //updating max when right sum + x + max left sum>max
            total-=x; //right sum
            sum+=x; //left sum
            max2=Math.max(max2,sum); //maximum left sum
        }
        return max;
    }
}
