package org.job.hot100;

import org.job.utils.ListNode;

public class Solution021 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        ListNode resNode = new ListNode();
        ListNode cur = resNode;
        ListNode cur1 = list1;
        ListNode cur2 = list2;

        while (cur1 != null && cur2 != null) {
            if (cur1.val < cur2.val) {
                cur.next = cur1;

                cur = cur1;
                cur1 = cur1.next;
            } else {
                cur.next = cur2;

                cur = cur2;
                cur2 = cur2.next;
            }
        }
        if (cur1 != null) {
            cur.next = cur1;
        }
        if (cur2 != null) {
            cur.next = cur2;
        }
        return resNode.next;
    }

    public static void main(String[] args) {
        Solution021 solution021 = new Solution021();
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(3);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);
        list2.next.next.next = new ListNode(5);

        ListNode listNode = solution021.mergeTwoLists(list1, list2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
