package org.job.swordoffer.day03;

/**
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 * 请定义一个函数实现字符串左旋转操作的功能。
 * 比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 */
public class Solution35 {
    public String reverseLeftWords(String s, int n) {
        if (n > s.length()) {
            return s;
        }
        StringBuilder builder = new StringBuilder();
        StringBuilder builder2 = new StringBuilder();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i < n) {
                builder2.append(chars[i]);
            } else {
                builder.append(chars[i]);
            }
        }
        builder.append(builder2);
        return builder.toString();
    }

    public String reverseLeftWords2(String s, int n) {
        if (n > s.length()) {
            return s;
        }
        return s.substring(n) + s.substring(0, n);
    }

    public static void main(String[] args) {
        Solution35 solution35 = new Solution35();
        String s = solution35.reverseLeftWords("abcdefg", 2);
        String s1 = solution35.reverseLeftWords2("lrloseumgh", 6);
        System.out.println(s1);
    }
}
