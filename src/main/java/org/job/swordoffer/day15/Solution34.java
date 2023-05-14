package org.job.swordoffer.day15;

import org.job.utils.ShowTreeeUtils;
import org.job.utils.TreeNode;
import org.job.utils.TreeUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，
 * 找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * 叶子节点 是指没有子节点的节点。
 */
public class Solution34 {
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(root, target, path, ans);
        return ans;
    }

    private void dfs(TreeNode node, int target, List<Integer> path, List<List<Integer>> ans) {
        if (node == null) {
            return;
        }
        path.add(node.val);
        target -= node.val;
        if (target == 0 && node.left == null && node.right == null) {
            ans.add(new ArrayList<>(path));
        }
        if (node.left != null) {
            dfs(node.left, target, path, ans);
        }
        if (node.right != null) {
            dfs(node.right, target, path, ans);
        }
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        Solution34 solution34 = new Solution34();
        TreeNode treeNode = TreeUtils.BuildTreeWithLevel(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1});
        ShowTreeeUtils.show(treeNode);
        List<List<Integer>> lists = solution34.pathSum(treeNode, 22);
        lists.forEach(System.out::println);
    }
}
