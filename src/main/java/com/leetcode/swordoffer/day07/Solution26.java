package com.leetcode.swordoffer.day07;

import com.leetcode.utils.TreeNode;
import com.leetcode.utils.TreeUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 *
 * @author Superman
 */
public class Solution26 {
    /*
        参考:数据结构与算法的题解比较好懂
        死死记住isSubStructure()的定义:判断B是否为A的子结构
    */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        // 若A与B其中一个为空,立即返回false
        if(A == null || B == null) {
            return false;
        }
        // B为A的子结构有3种情况,满足任意一种即可:
        // 1.B的子结构起点为A的根节点,此时结果为recur(A,B)
        // 2.B的子结构起点隐藏在A的左子树中,而不是直接为A的根节点,此时结果为isSubStructure(A.left, B)
        // 3.B的子结构起点隐藏在A的右子树中,此时结果为isSubStructure(A.right, B)
        return recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    /*
    判断B是否为A的子结构,其中B子结构的起点为A的根节点
    */
    public boolean recur(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null || A.val != B.val) {
            return false;
        }
        return recur(A.left, B.left) && recur(A.right, B.right);
    }

    /**
     * 虽然是错的，但还是有一点想法的。
     *
     * @param A
     * @param B
     * @return
     */
    public boolean isSubStructure2(TreeNode A, TreeNode B) {
        if (B == null) {
            return false;
        }
        ArrayList<Integer> l1 = new ArrayList<>();
        ArrayList<Integer> l2 = new ArrayList<>();
        firstPrint(A, l1);
        firstPrint(B, l2);
        boolean flag = true;
        int p1 = 0;
        int p2 = 0;
        while (p1 < l1.size() && p2 < l2.size()) {
            if (l1.get(p1).equals(l2.get(p2))) {
                p2++;
            } else {
                p2 = 0;
            }
            p1++;
        }
        if (p2 != l2.size()) {
            flag = false;
        }
        return flag;
    }

    public void firstPrint(TreeNode node, List<Integer> list) {
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
        Integer[] ints1 = {10, 12, 6, 8, 3, 11};
        Integer[] ints2 = {10, 12, 6, 8};
        TreeNode A = TreeUtils.BuildTreeWithLevel(ints1);
        TreeNode B = TreeUtils.BuildTreeWithLevel(ints2);
        Solution26 solution26 = new Solution26();
        boolean subStructure = solution26.isSubStructure(A, B);
        ArrayList<Integer> l1 = new ArrayList<>();
        ArrayList<Integer> l2 = new ArrayList<>();
        solution26.firstPrint(A, l1);
        solution26.firstPrint(B, l2);
        System.out.println(l1);
        System.out.println(l2);
        System.out.println(subStructure);
    }
}
