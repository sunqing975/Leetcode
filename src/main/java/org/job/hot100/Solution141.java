package org.job.hot100;

import org.job.utils.ListNode;
import org.job.utils.ListNodeUtils;

import java.util.HashSet;

public class Solution141 {
    /**
     * 快慢指针
     *
     * @param head
     * @return
     */
    public boolean hasCycle2(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null) {
            fast = fast.next;
            // if (fast.next != null) {
            fast = fast.next;
            // }
            if (fast == slow) {
                return true;
            }
            slow = slow.next;
        }
        return false;
    }

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode cur = head;
        HashSet<ListNode> set = new HashSet<>();
        while (cur != null) {
            if (set.contains(cur)) {
                return true;
            } else {
                set.add(cur);
            }
            cur = cur.next;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution141 solution141 = new Solution141();
        ListNode listNode = ListNodeUtils.buildListNode(new int[]{3, 2, 0, -4});

    }
}
