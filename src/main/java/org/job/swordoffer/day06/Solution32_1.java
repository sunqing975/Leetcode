package org.job.swordoffer.day06;

import org.job.utils.TreeNode;
import org.job.utils.TreeUtils;

import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 * @author Superman
 */
public class Solution32_1 {
    public int[] levelOrder(TreeNode root) {
        if (root == null){
            return new int[0];
        }
        Deque<TreeNode> integers = new LinkedList<>();
        TreeNode curNode = root;
        integers.addLast(curNode);
        ArrayList<Integer> list = new ArrayList<>();
        list.add(curNode.val);
        while (true){
            curNode = integers.pollFirst();
            if (curNode == null){
                break;
            }
            if (curNode.left != null){
                integers.addLast(curNode.left);
                list.add(curNode.left.val);
            }
            if (curNode.right != null){
                integers.addLast(curNode.right);
                list.add(curNode.right.val);
            }
        }
        int[] ints = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ints[i] = list.get(i);
        }
        return ints;
    }

    public static void main(String[] args) {
        Integer[] integers = {3, 9, 20, null, null, 15, 7};
        Solution32_1 solution32_1 = new Solution32_1();
        TreeNode root = TreeUtils.BuildTreeWithLevel(integers);
        int[] ints = solution32_1.levelOrder(root);
        System.out.println(Arrays.toString(ints));
    }
}
