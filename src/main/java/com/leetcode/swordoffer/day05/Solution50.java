package com.leetcode.swordoffer.day05;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 */
public class Solution50 {
    /**
     * 有序哈希表
     * Java 使用 LinkedHashMap 实现有序哈希表。
     *
     * @param s
     * @return
     */
    public char firstUniqChar2(String s) {
        if (" ".equals(s) || s == null) {
            return ' ';
        }
        Map<Character, Boolean> map = new LinkedHashMap<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            map.put(c, !map.containsKey(c));
        }
        for (Map.Entry<Character, Boolean> entry : map.entrySet()) {
            if (entry.getValue()) {
                return entry.getKey();
            }
        }
        return ' ';
    }

    public char firstUniqChar(String s) {
        if (" ".equals(s) || s == null) {
            return ' ';
        }
        int n = s.length();
        char[] chars = s.toCharArray();
        for (int i = 0; i < n; i++) {
            String c = chars[i] + "";
            if (s.indexOf(c) == s.lastIndexOf(c)) {
                return chars[i];
            }
        }
        return ' ';
    }

    public static void main(String[] args) {
        Solution50 solution50 = new Solution50();
        char abaccdeff = solution50.firstUniqChar("abaccdeff");
        System.out.println(abaccdeff);
    }
}
