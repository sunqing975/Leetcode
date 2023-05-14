package org.job.algorithm.day01;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
 * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 请必须使用时间复杂度为 O(log n) 的算法。
 * @author Superman
 */
public class Solution35 {
    public int searchInsert(int[] nums, int target) {
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
        if (r > 0) {
            if (nums[r] > target) {
                return r;
            } else {
                return r + 1;
            }
        } else {
            if (l == 0) {
                if (nums[l] > target) {
                    return l;
                } else {
                    return l + 1;
                }
            } else {
                if (nums[l - 1] > target) {
                    return l - 1;
                } else {
                    return l;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution35 solution35 = new Solution35();
        // int i = solution35.searchInsert(new int[]{1,3,5,6},5);
        int i = solution35.searchInsert(new int[]{1, 3, 5, 6}, 0);
        // int i = solution35.searchInsert(new int[]{1}, 2);
        System.out.println(i);
    }
}
