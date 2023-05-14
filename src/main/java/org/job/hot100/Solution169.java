package org.job.hot100;

import java.util.Arrays;

public class Solution169 {
    public int majorityElement(int[] nums) {
        // Arrays.sort(nums);
        quickSort(nums, 0, nums.length - 1);
        return nums[nums.length >> 1];
    }

    public void quickSort(int[] nums, int i, int j) {
        if (i >= j) {
            return;
        }
        int base = nums[i];
        int m = i;
        int n = j;
        while (m < n) {

            while (nums[n] > base && m < n) {
                n--;
                // break;
            }
            while (nums[m] <= base && m < n) {
                m++;
                // break;
            }
            int tmp = nums[m];
            nums[m] = nums[n];
            nums[n] = tmp;

        }
        int tmp = nums[i];
        nums[i] = nums[m];
        nums[m] = tmp;
        quickSort(nums, i, m - 1);
        quickSort(nums, m + 1, j);
    }

    public static void main(String[] args) {
        Solution169 solution169 = new Solution169();
        int i = solution169.majorityElement(new int[]{3, 2, 3});
        System.out.println(i);
    }
}
