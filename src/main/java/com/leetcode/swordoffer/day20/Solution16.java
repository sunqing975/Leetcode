package com.leetcode.swordoffer.day20;

public class Solution16 {
    public double myPow2(double x, int n) {
        if (x == 0) {
            return 0;
        }
        long b = n;
        double res = 1.0;
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        while (b > 0) {
            if ((b & 1) == 1) {
                res *= x;
            }
            x *= x;
            b >>= 1;
        }
        return res;
    }

    public double myPow(double x, int n) {
        double pow = 1.0;

        for (int i = 0; i < Math.abs(n); i++) {
            pow *= x;
        }
        if (n < 0) {
            return 1 / pow;
        }
        return pow;
    }

    public static void main(String[] args) {
        Solution16 solution16 = new Solution16();
        double myPow = solution16.myPow(2.0, 10);
        System.out.println(myPow);
    }
}
