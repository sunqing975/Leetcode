package org.job.hot100;

import org.job.utils.TreeNode;
import org.job.utils.TreeUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Superman
 */
public class Solution101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return dfs(root.left, root.right);
    }

    public boolean dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return dfs(left.left, right.right) && dfs(left.right, right.left);
    }


    public static void main(String[] args) {
        Solution101 solution101 = new Solution101();
        TreeNode treeNode = TreeUtils.BuildTreeWithLevel(new Integer[]{1, 2, 2, 3, 4, 4, 3});
        boolean symmetric = solution101.isSymmetric(treeNode);
        System.out.println(symmetric);
    }
}
