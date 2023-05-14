package org.job.swordoffer.day07;

import org.job.utils.TreeNode;
import org.job.utils.TreeUtils;

import java.util.ArrayList;
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
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 *
 * @author Superman
 */
public class Solution27 {

    public TreeNode mirrorTree2(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tmp = root.left;
        root.left = mirrorTree2(root.right);
        root.right = mirrorTree2(tmp);
        return root;
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
        Integer[] ints = {4, 2, 7, 1, 3, 6, 9};
        TreeNode treeNode = TreeUtils.BuildTreeWithLevel(ints);
        Solution27 solution27 = new Solution27();
        TreeNode mirrorTree = solution27.mirrorTree(treeNode);
        ArrayList<Integer> integers = new ArrayList<>();
        TreeUtils.firstPrint(mirrorTree, integers);
        System.out.println("先序遍历结果：" + integers);
    }
}
