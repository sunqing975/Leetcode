package org.job.leetcode;
// 寻找两个正序数组的中位数
public class Solution4 {
    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        int[] nums1 = {1, 3};
        int[] nums2 = {2,4};
        double medianSortedArrays = solution4.findMedianSortedArrays(nums1, nums2);
        System.out.println(medianSortedArrays);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[] nums = new int[n1 + n2];
        for (int i = 0; i < n1; i++) {
            nums[i] = nums1[i];
        }
        for (int i = 0; i < n2; i++) {
            nums[n1++] = nums2[i];
        }
        //    冒泡排序 从小到大
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int tmp = 0;
                if (nums[i] > nums[j]) {
                    tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
        int flag = nums.length % 2;
        int midindex = nums.length / 2;
        if (flag == 0) {
            return (nums[midindex - 1] + nums[midindex]) / 2.0;
        } else {
            return nums[midindex];
        }
    }
}
