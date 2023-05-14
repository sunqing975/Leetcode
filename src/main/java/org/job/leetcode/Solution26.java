package org.job.leetcode;

// 删除有序数组中的重复项
public class Solution26 {
    public static void main(String[] args) {
        Solution26 solution26 = new Solution26();
        int[] nums = {1, 1, 2};
        int i = solution26.removeDuplicates(nums);
        System.out.println(i);
    }

    public int removeDuplicates(int[] nums) {
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[count]) {
                count++;
                nums[count] = nums[i];
            }
        }
        //System.out.println(Arrays.toString(nums));
        return count + 1;
    }
}
