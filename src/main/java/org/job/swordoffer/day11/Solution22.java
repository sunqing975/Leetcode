package org.job.swordoffer.day11;

import org.job.utils.ListNode;
import org.job.utils.ListNodeUtils;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
 *
 * @author Superman
 */
public class Solution22 {
    /**
     * 双指针方式
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode start = head;
        ListNode end = head;
        int count = 1;
        while (count < k) {
            count++;
            start = start.next;
        }
        while (start != null) {
            if (start.next != null){
                start = start.next;
                end = end.next;
            }else {
                break;
            }
        }
        return end;
    }

    /**
     * 常规方式
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd2(ListNode head, int k) {
        ListNode cur = head;
        int count = 0;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        int i = count - k;
        count = 0;
        cur = head;
        while (count < i) {
            cur = cur.next;
            count++;
        }
        return cur;
    }

    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4, 5, 6};
        ListNode root = ListNodeUtils.buildListNode(ints);
        Solution22 solution22 = new Solution22();
        ListNode kthFromEnd = solution22.getKthFromEnd(root, 2);
        ListNodeUtils.printListNode(kthFromEnd);
    }
}
