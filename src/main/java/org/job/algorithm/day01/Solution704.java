package org.job.algorithm.day01;

import java.util.Random;

/**
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，
 * 写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 */
public class Solution704 {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            // int m = (l + r) >> 1;
            if (nums[m] == target) {
                return m;
            } else if (nums[m] > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution704 solution704 = new Solution704();
        int[] ints = new int[100000];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = i;
        }
        long l = System.currentTimeMillis();
        int search = solution704.search(ints, 9);
        long l1 = System.currentTimeMillis();
        System.out.println(l1 - l);
    }
}
