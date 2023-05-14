package org.job.swordoffer.day07;

import org.job.utils.TreeNode;
import org.job.utils.TreeUtils;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 * @author Superman
 */
public class Solution28 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return recur(root.left, root.right);
    }

    public boolean recur(TreeNode A, TreeNode B) {
        if (A == null && B == null) {
            return true;
        }
        if (A == null || B == null || A.val != B.val) {
            return false;
        }
        return recur(A.left, B.right) && recur(A.right, B.left);
    }

    /**
     * 先生成镜像，在比较
     *
     * @param root
     * @return
     */
    public boolean isSymmetric2(TreeNode root) {
        if (root == null) {
            return true;
        }
        TreeNode cpTree = new TreeNode(root.val);
        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(cpTree);
        Deque<TreeNode> queue2 = new LinkedList<>();
        queue2.addLast(root);
        while (!queue2.isEmpty()) {
            int num = queue2.size();
            for (int i = 0; i < num; i++) {
                TreeNode treeNode = queue.pollFirst();
                TreeNode node = queue2.pollFirst();
                if (node.left != null) {
                    treeNode.left = new TreeNode(node.left.val);
                    queue.addLast(treeNode.left);
                    queue2.addLast(node.left);
                }
                if (node.right != null) {
                    treeNode.right = new TreeNode(node.right.val);
                    queue.addLast(treeNode.right);
                    queue2.addLast(node.right);
                }
            }
        }
        queue.clear();
        queue2.clear();
        boolean flag = true;
        TreeNode mirrorTree = mirrorTree(root);
        queue.addLast(mirrorTree);
        queue2.addLast(cpTree);
        while (!queue2.isEmpty()) {
            int num = queue2.size();
            for (int i = 0; i < num; i++) {
                TreeNode treeNode = queue.pollFirst();
                TreeNode node = queue2.pollFirst();
                if (node.left != null && treeNode.left != null) {
                    if (treeNode.left.val != node.left.val) {
                        flag = false;
                        break;
                    }
                    queue.addLast(treeNode.left);
                    queue2.addLast(node.left);
                } else {
                    if (node.left == null && treeNode.left == null) {

                    } else {
                        flag = false;
                        break;
                    }
                }
                if (node.right != null && treeNode.right != null) {
                    if (treeNode.right.val != node.right.val) {
                        flag = false;
                        break;
                    }
                    queue.addLast(treeNode.right);
                    queue2.addLast(node.right);
                } else {
                    if (node.right == null && treeNode.right == null) {
                    } else {
                        flag = false;
                        break;
                    }
                }
            }
        }
        return flag;
    }

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            TreeNode tmp;
            TreeNode left = null;
            TreeNode right = null;
            if (node.left != null) {
                left = node.left;
                stack.push(node.left);
            }
            if (node.right != null) {
                right = node.right;
                stack.push(node.right);
            }
            if (left != null || right != null) {
                tmp = left;
                node.left = right;
                node.right = tmp;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        // Integer[] ints = {1, 2, 2, null, 3, null, 3};
        // Integer[] ints = {1, 2, 2, 3, 4, 4, 3};
        Integer[] ints = {9, 25, 25, null, -95, -95, null, -100, null, null, -15};
        TreeNode root = TreeUtils.BuildTreeWithLevel(ints);
        Solution28 solution28 = new Solution28();
        boolean symmetric = solution28.isSymmetric(root);
        System.out.println(symmetric);
    }
}
