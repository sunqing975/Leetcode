package org.job.swordoffer.day12;

import org.job.utils.ListNode;
import org.job.utils.ListNodeUtils;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 */
public class Solution25 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        ListNode listNode = new ListNode(0);
        ListNode cur = listNode;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val){
                cur.next = l2;
                l2 = l2.next;
            }else {
                cur.next = l1;
                l1 = l1.next;
            }
            cur = cur.next;
        }
        if (l1 != null){
            cur.next = l1;
        }
        if (l2 != null){
            cur.next = l2;
        }
        return listNode.next;
    }

    public static void main(String[] args) {
        Solution25 solution25 = new Solution25();
        int[] i1 = {5};
        int[] i2 = {1, 2, 4};
        ListNode l1 = ListNodeUtils.buildListNode(i1);
        ListNode l2 = ListNodeUtils.buildListNode(i2);
        ListNode mergeTwoLists = solution25.mergeTwoLists(l1, l2);
        ListNodeUtils.printListNode(mergeTwoLists);
    }
}
