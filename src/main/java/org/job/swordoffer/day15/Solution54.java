package org.job.swordoffer.day15;

import org.job.utils.ShowTreeeUtils;
import org.job.utils.TreeNode;
import org.job.utils.TreeUtils;

public class Solution54 {
    Integer res = 0, k;
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.right);
        if (0 == k) {
            return;
        }
        if (--k == 0) {
            res = root.val;
        }
        dfs(root.left);
    }

    public static void main(String[] args) {
        Solution54 solution54 = new Solution54();
        TreeNode treeNode = TreeUtils.BuildTreeWithLevel(new Integer[]{3, 1, 4, null, 2});
        ShowTreeeUtils.show(treeNode);
        int kthLargest = solution54.kthLargest(treeNode, 1);
        System.out.println(kthLargest);
    }
}
