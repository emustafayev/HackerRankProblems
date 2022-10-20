package leet_code;

public class ClimbingStairs {

    public static void main(String[] args) {

        System.out.println(climbStairs2(5));

    }

    public int climbStairs3(int n) {
        if (n <= 1) {
            return 1;
        }

        int prev1 = 1;
        int prev2 = 2;

        for (int i = 3; i <= n; i++) {
            int newValue = prev1 + prev2;
            prev1 = prev2;
            prev2 = newValue;
        }

        return prev2;
    }
    // 2
    // 3
    // 2 - > 1 ==> 3

    public static int climbStairs2(int n) {
        if (n <= 1) {
            return 1;
        }

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        //dp[3] = 3
        //dp[4] = 5
        //dp[5] = 8

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}
