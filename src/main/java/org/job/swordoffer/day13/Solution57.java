package org.job.swordoffer.day13;

/**
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。
 * 如果有多对数字的和等于s，则输出任意一对即可。
 * 限制：
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^6
 *
 * @author Superman
 */
public class Solution57 {
    public int[] twoSum(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        if (nums[i] > target) {
            return new int[0];
        }
        while (j > i) {
            if (nums[i] + nums[j] > target) {
                j--;
            } else if (nums[i] + nums[j] < target) {
                i++;
            } else {
                break;
            }
        }
        int[] ints = new int[2];
        ints[0] = nums[i];
        ints[1] = nums[j];
        return ints;
    }

    public static void main(String[] args) {
        Solution57 solution57 = new Solution57();
        int[] arr = {2, 7, 11, 15};
        int[] twoSum = solution57.twoSum(arr, 9);
        for (int i : twoSum) {
            System.out.println(i);
        }
    }
}
