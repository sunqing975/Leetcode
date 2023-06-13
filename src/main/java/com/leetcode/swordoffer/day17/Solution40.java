package com.leetcode.swordoffer.day17;

import java.util.Arrays;

public class Solution40 {
    /**
     * 输入整数数组 arr ，找出其中最小的 k 个数。
     * 例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
     *
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k >= arr.length) {
            return arr;
        }
        // Arrays.sort(arr);
        doubleQuickSort(arr, k, 0, arr.length - 1);
        return Arrays.copyOf(arr, k);
    }

    private void doubleQuickSort(int[] arr, int k, int l, int r) {
        if (l > r) {
            return;
        }
        int base = arr[l];
        int i = l;
        int j = r;
        while (i < j) {
            while (arr[j] >= base && i < j) {
                j--;
            }
            while (arr[i] <= base && i < j) {
                i++;
            }

            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
        int tmp = arr[l];
        arr[l] = arr[j];
        arr[j] = tmp;
        if (i > k) {
            doubleQuickSort(arr, k, l, i - 1);
        }
        if (i < k) {
            doubleQuickSort(arr, k, i + 1, r);
        }
    }

    public static void main(String[] args) {
        Solution40 solution40 = new Solution40();
        int[] leastNumbers = solution40.getLeastNumbers(new int[]{2, 1, 4}, 2);
        for (int number : leastNumbers) {
            System.out.println(number);
        }
    }

}
