package com.leetcode.swordoffer.day09;

/**
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * 要求时间复杂度为O(n)。
 * 转移方程
 * 当 dp[i−1]>0dp[i - 1] > 0dp[i−1]>0 时：执行 dp[i]=dp[i−1]+nums[i]dp[i] = dp[i-1] + nums[i]dp[i]=dp[i−1]+nums[i] ；
 * 当 dp[i−1]≤0dp[i - 1] \leq 0dp[i−1]≤0 时：执行 dp[i]=nums[i]dp[i] = nums[i]dp[i]=nums[i] ；
 */
public class Solution42 {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i - 1], 0);
            res = Math.max(res, nums[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution42 solution42 = new Solution42();
        int[] arr = {-2, 1, -2};
        System.out.println(solution42.maxSubArray(arr));
    }
}
