package org.job.swordoffer.day19;

/**
 * @author Superman
 */
public class Solution64 {
    /**
     * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
     *
     * @param n
     * @return
     */
    int res;
    public int sumNums(int n) {
        boolean b = n > 1 && (sumNums(n - 1)) > 0;
        res += n;
        return res;
    }

    public static void main(String[] args) {
        Solution64 solution64 = new Solution64();
        int i = solution64.sumNums(2);
        System.out.println(i);
    }
}
