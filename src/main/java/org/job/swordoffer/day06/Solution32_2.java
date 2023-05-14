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
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 */
public class Solution32_2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            int num = queue.size();
            for (int i = 0; i < num; i++) {
                TreeNode node = queue.pollFirst();
                list.add(node.val);
                if (node.left != null) {
                    queue.addLast(node.left);
                }
                if (node.right != null) {
                    queue.addLast(node.right);
                }
            }
            res.add(list);
        }
        return res;
    }

    /**
     * 只针对完全二叉树形式
     *
     * @param root
     * @return
     */
    private static List<List<Integer>> levelOrder2(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        ArrayList<List<Integer>> arrayList = new ArrayList<>();
        Deque<TreeNode> integers = new LinkedList<>();
        TreeNode curNode = root;
        integers.addLast(curNode);
        ArrayList<Integer> list = new ArrayList<>();
        list.add(curNode.val);
        while (true) {
            curNode = integers.pollFirst();
            if (curNode == null) {
                break;
            }
            if (curNode.left == null && curNode.right == null) {
                continue;
            }
            if (curNode.left != null) {
                integers.addLast(curNode.left);
                list.add(curNode.left.val);
            } else {
                integers.addLast(null);
                list.add(null);
            }
            if (curNode.right != null) {
                integers.addLast(curNode.right);
                list.add(curNode.right.val);
            } else {
                integers.addLast(null);
                list.add(null);
            }
        }
        System.out.println(list);
        int count = 0;
        int left = 0;
        while (left < list.size()) {
            // 只针对完全二叉树形式
            int cur = (int) Math.pow(2, count);
            ArrayList<Integer> tmpList = new ArrayList<>();
            for (int i = left; i < left + cur; i++) {
                if (i >= list.size()) {
                    break;
                }
                Integer integer = list.get(i);
                if (integer != null) {
                    tmpList.add(integer);
                }
            }
            left += cur;
            arrayList.add(tmpList);
            count++;
        }
        return arrayList;
    }

    public static void main(String[] args) {
        Integer[] integers = {1, 2, 3, 4, null, null, 5};
        TreeNode root = TreeUtils.BuildTreeWithLevel(integers);
        Solution32_2 solution32_2 = new Solution32_2();
        List<List<Integer>> lists = solution32_2.levelOrder(root);
        System.out.println(lists.toString());
    }
}
