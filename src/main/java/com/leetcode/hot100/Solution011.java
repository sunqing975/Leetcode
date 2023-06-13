package com.leetcode.hot100;

public class Solution011 {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int maxArea = 0;
        while (l < r) {
            int curArea = (r - l) * Math.min(height[l], height[r]);
            if (curArea > maxArea) {
                maxArea = curArea;
            }
            if (height[l] > height[r]) {
                r--;
            } else {
                l++;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        Solution011 solution011 = new Solution011();
        int i = solution011.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
        System.out.println(i);
    }
}
