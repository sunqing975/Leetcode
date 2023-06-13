package com.leetcode.swordoffer.day23;

import java.util.Arrays;
import java.util.HashMap;

public class Solution39 {
    /**
     * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
     * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = nums.length >> 1;
        int ans = 0;
        for (int num : nums) {
            if (map.containsKey(num)) {
                int m = map.get(num) + 1;
                map.put(num, m);
                if (m > count) {
                    ans = num;
                    break;
                }
            } else {
                map.put(num, 1);
            }
        }
        return ans;
    }

    public int majorityElement2(int[] nums) {
        int x = 0, votes = 0;
        for (int num : nums) {
            if (votes == 0) x = num;
            votes += num == x ? 1 : -1;
        }
        return x;
    }

    public int majorityElement3(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length >> 1];
    }

    public static void main(String[] args) {
        Solution39 solution39 = new Solution39();
        System.out.println(solution39.majorityElement(new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2}));
        System.out.println(solution39.majorityElement2(new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2}));
        System.out.println(solution39.majorityElement3(new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2}));
    }
}
