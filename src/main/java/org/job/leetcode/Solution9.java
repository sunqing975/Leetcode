package org.job.leetcode;

import java.util.ArrayList;

// 回文数
public class Solution9 {
    // 复杂
    public boolean isPalindrome(int x) {
        if (x < 0){
            return false;
        }
        ArrayList<Integer> integers = new ArrayList<>();
        while (x > 0){
            int i = x % 10;
            x = x /10;
            integers.add(i);
        }
        int l = 0;
        int r = integers.size()-1;
        while (l < r){
            if (!integers.get(l).equals(integers.get(r))){
                return false;
            }
            l ++;
            r --;
        }
        return true;
    }
    // 求逆序数
    public boolean isPalindrome2(int x) {
        if (x < 0){
            return false;
        }
        int rev = 0 ;
        int tmp = x;
        while (tmp > 0){
            int i = tmp % 10;
            tmp = tmp /10;
            rev = rev * 10 + i;
        }
        return rev == x;
    }
    public static void main(String[] args) {
        Solution9 solution9 = new Solution9();
        boolean palindrome = solution9.isPalindrome(122);
        System.out.println(palindrome);
    }
}
