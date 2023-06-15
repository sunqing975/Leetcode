package com.leetcode.hot100;

import java.util.HashMap;
import java.util.Map;

public class Solution560 {

    public int subarraySum4(int[] nums, int k) {
        // key：前缀和，value：key 对应的前缀和的个数
        Map<Integer, Integer> preSumFreq = new HashMap<>();
        // 对于下标为 0 的元素，前缀和为 0，个数为 1
        preSumFreq.put(0, 1);

        int preSum = 0;
        int count = 0;
        for (int num : nums) {
            preSum += num;

            // 先获得前缀和为 preSum - k 的个数，加到计数变量里
            if (preSumFreq.containsKey(preSum - k)) {
                count += preSumFreq.get(preSum - k);
            }

            // 然后维护 preSumFreq 的定义
            preSumFreq.put(preSum, preSumFreq.getOrDefault(preSum, 0) + 1);
        }
        return count;
    }


    public int subarraySum3(int[] nums, int k) {
        int len = nums.length;
        // 计算前缀和数组
        int[] preSum = new int[len + 1];
        preSum[0] = 0;
        for (int i = 0; i < len; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        int count = 0;
        for (int left = 0; left < len; left++) {
            for (int right = left; right < len; right++) {
                // 区间和 [left..right]，注意下标偏移
                if (preSum[right + 1] - preSum[left] == k) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 暴力破解优化
     */
    public int subarraySum2(int[] nums, int k) {
        int count = 0;
        int len = nums.length;
        for (int left = 0; left < len; left++) {
            int sum = 0;
            // 区间里可能会有一些互相抵销的元素
            for (int right = left; right < len; right++) {
                sum += nums[right];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }


    /**
     * 暴力破解
     *
     * @param nums 整数
     * @param k    和
     * @return 连续子数组和为k的数量
     */
    public int subarraySum(int[] nums, int k) {
        int i = 0;
        int j = 0;
        int count = 0;
        while (i < nums.length) {
            j = i;
            while (j < nums.length) {
                if (sum(nums, i, j) == k) {
                    count++;
                }
                j++;
            }
            i++;
        }
        return count;
    }

    private static int sum(int[] nums, int i, int j) {
        int sum = 0;
        while (i <= j) {
            sum += nums[i];
            i++;
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution560 solution560 = new Solution560();
        System.out.println(solution560.subarraySum(new int[]{1, 1, 1}, 2));
        System.out.println(solution560.subarraySum(new int[]{1, 2, 3}, 3));
        System.out.println(solution560.subarraySum(new int[]{1}, 1));
        System.out.println(solution560.subarraySum(new int[]{1}, 0));
        System.out.println(solution560.subarraySum(new int[]{-1, -1, 1}, 0));
        System.out.println("======================");
        System.out.println(solution560.subarraySum2(new int[]{1, 1, 1}, 2));
        System.out.println(solution560.subarraySum2(new int[]{1, 2, 3}, 3));
        System.out.println(solution560.subarraySum2(new int[]{1}, 1));
        System.out.println(solution560.subarraySum2(new int[]{1}, 0));
        System.out.println(solution560.subarraySum2(new int[]{-1, -1, 1}, 0));
        System.out.println("======================");
        System.out.println(solution560.subarraySum3(new int[]{1, 1, 1}, 2));
        System.out.println(solution560.subarraySum3(new int[]{1, 2, 3}, 3));
        System.out.println(solution560.subarraySum3(new int[]{1}, 1));
        System.out.println(solution560.subarraySum3(new int[]{1}, 0));
        System.out.println(solution560.subarraySum3(new int[]{-1, -1, 1}, 0));
        System.out.println("======================");
        System.out.println(solution560.subarraySum4(new int[]{1, 1, 1}, 2));
        System.out.println(solution560.subarraySum4(new int[]{1, 2, 3}, 3));
        System.out.println(solution560.subarraySum4(new int[]{1}, 1));
        System.out.println(solution560.subarraySum4(new int[]{1}, 0));
        System.out.println(solution560.subarraySum4(new int[]{-1, -1, 1}, 0));
    }
}
