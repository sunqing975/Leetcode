package com.leetcode.swordoffer.day21;

public class Solution65 {
    /**
     * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
     *
     * @param a
     * @param b
     * @return
     */
    public int add(int a, int b) {
        if (b == 0) {
            return a;
        }
        // 转换成非进位和 + 进位
        return add(a ^ b, (a & b) << 1);
    }

    public static void main(String[] args) {
        Solution65 solution65 = new Solution65();
        System.out.println(solution65.add(1, 2));
    }
}
