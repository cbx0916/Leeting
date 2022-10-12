package com.company;

public class Best_Time_to_Buy_and_Sell_Stock_II {
    public static int maxProfit(int[] prices) {
        int len = prices.length - 1;
        int profit = 0;
        while (len >= 1 ){
            if ( prices[len] > prices[len-1])
                profit += prices[len] - prices[len-1];
            len-- ;
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{7,1,5,3,6,4};//7
        int[] prices2 = new int[]{1,2,3,4,5};//4
        System.out.println(maxProfit(prices));
    }
}
