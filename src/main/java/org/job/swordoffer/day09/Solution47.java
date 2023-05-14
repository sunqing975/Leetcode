package org.job.swordoffer.day09;

/**
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
 * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
 * 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 */
public class Solution47 {
    /**
     * 记忆化递归
     *
     * @param grid
     * @return
     */
    public int maxValue2(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        return getMaxValue(grid, 0, 0, dp);
    }

    private int getMaxValue(int[][] grid, int i, int j, int[][] dp) {
        if (i >= grid.length || j >= grid[0].length) {
            return 0;
        }
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        int i1 = getMaxValue(grid, i + 1, j, dp);
        int i2 = getMaxValue(grid, i, j + 1, dp);
        dp[i][j] = Math.max(i1, i2) + grid[i][j];
        return dp[i][j];
    }


    /**
     * 动态规划
     *
     * @param grid
     * @return
     */
    public int maxValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (i == 0) {
                    grid[i][j] = grid[i][j] + grid[i][j - 1];
                } else if (j == 0) {
                    grid[i][j] = grid[i][j] + grid[i - 1][j];
                } else {
                    grid[i][j] = grid[i][j] + Math.max(grid[i - 1][j], grid[i][j - 1]);
                }
            }
        }
        return grid[m - 1][n - 1];
    }


    public static void main(String[] args) {

    }
}
