package org.job.swordoffer.day22;

public class Solution56_1 {
    /**
     * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。
     * 请写程序找出这两个只出现一次的数字。
     * 要求时间复杂度是O(n)，空间复杂度是O(1)。
     * <p>
     * 思路：这道题，如果看时间复杂度O（n），空间复杂度O（1），其实很好想到异或
     * (以前有道题跟这个差不多，只不过有一个不同元素，那个题全员异或就出来了，这个不行)
     * 前置知识：  1^0 = 1     1^1 = 0   0^0 = 0
     * 为啥叫异或，就是如果不同我就返回1，相同我就返回0
     * 所以如果有两个数相同  010111 ^ 010111 = 0 异或就为0
     * 例子： 1 4 6 4 如果全员异或，相同的4肯定没了，留下1 和 6异或的结果，但是光异或我没法返回啊
     * 哪我就想到了一个很赞的做法
     * 1 和 6 肯定是不同的吧，异或结果有一位肯定是 1，比如说第2位异或为1
     * => 也就是说 1 和 6 ，第二位一个为1一个为0
     * 那么我就分组，将第二位为1的分一组，全员异或
     * 将第二位为0的分一组，全员异或
     * 这就是最终结果了
     * 你可能还有疑问，哪相同的元素怎么办，不会干扰结果吗？
     * 当然不会，比如4 和 4，第二位都为0，肯定都被分到一组，最后异或为0，不影响结果
     * 总结：时间复杂度O(n) 更细就是O(2n)   时间复杂度O(1)
     * </p>
     *
     * @param nums
     * @return
     */
    public int[] singleNumbers(int[] nums) {
        int x = 0, y = 0, n = 0, m = 1;
        // 1. 遍历异或
        for (int num : nums) {
            n ^= num;
        }
        // 2. 循环左移，计算 m
        while ((n & m) == 0) {
            m <<= 1;
        }
        // 3. 遍历 nums 分组
        for (int num : nums) {
            if ((num & m) != 0) {
                // 4. 当 num & m != 0
                x ^= num;
            } else {
                // 4. 当 num & m == 0
                y ^= num;
            }
        }
        // 5. 返回出现一次的数字
        return new int[]{x, y};
    }

    public static void main(String[] args) {
        Solution56_1 solution56_1 = new Solution56_1();
        int[] ints = solution56_1.singleNumbers(new int[]{4, 1, 4, 6});
        System.out.println(ints);
    }
}
