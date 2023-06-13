package com.leetcode.swordoffer.day08;

/**
 * 假设把某股票的价格按照时间先后顺序存储在数组中，
 * 请问买卖该股票一次可能获得的最大利润是多少？
 */
public class Soultion63 {

    /**
     * 动态规划
     * 前i日最大利润=max(前(i−1)日最大利润,第i日价格−前i日最低价格)
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int cost = Integer.MAX_VALUE, profit = 0;
        for(int price : prices) {
            cost = Math.min(cost, price);
            profit = Math.max(profit, price - cost);
        }
        return profit;
    }


    /**
     * 暴力解法
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices == null) {
            return -1;
        }
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] > prices[i]) {
                    int tmp = prices[j] - prices[i];
                    if (tmp > max) {
                        max = tmp;
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Soultion63 soultion63 = new Soultion63();
        int[] profits = {7, 1, 5, 3, 6, 4};
        int[] profits2 = {7, 6, 5, 3, 1};
        System.out.println(soultion63.maxProfit(profits2));
        System.out.println(soultion63.maxProfit2(profits));
    }
}
