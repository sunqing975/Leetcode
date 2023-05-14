package org.job.swordoffer.day23;

/**
 * 给定一个数组 A[0,1,…,n-1]，
 * 请构建一个数组 B[0,1,…,n-1]，其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积,
 * 即 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。
 * 不能使用除法。
 *
 * @author Superman
 */
public class Solution66 {

    public int[] constructArr2(int[] a) {
        int len = a.length;
        if (len == 0) {
            return new int[0];
        }
        int[] b = new int[len];
        b[0] = 1;
        for (int i = 1; i < len; i++) {
            b[i] = b[i - 1] * a[i-1];
        }
        int tmp = 1;
        for (int i = len - 2; i >= 0; i--) {
            tmp *= a[i + 1];
            b[i] *= tmp;
        }
        return b;
    }

    public int[] constructArr(int[] a) {
        int len = a.length;
        int[] b = new int[len];
        for (int i = 0; i < len; i++) {
            int mult = 1;
            for (int j = 0; j < len; j++) {
                if (i == j) {
                    continue;
                }
                mult *= a[j];
            }
            b[i] = mult;
        }
        return b;
    }

    public static void main(String[] args) {
        Solution66 solution66 = new Solution66();
        int[] ints = solution66.constructArr(new int[]{1, 2, 3, 4, 5});
        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }
        System.out.println();
        int[] ints2 = solution66.constructArr2(new int[]{1, 2, 3, 4, 5});
        for (int anInt : ints2) {
            System.out.print(anInt + " ");
        }
    }
}
