package com.leetcode.swordoffer.day02;

import com.leetcode.utils.ListNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 */
public class Solution06 {
    // 常规方式
    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        ListNode cur = head;

        ArrayList<Integer> list = new ArrayList<>();
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        int count = list.size();
        int[] ints = new int[count];
        for (int i = count - 1; i >= 0; i--) {
            ints[count - i - 1] = list.get(i);
        }
        return ints;
    }

    /**
     * 栈的方式更优雅
     *
     * @param head
     * @return
     */
    public int[] reversePrintStack(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        ListNode cur = head;
        Deque<Integer> deque = new ArrayDeque<>();
        while (cur != null) {
            deque.push(cur.val);
            cur = cur.next;
        }
        int count = deque.size();
        int[] ints = new int[count];
        for (int i = count - 1; i >= 0; i--) {
            ints[count - i - 1] = deque.pop();
        }
        return ints;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(5);
        node.next.next = new ListNode(2);
        Solution06 solution06 = new Solution06();
        ListNode listNode = null;
        // int[] ints = solution06.reversePrint(node);
        // int[] ints = solution06.reversePrint(listNode);
        int[] ints = solution06.reversePrintStack(node);
        System.out.println(Arrays.toString(ints));
    }
}
