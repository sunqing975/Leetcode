package org.job.hot100;

import org.job.utils.ShowTreeUtils;
import org.job.utils.TreeNode;

public class Solution108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    private TreeNode dfs(int[] nums, int lo, int hi) {
        if (lo > hi) {
            return null;
        }
        // 以升序数组的中间元素作为根节点 root。
        int mid = lo + (hi - lo) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        // 递归的构建 root 的左子树与右子树。
        root.left = dfs(nums, lo, mid - 1);
        root.right = dfs(nums, mid + 1, hi);
        return root;
    }

    public static void main(String[] args) {
        Solution108 solution108 = new Solution108();
        TreeNode treeNode = solution108.sortedArrayToBST(new int[]{-10,-3,0,5,9});
        ShowTreeUtils.show(treeNode);
    }
}
