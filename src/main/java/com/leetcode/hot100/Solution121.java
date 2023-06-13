package com.leetcode.hot100;

public class Solution121 {

    // 先来一个暴力
    public int maxProfit2(int[] prices) {
        int length = prices.length;
        int max = 0;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (prices[j] <= prices[i]) {
                    int reward = prices[j] - prices[i];
                    if (reward > max) {
                        max = reward;
                    }
                }
            }
        }
        return max;
    }


    public int maxProfit(int[] prices) {
        int length = prices.length;
        int get = 0;
        int out = 0;
        int max = 0;
        for (int i = 0; i < length; i++) {
            if (prices[i] > prices[out]) {
                out = i;
            } else if (prices[i] < prices[get]) {
                get = i;
                if (out < get) {
                    out = get;
                }
            }
            int tmp = prices[out] - prices[get];
            if (tmp > max) {
                max = tmp;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution121 solution121 = new Solution121();
        int maxProfit = solution121.maxProfit(new int[]{2, 4, 1});
        // int maxProfit = solution121.maxProfit2(new int[]{7, 1, 5, 3, 6, 4});
        System.out.println(maxProfit);
    }
}
