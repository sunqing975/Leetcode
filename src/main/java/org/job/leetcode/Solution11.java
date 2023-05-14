package org.job.leetcode;

//盛最多水的容器
public class Solution11 {
    public static void main(String[] args) {
        Solution11 solution11 = new Solution11();
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int i = solution11.maxArea(height);
        System.out.println(i);
    }

    public int maxArea(int[] height) {
        //   暴力
        int max = 0;
        int num = height.length;
        for (int i = 0; i < num; i++) {
            for (int i1 = i + 1; i1 < num; i1++) {
                int area;
                if (height[i] > height[i1]) {
                    area = (i1 - i) * height[i1];
                } else {
                    area = (i1 - i) * height[i];
                }
                if (area > max) {
                    max = area;
                }
            }
        }
        return max;
    }
}
