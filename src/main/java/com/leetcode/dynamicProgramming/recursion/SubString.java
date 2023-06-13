package com.leetcode.dynamicProgramming.recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 经典递归问题：生成字符串的子字符串和不重复的子字符串
 *
 * @author Superman
 */
public class SubString {
    /**
     * 生成字符串的所有子字符串
     *
     * @param s
     * @return
     */
    public List<String> getAllSubString(String s) {
        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }
        char[] chars = s.toCharArray();
        ArrayList<String> list = new ArrayList<>();
        String sub = "";
        recur1(chars, 0, sub, list);
        return list;
    }

    private void recur1(char[] chars, int index, String sub, ArrayList<String> list) {
        if (index == chars.length) {
            list.add(sub);
            return;
        }
        // 没有要index位置的字符
        recur1(chars, index + 1, sub, list);
        // 要了index位置的字符
        recur1(chars, index + 1, sub + chars[index], list);
    }

    /**
     * 生成字符串的所有子字符串，但是不要重复的子序列
     *
     * @param s
     * @return
     */
    public Set<String> getAllNoRepeatSubString(String s) {
        if (s == null || s.length() == 0) {
            return new HashSet<>();
        }
        char[] chars = s.toCharArray();
        Set<String> set = new HashSet<>();
        String sub = "";
        recur2(chars, 0, sub, set);
        return set;
    }

    private void recur2(char[] chars, int index, String sub, Set<String> set) {
        if (index == chars.length) {
            set.add(sub);
            return;
        }
        // 没有要index位置的字符
        recur2(chars, index + 1, sub, set);
        // 要了index位置的字符
        recur2(chars, index + 1, sub + chars[index], set);
    }

    public static void main(String[] args) {
        SubString subString = new SubString();
        // 生成字符串的所有子字符串
        String s1 = "abc";
        List<String> list = subString.getAllSubString(s1);
        System.out.println("生成字符串 " + s1 + " 的所有子字符串:");
        for (String str : list) {
            System.out.println(str);
        }
        // 生成字符串的所有子字符串，但是不要重复的子序列
        String s2 = "acc";
        Set<String> set = subString.getAllNoRepeatSubString(s2);
        System.out.println("生成字符串 " + s2 + " 的所有子字符串，但是不要重复的子序列:");
        for (String str : set) {
            System.out.println(str);
        }
    }
}
