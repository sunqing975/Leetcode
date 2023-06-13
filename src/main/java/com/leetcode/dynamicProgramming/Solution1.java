package com.leetcode.dynamicProgramming;

/**
 * 题目一
 * 假设有拍成一行的 N 个位置，记为 1~N, N一定大于或等于 2
 * 开始时机器人在其中的 cur 位置上（cur 一定是 1~N中的一个）
 * 如果机器人来到 1 位置，那么下一步只能往右来到 2 位置
 * 如果机器人来到 N 位置，那么下一步只能往右来到 N-1 位置
 * 如果机器人来到中间位置，他的下一步可以向左也可以向右走
 * 规定机器人必须走 K 步，最终能够来到 end 位置（ end 也是 1~N 中的一个）的方法有多少种
 * 给定四个参数 N、cur、K、end，返回方法数
 */
public class Solution1 {
    /**
     * 暴力递归方式
     *
     * @return
     */
    public static int way01(int N, int cur, int step, int end) {
        if (N < 2 || cur < 1 || cur > N || step < 1 || end < 1 || end > N) {
            return -1;
        }
        return process01(N, cur, step, end);
    }

    private static int process01(int N, int cur, int step, int end) {
        if (step == 0) {
            return cur == end ? 1 : 0;
        }
        if (cur == 1) {
            return process01(N, 2, step - 1, end);
        }
        if (cur == N) {
            return process01(N, N - 1, step - 1, end);
        }
        return process01(N, cur + 1, step - 1, end) + process01(N, cur - 1, step - 1, end);
    }

    /**
     * 记忆化递归法
     *
     * @return
     */
    public static int way02(int N, int cur, int step, int end) {
        if (N < 2 || cur < 1 || cur > N || step < 1 || end < 1 || end > N) {
            return -1;
        }
        int[][] dp = new int[N + 1][step + 1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= step; j++) {
                dp[i][j] = -1;
            }
        }
        return process02(N, cur, step, end, dp);
    }

    private static int process02(int N, int cur, int step, int end, int[][] dp) {
        if (dp[cur][step] != -1) {
            return dp[cur][step];
        }
        int ans;
        if (step == 0) {
            ans = cur == end ? 1 : 0;
        } else if (cur == 1) {
            ans = process02(N, 2, step - 1, end, dp);
        } else if (cur == N) {
            ans = process02(N, N - 1, step - 1, end, dp);
        } else {
            ans = process02(N, cur + 1, step - 1, end, dp) + process02(N, cur - 1, step - 1, end, dp);
        }
        dp[cur][step] = ans;
        return ans;
    }

    public static int way03(int N, int cur, int step, int end) {
        if (N < 2 || cur < 1 || cur > N || step < 1 || end < 1 || end > N) {
            return -1;
        }
        int[][] dp = new int[N + 1][step + 1];
        dp[end][0] = 1;
        for (int i = 1; i <= step; i++) {
            dp[1][i] = dp[2][i - 1];
            for (int j = 2; j < N; j++) {
                dp[j][i] = dp[j - 1][i - 1] + dp[j + 1][i - 1];
            }
            dp[N][i] = dp[N - 1][i - 1];
        }
        return dp[cur][step];
    }

    public static void main(String[] args) {
        System.out.println(way01(5, 3, 4, 5));
        System.out.println(way02(5, 3, 4, 5));
        System.out.println(way03(5, 3, 4, 5));
    }
}
