package org.job.utils;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Superman
 */
public class TreeUtils {
    public static TreeNode BuildTreeWithLevel(Integer[] vals) {
        if (vals == null || vals.length == 0) {
            return null;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        int left = 0;
        int right;
        TreeNode root = new TreeNode(vals[0]);
        queue.addLast(root);
        boolean flag = true;
        for (int i = 1; i < vals.length; i++) {
            int num = queue.size();
            for (int i1 = 0; i1 < num; i1++) {
                TreeNode node = queue.pollFirst();
                if (flag) {
                    left++;
                    flag = false;
                } else {
                    left += 2;
                }
                right = left + 1;
                if (left >= vals.length) {
                    break;
                }
                if (right >= vals.length) {
                    if (vals[left] != null) {
                        TreeNode node1 = new TreeNode(vals[left]);
                        node.left = node1;
                        queue.addLast(node1);
                    }
                } else {
                    if (vals[left] != null) {
                        TreeNode node1 = new TreeNode(vals[left]);
                        node.left = node1;
                        queue.addLast(node1);
                    }
                    if (vals[right] != null) {
                        TreeNode node2 = new TreeNode(vals[right]);
                        node.right = node2;
                        queue.addLast(node2);
                    }
                }
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        firstPrint(root, list);
        System.out.println("先序遍历结果：" + list);
        return root;
    }

    // 先序遍历
    public static void firstPrint(TreeNode node, List<Integer> list) {
        if (node != null) {
            list.add(node.val);
            if (node.left != null) {
                firstPrint(node.left, list);
            }
            if (node.right != null) {
                firstPrint(node.right, list);
            }
        }
    }

    public static void main(String[] args) {
        // Integer[] integers = {3, 9, 20, null, null, 15, 7};
        Integer[] integers = {3, 1};
        // Integer[] integers = {10, 12, 6, 8};
        TreeNode node = BuildTreeWithLevel(integers);
        ArrayList<Integer> list = new ArrayList<>();
        firstPrint(node, list);
        System.out.println(list);
    }
}
