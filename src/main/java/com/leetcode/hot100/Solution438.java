package com.leetcode.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution438 {
    public List<Integer> findAnagrams2(String s, String p) {
        int sLen = s.length(), pLen = p.length();

        if (sLen < pLen) {
            return new ArrayList<>();
        }

        List<Integer> ans = new ArrayList<>();
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        for (int i = 0; i < pLen; ++i) {
            ++sCount[s.charAt(i) - 'a'];
            ++pCount[p.charAt(i) - 'a'];
        }

        if (Arrays.equals(sCount, pCount)) {
            ans.add(0);
        }

        for (int i = 0; i < sLen - pLen; ++i) {
            --sCount[s.charAt(i) - 'a'];
            ++sCount[s.charAt(i + pLen) - 'a'];

            if (Arrays.equals(sCount, pCount)) {
                ans.add(i + 1);
            }
        }

        return ans;
    }


    public List<Integer> findAnagrams(String s, String p) {
        if (p == null || "".equals(p)) {
            return Collections.emptyList();
        }
        char[] arrS = s.toCharArray();
        char[] arrP = p.toCharArray();
        Arrays.sort(arrP);
        int m = arrS.length;
        int n = arrP.length;
        int start = 0;
        int end = 0;
        end += n;
        List<Integer> list = new ArrayList<>();
        while (start < m - n + 1) {
            if (isAnagram(arrS, start, end, arrP)) {
                list.add(start);
            }
            start++;
            end = start + n;
        }
        return list;
    }

    private boolean isAnagram(char[] arrS, int start, int end, char[] arrP) {
        char[] chars = Arrays.copyOfRange(arrS, start, end);
        Arrays.sort(chars);
        return Arrays.equals(arrP, chars);
    }


    public static void main(String[] args) {
        Solution438 solution438 = new Solution438();
        System.out.println(solution438.findAnagrams("cbaebabacd", "abc"));
        System.out.println(solution438.findAnagrams("abab", "ab"));
        System.out.println(solution438.findAnagrams2("cbaebabacd", "abc"));
        System.out.println(solution438.findAnagrams2("abab", "ab"));
    }
}
