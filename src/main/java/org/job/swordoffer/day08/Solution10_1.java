package org.job.swordoffer.day08;

import java.util.Arrays;

/**
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 */
public class Solution10_1 {
    /**
     * 动态规划
     *
     * @param n
     * @return
     */
    public int fib2(int n) {
        if (n < 0) {
            return -1;
        } else if (n == 0 || n == 1) {
            return n;
        }
        int a = 0;
        int b = 1;
        int sum = a + b;
        for (int i = 2; i < n; i++) {
            a = b;
            b = sum;
            sum = (a + b) % 1000000007;
        }
        return sum;
    }


    /**
     * 记忆递归优化
     *
     * @param n
     * @return
     */
    public int fib(int n) {
        long[] dp = new long[n + 1];
        Arrays.fill(dp, -1);
        return (int) fibJy(n, dp);
    }

    public long fibJy(int n, long[] dp) {
        if (dp[n] != -1) {
            return dp[n];
        }
        long ans;
        if (n == 0) {
            ans = 0;
        } else if (n == 1) {
            ans = 1;
        } else {
            ans = fibJy(n - 1, dp) + fibJy(n - 2, dp);
        }
        dp[n] = ans;
        return ans % 1000000007;
    }

    /**
     * 递归法
     *
     * @param n
     * @return
     */
    public int fib1(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int num = fib(n - 1) + fib(n - 2);
        return num % 1000000007;
    }

    public static void main(String[] args) {
        Solution10_1 solution10_1 = new Solution10_1();
        long l = System.currentTimeMillis();
        int fib = solution10_1.fib(51);
        long l1 = System.currentTimeMillis();
        System.out.println("计算结果为：" + fib);
        System.out.println("计算消耗时间为：" + (l1 - l) + "毫秒");
        long l2 = System.currentTimeMillis();
        int fib1 = solution10_1.fib1(51);
        long l3 = System.currentTimeMillis();
        System.out.println("计算结果为：" + fib1);
        System.out.println("计算消耗时间为：" + (l3 - l2) + "毫秒");
        int fib2 = solution10_1.fib2(51);
        System.out.println("计算结果为：" + fib2);
    }
}
