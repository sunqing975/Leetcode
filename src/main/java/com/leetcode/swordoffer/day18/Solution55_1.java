package com.leetcode.swordoffer.day18;

import com.leetcode.utils.ShowTreeUtils;
import com.leetcode.utils.TreeNode;
import com.leetcode.utils.TreeUtils;

public class Solution55_1 {
    /**
     * 输入一棵二叉树的根节点，求该树的深度。
     * 从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，
     * 最长路径的长度为树的深度。
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }

    public static void main(String[] args) {
        Solution55_1 solution55_1 = new Solution55_1();
        TreeNode treeNode = TreeUtils.BuildTreeWithLevel(new Integer[]{1,2,3,4,null,null,5});
        ShowTreeUtils.show(treeNode);
        int i = solution55_1.maxDepth(treeNode);
        System.out.println(i);
    }
}
