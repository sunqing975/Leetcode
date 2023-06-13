package com.leetcode.swordoffer.day05;

import java.util.Scanner;

/**
 * 在一个 n * m 的二维数组中，每一行都按照从左到右 非递减 的顺序排序，
 * 每一列都按照从上到下 非递减 的顺序排序。请完成一个高效的函数，
 * 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class Solution04 {


    public boolean findNumberIn2DArray2(int[][] matrix, int target) {
        if (matrix == null) {
            return false;
        }
        int i = matrix.length - 1;
        int j = 0;
        while (i >= 0 && j < matrix[0].length) {
            if (matrix[i][j] < target) {
                j++;
            } else if (matrix[i][j] > target) {
                i--;
            } else {
                return true;
            }
        }
        return false;
    }


    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null) {
            return false;
        }
        for (int[] ints : matrix) {
            if (findNumberInArray(ints, target)) {
                return true;
            }
        }
        return false;
    }

    public boolean findNumberInArray(int[] arr, int target) {
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] ints = new int[5][5];
        int count = 0;
        while (true) {
            String s = scanner.nextLine();
            if ("0".equals(s)) {
                break;
            }
            String regex = ",";
            String[] split = s.split(regex);
            int[] ints1 = new int[split.length];
            for (int i = 0; i < split.length; i++) {
                ints1[i] = Integer.parseInt(split[i]);
            }
            ints[count++] = ints1;
        }
        Solution04 solution04 = new Solution04();
        boolean numberIn2DArray = solution04.findNumberIn2DArray2(ints, 5);
        System.out.println(numberIn2DArray);
    }
}
