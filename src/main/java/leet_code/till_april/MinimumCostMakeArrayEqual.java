package leet_code.till_april;

public class MinimumCostMakeArrayEqual {


    public static void main(String[] args) {
        System.out.println(minCost2(new int[]{1, 3, 5, 2}, new int[]{2, 3, 1, 14}));
        System.out.println(minCost2(new int[]{2,2,2,2,2}, new int[]{4,2,8,1,3}));

    }


    //Not working
    public static long minCost(int[] nums, int[] cost) {

        int sum = 0;
        for (int i = 0; i < nums.length; i++)
            sum += nums[i];


        int avr = sum / nums.length;

        long costSum = 0;

        for (int i = 0; i < nums.length; i++) {
            costSum += (long) Math.abs(avr - nums[i]) * cost[i];
        }
        return costSum;
    }

//    Try finding the cost of changing the array
//    into each element, and return the minimum value.

    // time limit exception
    public static long minCost2(int[] nums, int[] cost) {

        long generalMinCost = Long.MAX_VALUE;

        for (int num : nums) {
            long minCost = 0;

            for (int j = 0; j < nums.length; j++)
                minCost += (long) Math.abs(num - nums[j]) * cost[j];

            generalMinCost = Math.min(minCost, generalMinCost);
        }
        return generalMinCost;
    }


}
