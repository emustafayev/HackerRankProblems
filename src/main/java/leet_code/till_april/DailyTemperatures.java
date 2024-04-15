package leet_code.till_april;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(dailyTemperatures2(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }


    public static int[] dailyTemperatures(int[] temperatures) { //timeout error. need to implement using stack

//        Input: temperatures = [73,74,75,71,69,72,76,73]
//        Output: [1,1,4,2,1,1,0,0]
        int[] answer = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            int currentTemp = temperatures[i];
            int dayWait = 1;


            while ((i + dayWait) < temperatures.length) {
                if (currentTemp < temperatures[i + dayWait]) {
                    answer[i] = dayWait;
                    break;
                }
                dayWait++;
            }
        }

        return answer;
    }

    //        Input: temperatures = [73,74,75,71,69,72,76, 72,73]
//        Output: [1,1,4,2,1,1,0,0]


    /**
     * Steps:
     * 1. add index of element from last
     * 2. if number greater than current
     */
    public static int[] dailyTemperatures2(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int index = n - 1; index > 0; index--) {


            while (!stack.empty() && nums[index] >= nums[stack.peek()]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                ans[index] = stack.pop() - index;
            }

            stack.add(index);
        }
        return ans;
    }
}
