package leet_code.till_april;

import java.util.Arrays;

public class RichestCustomerWealth {
    public static void main(String[] args) {
        System.out.println(maximumWealth(
//                new int[][]{{1,2,3},{3,2,1}}
                new int[][]{{1,5},{7,3},{3,5}}
        ));
    }


    public static int maximumWealth(int[][] accounts) {
        int max = Integer.MIN_VALUE;
        int currentWealth = 0;
        for (int i = 0; i < accounts.length; i++) {
            currentWealth = Arrays
                    .stream(accounts[i])
                    .sum();
            if (max < currentWealth) {
                max = currentWealth;
            }
        }
        return max;
    }
}
