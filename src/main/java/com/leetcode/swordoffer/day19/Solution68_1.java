package com.leetcode.swordoffer.day19;

import com.leetcode.utils.ShowTreeUtils;
import com.leetcode.utils.TreeNode;
import com.leetcode.utils.TreeUtils;

public class Solution68_1 {
    /**
     * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
     * <p>
     * 百度百科中最近公共祖先的定义为：
     * “对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
     * <p>
     * 这题的思路主要在于二叉搜索树的特性，根节点  左边的小，右边的大
     * 通过根的值进行判断
     *
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (root.val > p.val && root.val > q.val) {
                root = root.left;
            } else if (root.val < p.val && root.val < q.val) {
                root = root.right;
            } else {
                break;
            }
        }
        return root;
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {

        // while (root != null) {
        if (root.val > p.val && root.val > q.val) {
            // root = root.left;
            return lowestCommonAncestor2(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val) {
            // root = root.right;
            return lowestCommonAncestor2(root.right, p, q);
        } else {
            // break;
            return root;
        }
        // }
        // return root;
    }

    public static void main(String[] args) {
        Solution68_1 solution68_1 = new Solution68_1();
        TreeNode treeNode = TreeUtils.BuildTreeWithLevel(new Integer[]{6, 2, 8, 0, 4, 7, 9, null, null, 3, 5});
        ShowTreeUtils.show(treeNode);
        TreeNode treeNode1 = solution68_1.lowestCommonAncestor2(treeNode, new TreeNode(3), new TreeNode(5));
        System.out.println(treeNode1.val);
    }
}
