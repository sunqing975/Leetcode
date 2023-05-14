package org.job.swordoffer.day05;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 给你一个可能存在 重复 元素值的数组 numbers ，它原来是一个升序排列的数组，并按上述情形进行了一次旋转。
 * 请返回旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一次旋转，该数组的最小值为 1。
 * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
 */
public class Solution11 {
    public int minArray(int[] numbers) {
        int n = numbers.length;
        for (int i = 1; i < n; i++) {
            if (numbers[i] < numbers[i - 1]) {
                return numbers[i];
            }
        }
        return numbers[0];
    }

    public static void main(String[] args) {
        Solution11 solution11 = new Solution11();
        // int i = solution11.minArray(new int[]{3,4,5,1,2});
        int i = solution11.minArray(new int[]{2,2,2,0,1});
        System.out.println(i);
    }
}
