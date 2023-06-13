package com.leetcode.swordoffer.day03;

/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 */
public class Solution05 {
    public String replaceSpace(String s) {
        return s.replaceAll(" ", "%20");
    }
    public String replaceSpace2(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (aChar == ' '){
                stringBuilder.append("%20");
            }else {
                stringBuilder.append(aChar);
            }
        }
        return stringBuilder.toString();
    }
    public static void main(String[] args) {
        Solution05 solution05 = new Solution05();
        String s = solution05.replaceSpace("We are happy.");
        System.out.println(s);
    }
}
