package org.job.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 两数之和
public class Solution1 {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] ints = solution1.twoSum2(nums, target);
        System.out.println(Arrays.toString(ints));
    }

    public int[] twoSum2(int[] nums, int target) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>(len - 1);
        map.put(nums[0], 0);
        for (int i = 1; i < len; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }

    public int[] twoSum1(int[] nums, int target) {
        int len = nums.length;
        // 暴力破解
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }
}
