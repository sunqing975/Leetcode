package org.job.hot100;

import org.job.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution094 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        recur(root, list);
        return list;
    }

    private void recur(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        recur(root.left, list);
        list.add(root.val);
        recur(root.right, list);
    }

    public static void main(String[] args) {
        Solution094 solution094 = new Solution094();

    }
}
