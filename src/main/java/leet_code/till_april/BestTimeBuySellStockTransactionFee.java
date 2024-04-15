package leet_code.till_april;

public class BestTimeBuySellStockTransactionFee {


//    You are given an array prices where prices[i] is the price of a given stock on the ith day, and an integer
//    fee representing a transaction fee.
//
//    Find the maximum profit you can achieve. You may complete as many transactions as you like, but you need
//    to pay the transaction fee for each transaction.
//
//    Note: You may not engage in multiple transactions simultaneously
//    (i.e., you must sell the stock before you buy again).


//    Input: prices = [1,3,2,8,4,9], fee = 2
//    Output: 8
//    Explanation: The maximum profit can be achieved by:
//            - Buying at prices[0] = 1
//            - Selling at prices[3] = 8
//            - Buying at prices[4] = 4
//            - Selling at prices[5] = 9
//    The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.


//    Consider the first K stock prices. At the end, the only legal states are that you
//    don't own a share of stock, or that you do. Calculate the most profit you could have under each of these two cases.

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2));
    }


    public static int maxProfit(int[] prices, int fee) {

        int buy = Integer.MIN_VALUE;
        int sell = 0;


        for (int price : prices) {

            buy = Math.max(buy, sell - price);

            sell = Math.max(sell, buy + price - fee);
        }
        return sell;
    }


}
