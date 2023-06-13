package com.leetcode.hot100;

import com.leetcode.utils.ListNode;
import com.leetcode.utils.ListNodeUtils;

public class Solution234 {
    public boolean isPalindrome(ListNode head) {
        ListNode cur = head;
        StringBuilder builder = new StringBuilder();
        while (cur != null) {
            builder.append(cur.val);
            cur = cur.next;
        }
        String oldStr = builder.toString();
        StringBuilder reverse = builder.reverse();
        String revStr = reverse.toString();
        return oldStr.equals(revStr);
    }

    public static void main(String[] args) {
        Solution234 solution234 = new Solution234();
        ListNode listNode = ListNodeUtils.buildListNode(new int[]{1, 2, 2, 1});
        boolean palindrome = solution234.isPalindrome(listNode);
        System.out.println(palindrome);
    }
}
