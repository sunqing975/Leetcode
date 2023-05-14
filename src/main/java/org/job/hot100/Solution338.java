package org.job.hot100;

/**
 * @author Superman
 */
public class Solution338 {
    public int[] countBits3(int n) {
        int[] bits = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            bits[i] = recur2(i,bits);
        }
        return bits;
    }

    public int recur2(int n,int[] dp) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (n % 2 == 1) {
            return recur(n - 1) + 1;
        } else {
            return recur(n >> 1);
        }
    }

    public int[] countBits2(int n) {
        int[] bits = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            bits[i] = recur(i);
        }
        return bits;
    }

    public int recur(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (n % 2 == 1) {
            return recur(n - 1) + 1;
        } else {
            return recur(n >> 1);
        }
    }

    public int[] countBits(int n) {
        int[] bits = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            bits[i] = countOne(i);
        }
        return bits;
    }

    public int countOne(int n) {
        if (n == 0) {
            return n;
        }
        int count = 0;
        while (n > 0) {
            if ((n % 2) == 1) {
                count++;
            }
            n /= 2;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution338 solution338 = new Solution338();
        int[] ints = solution338.countBits2(5);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
