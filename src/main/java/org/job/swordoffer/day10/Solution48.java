package org.job.swordoffer.day10;

import java.util.HashMap;

/**
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 */
public class Solution48 {
    /**
     * 动态规划
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if ("".equals(s)) {
            return 0;
        }
        int[] dp = new int[s.length() + 1];
        dp[0] = 0;
        dp[1] = 1;
        int j = 0;
        int longest = 1;
        for (int i = 2; i <= s.length(); i++) {
            String substring = s.substring(j, i);
            String s1 = substring.substring(substring.length() - 1);
            int m = substring.indexOf(s1);
            int n = substring.lastIndexOf(s1);
            if (m == n) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = n - m;
                j = j + m + 1;
            }
            longest = Math.max(dp[i], longest);
        }
        return longest;
    }

    /**
     * 双指针
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        if (s.length() == 0) {
            return 0;
        }
        HashMap<String, Integer> map = new HashMap<>();
        int[] dp = new int[s.length() + 1];
        dp[0] = 0;
        dp[1] = 1;
        int j = 0;
        int longest = 1;
        for (int i = 2; i <= s.length(); i++) {
            String substring = s.substring(j, i);
            String s1 = substring.substring(substring.length() - 1);
            int m = substring.indexOf(s1);
            int n = substring.lastIndexOf(s1);
            if (m == n) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = n - m;
                j = j + m + 1;
            }
            longest = Math.max(dp[i], longest);
        }
        return longest;
    }

    public static void main(String[] args) {
        Solution48 solution48 = new Solution48();
        int abcabcbb = solution48.lengthOfLongestSubstring("abcabcbb");
        System.out.println(abcabcbb);
        int bbbbb = solution48.lengthOfLongestSubstring("bbbbb");
        System.out.println(bbbbb);
        int pwwkew = solution48.lengthOfLongestSubstring("pwwkew");
        System.out.println(pwwkew);
        int dvdf = solution48.lengthOfLongestSubstring("dvdf");
        System.out.println(dvdf);
    }
}
