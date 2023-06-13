package com.leetcode.hot100;

public class Solution070 {
    public static void main(String[] args) {
        Solution070 solution070 = new Solution070();
        int i = solution070.climbStairs(5);
        System.out.println(i);
    }

    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        return recur(n, dp);
    }

    private int recur(int n, int[] dp) {
        if (dp[n] != 0) {
            return dp[n];
        }
        dp[n] = recur(n - 1, dp) + recur(n - 2, dp);
        return dp[n];
    }

}
