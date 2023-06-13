package com.leetcode.swordoffer.day11;

import com.leetcode.utils.ListNode;
import com.leetcode.utils.ListNodeUtils;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * 返回删除后的链表的头节点。
 * @author Superman
 */
public class Solution18 {
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null){
            return head;
        }
        if (head.val == val){
            return head.next;
        }
        ListNode pre = head;
        ListNode next = pre;
        while (next != null){
            if (next.val == val){
                pre.next = next.next;
                break;
            }
            pre = next;
            next = next.next;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] ints = {4, 5, 1, 9};
        ListNode root = ListNodeUtils.buildListNode(ints);
        Solution18 solution18 = new Solution18();
        ListNode cur = solution18.deleteNode(root, 5);
        ListNodeUtils.printListNode(cur);
    }
}
