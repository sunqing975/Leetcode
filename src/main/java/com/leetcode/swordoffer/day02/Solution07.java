package com.leetcode.swordoffer.day02;

import com.leetcode.utils.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 */
public class Solution07 {
    // 双指针方式
    public ListNode reverseListDoublePoint(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        Deque<ListNode> nodes = new ArrayDeque<>();
        ListNode cur = head;
        while (cur != null) {
            nodes.push(cur);
            cur = cur.next;
        }
        ListNode resultNode = nodes.pop();
        ListNode prep = resultNode;
        ListNode next;
        while (!nodes.isEmpty()) {
            next = nodes.pop();
            prep.next = next;
            prep = next;
            next.next = null;
        }
        return resultNode;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(5);
        node.next.next = new ListNode(2);
        Solution07 solution07 = new Solution07();
        ListNode listNode = solution07.reverseList(node);
        ListNode cur = listNode;
        while (cur != null) {
            System.out.print(cur.val + "->");
            cur = cur.next;
        }
    }
}
