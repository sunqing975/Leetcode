package com.leetcode.hot100;

import java.util.HashMap;
import java.util.Map;

public class Solution001 {
    //
    public int[] twoSum2(int[] nums, int target) {
        if (nums.length == 0){
            return new int[0];
        }
        int[] twoIndex = new int[2];
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (map.containsKey(target - nums[i])){
                twoIndex[0] = i;
                twoIndex[1] = map.get(target - nums[i]);
                break ;
            }else {
                map.put(nums[i], i);
            }
        }
        return twoIndex;
    }
    // 暴力
    public int[] twoSum(int[] nums, int target) {
        if (nums.length == 0){
            return new int[0];
        }
        int[] twoIndex = new int[2];

        int len = nums.length;
        NO1:
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i == j) {
                    continue;
                }
                if (nums[i] + nums[j] == target) {
                    twoIndex[0] = i;
                    twoIndex[1] = j;
                    break NO1;
                }
            }
        }
        return twoIndex;
    }

    public static void main(String[] args) {
        Solution001 soultion001 = new Solution001();
        int[] twoSum = soultion001.twoSum(new int[]{3,3}, 6);
        int[] twoSum2 = soultion001.twoSum2(new int[]{3,3}, 6);
        for (int i : twoSum) {
            System.out.println(i);
        }
        for (int i : twoSum2) {
            System.out.println(i);
        }
    }
}
