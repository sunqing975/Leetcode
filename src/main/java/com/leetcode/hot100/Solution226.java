package com.leetcode.hot100;

import com.leetcode.utils.ShowTreeUtils;
import com.leetcode.utils.TreeNode;
import com.leetcode.utils.TreeUtils;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Superman
 */
public class Solution226 {
    /**
     * 递归
     * @param root
     * @return
     */
    public TreeNode invertTree2(TreeNode root) {
        if (root == null){
            return null;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree2(root.left);
        invertTree2(root.right);
        return root;
    }


    /**
     * 广度优先遍历
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                if (node.left!=null || node.right != null){
                    TreeNode tmp = node.left;
                    node.left = node.right;
                    node.right = tmp;
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Solution226 solution226 = new Solution226();
        TreeNode treeNode = TreeUtils.BuildTreeWithLevel(new Integer[]{4, 2, 7, 1, 3, 6, 9});
        ShowTreeUtils.show(treeNode);
        TreeNode treeNode1 = solution226.invertTree(treeNode);
        ShowTreeUtils.show(treeNode1);
    }
}
