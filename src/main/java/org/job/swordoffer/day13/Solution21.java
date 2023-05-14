package org.job.swordoffer.day13;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。
 *
 * @author Superman
 */
public class Solution21 {
    public int[] exchange(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (right > left) {
            // x&1 位运算 等价于 x%2 取余运算，即皆可用于判断数字奇偶性。
            if ((nums[left] & 1) == 1) {
                left++;
            }
            if ((nums[right] & 1) == 0) {
                right--;
            }
            if (right > left && (nums[left] & 1) == 0 && (nums[right] & 1) != 0) {
                int tmp = nums[right];
                nums[right] = nums[left];
                nums[left] = tmp;
                left++;
                right--;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        Solution21 solution21 = new Solution21();
        int[] ints = {11, 9, 3, 7, 16, 4, 2, 0};
        int[] exchange = solution21.exchange(ints);
        for (int i : exchange) {
            System.out.println(i);
        }
    }
}
