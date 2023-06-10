package org.job.swordoffer.day18;

import org.job.utils.ShowTreeUtils;
import org.job.utils.TreeNode;
import org.job.utils.TreeUtils;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution55_2 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        // int left = treeDepth(root.left);
        // int right = treeDepth(root.right);
        // int left = depth(root.left);
        // int right = depth(root.right);
        // return Math.abs(right - left) <= 1 && isBalanced(root.left) && isBalanced(root.right);
        return Math.abs(depth(root.left) - depth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }
    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }
    public int treeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        res++;

        while (!deque.isEmpty()) {
            boolean flag = false;
            TreeNode poll = deque.poll();
            if (poll.left != null) {
                deque.add(poll.left);
                flag = true;
            }
            if (poll.right != null) {
                deque.add(poll.right);
                flag = true;
            }
            if (flag) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution55_2 solution55_2 = new Solution55_2();
        TreeNode treeNode = TreeUtils.BuildTreeWithLevel(new Integer[]{1,2,2,3,3,3,3,4,4,4,4,4,4,null,null,5,5});
        ShowTreeUtils.show(treeNode);
        System.out.println(solution55_2.isBalanced(treeNode));
    }
}
