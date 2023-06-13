package com.leetcode.hot100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution128 {

    public int longestConsecutive2(int[] nums) {
        // key表示num，value表示num所在连续区间的长度
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int num : nums) {
            // 当map中不包含num，也就是num第一次出现
            if (!map.containsKey(num)) {
                // left为num-1所在连续区间的长度，更进一步理解为：左连续区间的长度
                int left = map.getOrDefault(num - 1, 0);
                // right为num+1所在连续区间的长度，更进一步理解为：右连续区间的长度
                int right = map.getOrDefault(num + 1, 0);
                // 当前连续区间的总长度
                int curLen = left + right + 1;
                ans = Math.max(ans, curLen);
                // 将num加入map中，表示已经遍历过该值。其对应的value可以为任意值。
                map.put(num, -1);
                // 更新当前连续区间左边界和右边界对应的区间长度
                map.put(num - left, curLen);
                map.put(num + right, curLen);
            }
        }
        return ans;
    }

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int l = 0;
        int r = l + 1;
        int max = 0;
        int count = 0;
        while (l < nums.length - 1 && r < nums.length) {
            if (nums[r] - nums[r - 1] == 0) {
                count++;
                r++;
            } else {
                if (nums[r] - nums[r - 1] == 1) {
                    if (r - l - count > max) {
                        max = r - l - count;
                    }
                    r++;
                } else {
                    l = r;
                    r = l + 1;
                    count = 0;
                }
            }
        }
        return max + 1;
    }

    public static void main(String[] args) {
        Solution128 solution128 = new Solution128();
        //int i = solution128.longestConsecutive(new int[]{1, 2, 0, 1});
        int i = solution128.longestConsecutive2(new int[]{1, 2, 0, 1});
        System.out.println(i);
    }
}
