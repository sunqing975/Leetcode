package com.leetcode.hot100;

public class Solution283 {
    public void moveZeroes2(int[] nums) {
        int len = nums.length;
        int i = 0;
        int j = 0;

        NO1:
        while (i < len) {
            while (nums[i] != 0) {
                i++;
                if (i >= len) {
                    break NO1;
                }
            }
            j = i;
            while (nums[j] == 0) {
                j++;
                if (j >= len) {
                    break NO1;
                }
            }

            int tmp = nums[j];
            nums[j] = nums[i];
            nums[i] = tmp;
        }
    }

    public void moveZeroes(int[] nums) {
        int len = nums.length;
        int i = 0;
        int zeroNum = 0;
        while (i < len && len != zeroNum) {
            if (nums[i] != 0) {
                i++;
                continue;
            }
            zeroNum++;
            for (int j = i + 1; j < len; j++) {
                nums[j - 1] = nums[j];
            }
            if (nums[len - 1] != 0) {
                nums[len - 1] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Solution283 solution283 = new Solution283();
        int[] nums = {45192};
        solution283.moveZeroes2(nums);
        for (int num : nums) {
            System.out.print(num + "  ");
        }
    }
}
