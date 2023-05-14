package org.job.swordoffer.day21;

public class Solution15 {
    // 编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为 汉明重量).）。
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
        while(n != 0) {
            res += n & 1;
            n >>>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution15 solution15 = new Solution15();
        int i = solution15.hammingWeight(-2147483648);
        System.out.println(i);
    }
}
