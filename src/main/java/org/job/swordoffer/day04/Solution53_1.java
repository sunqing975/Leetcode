package org.job.swordoffer.day04;

/**
 * 统计一个数字在排序数组中出现的次数。
 */
public class Solution53_1 {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        boolean flag = false;
        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (nums[mid] > target) {
                r = mid - 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
                l = mid;
                flag = true;
                break;
            }
        }
        if (flag) {
            while (l >= 0) {
                if (nums[l] == target) {
                    l--;
                } else {
                    break;
                }
            }
            while (r < nums.length) {
                if (nums[r] == target) {
                    r++;
                } else {
                    break;
                }
            }
            return r - l - 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution53_1 solution53 = new Solution53_1();
        int search = solution53.search(new int[]{5, 7, 7, 8, 8, 10}, 7);
        System.out.println(search);
    }
}
