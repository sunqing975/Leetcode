package org.job.hot100;

import org.job.utils.ShowTreeeUtils;
import org.job.utils.TreeNode;
import org.job.utils.TreeUtils;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution104 {

    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth2(root.left), maxDepth2(root.right)) + 1;
    }


    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.pop();
                if (node.left == null && node.right == null) {
                    continue;
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution104 solution104 = new Solution104();
        TreeNode treeNode = TreeUtils.BuildTreeWithLevel(new Integer[]{3, 9, 20, null, null, 15, 7});
        ShowTreeeUtils.show(treeNode);
        // int i = solution104.maxDepth(treeNode);
        int i = solution104.maxDepth2(treeNode);
        System.out.println(i);
    }
}
