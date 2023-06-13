package com.leetcode.swordoffer.day14;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
 * 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），
 * 也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，
 * 因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 */
public class Soultion13 {
    /**
     * BFS实现： 通常利用队列实现广度优先遍历。
     *
     * @param m
     * @param n
     * @param k
     * @return
     */
    public int movingCount2(int m, int n, int k) {
        boolean[][] viewed = new boolean[m][n];
        Deque<int[]> queue = new ArrayDeque<>();
        queue.addLast(new int[]{0, 0, 0});
        int ans = 0;
        while (queue.size() > 0) {
            int[] poll = queue.pollFirst();
            if (poll[0] >= m || poll[1] >= n || viewed[poll[0]][poll[1]] || poll[2] > k) {
                continue;
            }
            viewed[poll[0]][poll[1]] = true;
            ans++;
            queue.addLast(new int[]{poll[0] + 1, poll[1], splitNum2(poll[0] + 1, poll[1])});
            queue.addLast(new int[]{poll[0], poll[1] + 1, splitNum2(poll[0], poll[1] + 1)});
        }
        return ans;
    }
    private int splitNum2(int i, int j) {
        int sum = 0;
        while (i != 0 || j != 0) {
            sum += i % 10;
            sum += j % 10;
            i /= 10;
            j /= 10;
        }
        return sum;
    }

    /**
     * DFS
     *
     * @param m
     * @param n
     * @param k
     * @return
     */
    public int movingCount(int m, int n, int k) {
        int[] dp = new int[Math.max(m, n)];

        Arrays.fill(dp, -1);
        boolean[][] viewed = new boolean[m][n];
        return dfs(0, 0, m, n, k, dp, viewed);
    }

    private int dfs(int i, int j, int m, int n, int k, int[] dp, boolean[][] viewed) {
        if (i >= m || j >= n || viewed[i][j] || (splitNum(i, dp) + splitNum(j, dp) > k)) {
            return 0;
        }
        viewed[i][j] = true;
        return 1 + dfs(i, j + 1, m, n, k, dp, viewed) + dfs(i + 1, j, m, n, k, dp, viewed);
    }

    private int splitNum(int i, int[] dp) {
        if (dp[i] != -1) {
            return dp[i];
        }
        int sum = 0;
        int num = i;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        dp[i] = sum;
        return dp[i];
    }

    public static void main(String[] args) {
        Soultion13 soultion13 = new Soultion13();
        // int num = soultion13.splitNum(35, 3);
        // System.out.println(num);
        // int movingCount = soultion13.movingCount(2, 3, 1);
        int movingCount2 = soultion13.movingCount2(2, 3, 1);
        System.out.println(movingCount2);
    }
}
