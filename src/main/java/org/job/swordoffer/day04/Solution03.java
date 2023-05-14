package org.job.swordoffer.day04;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 找出数组中重复的数字。
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 */
public class Solution03 {
    public int findRepeatNumber(int[] nums) {
        Set<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            if (hashSet.contains(num)) {
                return num;
            }
            hashSet.add(num);
        }
        return -1;
    }

    /**
     * 遍历中，第一次遇到数字 xxx 时，将其交换至索引 xxx 处；
     * 而当第二次遇到数字 xxx 时，一定有 nums[x]=x nums[x] = x nums[x]=x ，此时即可得到一组重复数字。
     *
     * @param nums
     * @return
     */
    public int findRepeatNumber2(int[] nums) {
        int length = nums.length;
        int i = 0;
        while (i < length) {
            if (nums[i] == i){
                i++;
            }else {
                if (nums[nums[i]]==nums[i]){
                    return nums[i];
                }
                int tmp = nums[i];
                nums[i] = nums[tmp];
                nums[tmp] = tmp;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] ints = {2, 3, 1, 0, 2, 5, 3};
        Solution03 solution03 = new Solution03();
        int repeatNumber = solution03.findRepeatNumber2(ints);
        System.out.println(repeatNumber);
    }
}
