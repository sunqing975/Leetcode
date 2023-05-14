package org.job.swordoffer.day06;

import org.job.utils.TreeNode;
import org.job.utils.TreeUtils;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 * 请实现一个函数按照之字形顺序打印二叉树，
 * 即第一行按照从左到右的顺序打印，
 * 第二层按照从右到左的顺序打印，
 * 第三行再按照从左到右的顺序打印，其他行以此类推。
 */
public class Solution32_3 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> res = new ArrayList<>();
        // 判断奇偶
        boolean flag = true;
        while (!queue.isEmpty()) {
            LinkedList<Integer> list = new LinkedList<>();
            int num = queue.size();
            for (int i = 0; i < num; i++) {
                TreeNode node = queue.pollFirst();
                // 偶数层对头，奇数层队尾
                if (flag) {
                    list.addLast(node.val);
                } else {
                    list.addFirst(node.val);
                }
                if (node.left != null) {
                    queue.addLast(node.left);
                }
                if (node.right != null) {
                    queue.addLast(node.right);
                }
            }
            flag = !flag;
            res.add(list);
        }
        return res;
    }

    public static void main(String[] args) {
        Integer[] integers = {1, 2, 3, 4, null, null, 5};
        TreeNode root = TreeUtils.BuildTreeWithLevel(integers);
        Solution32_3 solution32_3 = new Solution32_3();
        List<List<Integer>> lists = solution32_3.levelOrder(root);
        System.out.println(lists.toString());
    }
}
