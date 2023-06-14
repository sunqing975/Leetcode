package com.leetcode.hot100;

import java.util.*;

public class Solution003 {

    public int lengthOfLongestSubstringMap(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }
        int maxLen = 0;
        int len = s.length();
        int start = 0;
        int end = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (end < len) {
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                start = Math.max(start, map.get(c) + 1);
            }
            maxLen = Math.max(end - start + 1, maxLen);
            map.put(c, end);
            end++;
        }
        return maxLen;
    }


    public int lengthOfLongestSubstringQueue(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }
        int maxLen = 0;
        int len = s.length();
        int i = 0;
        Queue<Character> queue = new ArrayDeque<>();
        while (i < len) {
            while (queue.contains(s.charAt(i))) {
                queue.poll();
            }
            queue.offer(s.charAt(i));
            i++;
            int setSize = queue.size();
            if (setSize > maxLen) {
                maxLen = setSize;
            }
        }
        return maxLen;
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }
        int maxLen = 0;
        int len = s.length();
        int l = 0;
        int r = 0;
        Set<String> set = new HashSet<>();
        while (l < len && r < len) {
            if (set.contains(String.valueOf(s.charAt(r)))) {
                set.clear();
                String s1 = s.substring(l, r + 1);
                int i = s1.indexOf(s.charAt(r));
                String s2 = s1.substring(i + 1);
                l = l + i + 1;
                set.addAll(List.of(s2.split("")));
            } else {
                set.add(String.valueOf(s.charAt(r)));
            }
            r++;
            int setSize = set.size();
            if (setSize > maxLen) {
                maxLen = setSize;
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Solution003 solution003 = new Solution003();
        System.out.println(solution003.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(solution003.lengthOfLongestSubstring("pwwkew"));
        System.out.println(solution003.lengthOfLongestSubstring("jbpnbwwd"));
        System.out.println(solution003.lengthOfLongestSubstringQueue("abcabcbb"));
        System.out.println(solution003.lengthOfLongestSubstringQueue("pwwkew"));
        System.out.println(solution003.lengthOfLongestSubstringQueue("jbpnbwwd"));
        System.out.println(solution003.lengthOfLongestSubstringMap("abcabcbb"));
        System.out.println(solution003.lengthOfLongestSubstringMap("pwwkew"));
        System.out.println(solution003.lengthOfLongestSubstringMap("jbpnbwwd"));
        System.out.println(solution003.lengthOfLongestSubstringMap("abba"));
    }
}

