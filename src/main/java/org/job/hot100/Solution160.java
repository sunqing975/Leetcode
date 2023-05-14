package org.job.hot100;

import org.job.utils.ListNode;

public class Solution160 {
    /**
     * 快慢指针
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode curA = headA;
        ListNode curB = headB;

        ListNode ans = null;
        while (curA != null || curB != null) {
            if (curA == null) {
                curA = headB;
            }
            if (curB == null) {
                curB = headA;
            }
            if (curA == curB) {
                ans = curA;
                break;
            }
            curA = curA.next;
            curB = curB.next;
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
