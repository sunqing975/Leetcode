package org.job.hot100;

import org.job.utils.TreeNode;
import org.job.utils.TreeUtils;

import java.util.Map;

/**
 * @className: org.job.hot100.Solution543
 * @author: Superman
 * @create: 2023-06-08 21:44
 * @description: TODO
 */
public class Solution543 {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root.left == null && root.right == null) {
            return max;
        }
        recur(root);
        return max;
    }

    private int recur(TreeNode node) {
        if (node.left == null && node.right == null) {
            return 0;
        }
        int left = node.left == null ? 0 : recur(node.left) + 1;
        int right = node.right == null ? 0 : recur(node.right) + 1;
        max = Math.max(max, left + right);
        return Math.max(left, right);
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeUtils.BuildTreeWithLevel(new Integer[]{1, 2, 3, 4, 5});
        Solution543 solution543 = new Solution543();
        int i = solution543.diameterOfBinaryTree(treeNode);
        System.out.println(i);
    }
}
