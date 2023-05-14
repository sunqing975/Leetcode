package org.job.hot100;

import org.job.utils.ListNode;
import org.job.utils.ListNodeUtils;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution206 {
    /**
     * 妖魔化双指针
     *
     * @param head
     * @return
     */
    public ListNode reverseList4(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        while (head.next != null){
            ListNode node = head.next.next;
            head.next.next = cur;
            cur = head.next;
            head.next = node;
        }
        return cur;
    }

    /**
     * 递归
     *
     * @param head
     * @return
     */
    public ListNode reverseList3(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = reverseList3(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }

    /**
     * 简单双指针
     *
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        ListNode cur = null;
        ListNode pre = head;
        while (pre != null) {
            ListNode tmp = pre.next;
            pre.next = cur;
            cur = pre;
            pre = tmp;
        }
        return cur;
    }

    public ListNode reverseList(ListNode head) {
        Deque<ListNode> stack = new ArrayDeque<>();
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        ListNode node = new ListNode();
        cur = node;
        while (!stack.isEmpty()) {
            ListNode pop = stack.pop();
            cur.next = pop;
            cur = pop;
            cur.next = null;
        }
        return node.next;
    }

    public static void main(String[] args) {
        Solution206 solution206 = new Solution206();
        ListNode listNode = ListNodeUtils.buildListNode(new int[]{1, 2, 3, 4, 5});
        ListNode listNode1 = solution206.reverseList4(listNode);
        ListNodeUtils.printListNode(listNode1);
    }
}
