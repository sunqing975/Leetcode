package org.job.hot100;

import java.util.HashMap;
import java.util.Map;

public class Solution136 {
    /**
     * 异或解法：异或运算满足交换律，a^b^a=a^a^b=b,
     * 因此ans相当于nums[0]^nums[1]^nums[2]^nums[3]^nums[4].....
     * 然后再根据交换律把相等的合并到一块儿进行异或（结果为0），然后再与只出现过一次的元素进行异或，
     * 这样最后的结果就是，只出现过一次的元素（0^任意值=任意值）
     *
     * @param nums
     * @return
     */
    public int singleNumber2(int[] nums) {
        int ans = nums[0];
        if (nums.length > 1) {
            for (int i = 1; i < nums.length; i++) {
                ans = ans ^ nums[i];
            }
        }
        return ans;
    }

    public int singleNumber(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, false);
            } else {
                map.put(num, true);
            }
        }
        int singleNum = 0;
        for (Map.Entry<Integer, Boolean> en : map.entrySet()) {
            if (en.getValue()) {
                singleNum = en.getKey();
            }
        }
        return singleNum;
    }

    public static void main(String[] args) {
        Solution136 soluton136 = new Solution136();
        int i = soluton136.singleNumber2(new int[]{4, 1, 2, 1, 2});
        System.out.println(i);
    }
}
