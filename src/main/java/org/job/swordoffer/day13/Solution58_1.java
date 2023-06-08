package org.job.swordoffer.day13;

/**
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
 * 为简单起见，标点符号和普通字母一样处理。
 * 例如输入字符串"I am a student. "，则输出"student. a am I"。
 *
 * @author Superman
 */
public class Solution58_1 {
    /**
     * 双指针法
     *
     * @param s
     * @return
     */
    public String reverseWords2(String s) {
        if ("".equals(s)) {
            return "";
        }
        // 从右往左，i和j作为单词的边界
        s = s.trim();
        int j = s.length() - 1, i = j;
        StringBuilder builder = new StringBuilder();
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }
            builder.append(s, i + 1, j + 1).append(" ");
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            j = i;
        }
        return builder.toString().trim();
    }

    public String reverseWords(String s) {
        if ("".equals(s)) {
            return "";
        }
        // 删除首尾空格，分割字符串
        String[] strs = s.trim().split(" ");
        StringBuilder res = new StringBuilder();
        // 倒序遍历单词列表
        for (int i = strs.length - 1; i >= 0; i--) {
            if (strs[i].equals("")) {
                // 遇到空单词则跳过
                continue;
            }
            // 将单词拼接至 StringBuilder
            res.append(strs[i] + " ");
        }
        // 转化为字符串，删除尾部空格，并返回
        return res.toString().trim();
    }


    public static void main(String[] args) {
        Solution58_1 solution58_1 = new Solution58_1();
        String s = "I am a student. ";
        String s1 = "  hello world!  ";
        String s2 = "  a good   example  ";
        String s3 = "    ";
        String s4 = "   a   b ";
        // String reverseWords = solution58_1.reverseWords(s2);
        String reverseWords2 = solution58_1.reverseWords2(s2);
        System.out.println(reverseWords2);
    }
}
