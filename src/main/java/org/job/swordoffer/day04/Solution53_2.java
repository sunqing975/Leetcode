package org.job.swordoffer.day04;

/**
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，
 * 并且每个数字都在范围0～n-1之内。
 * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 */
public class Solution53_2 {
    public int missingNumber(int[] nums) {
        if (nums[0] != 0) {
            return 0;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] != 1) {
                return nums[i] - 1;
            }
        }
        return nums[nums.length - 1] + 1;
    }

    public static void main(String[] args) {
        Solution53_2 solution53_2 = new Solution53_2();
        // int i = solution53_2.missingNumber(new int[]{0,1,2,3,4,5,6,7,9});
        int i = solution53_2.missingNumber(new int[]{0, 1, 3});
        System.out.println(i);
    }
}
