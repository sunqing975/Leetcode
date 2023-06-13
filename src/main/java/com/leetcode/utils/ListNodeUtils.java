package com.leetcode.utils;

/**
 * @author Superman
 */
public class ListNodeUtils {
    public static ListNode buildListNode(int[] ints) {
        ListNode root = new ListNode();
        ListNode cur = root;
        for (int i = 0; i < ints.length; i++) {
            cur.val = ints[i];
            if (i <= ints.length -2){
                ListNode node = new ListNode();
                cur.next = node;
                cur = cur.next;
            }
        }
        return root;
    }

    public static void printListNode(ListNode node) {
        StringBuilder builder = new StringBuilder();
        while (node != null) {
            builder.append(node.val).append("->");
            node = node.next;
        }
        if (builder.length() == 0){
            return;
        }
        StringBuilder str = builder.delete(builder.lastIndexOf("-"), builder.lastIndexOf(">") + 1);
        System.out.println(str);
    }
}
