package org.job.hot100;

import java.util.*;

/**
 * @author Superman
 */
public class Solution448 {
    public List<Integer> findDisappearedNumbers3(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int n = nums.length;
        // 根据索引值来判断，
        //  将值所在的索引位置的值加上n
        // 最后根据索引遍历，可以得到未大于n的索引
        for (int i = 0; i < n; i++) {
            int x = (nums[i] - 1) % n;
            nums[x] += n;
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n){
                list.add(i + 1);
            }
        }
        return list;
    }

    /**
     * 拉跨
     *
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers2(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int n = nums.length;
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        for (int num : nums) {
            if (list.contains(num)) {
                list.set(num - 1, 0);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (Integer integer : list) {
            if (!integer.equals(0)) {
                ans.add(integer);
            }
        }
        return ans;
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int n = nums.length;
        HashMap<Integer, Boolean> hashMap = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            hashMap.put(i, false);
        }
        for (int num : nums) {
            if (hashMap.containsKey(num)) {
                hashMap.put(num, true);
            }
        }
        for (Map.Entry<Integer, Boolean> entry : hashMap.entrySet()) {
            if (entry.getValue().equals(false)) {
                list.add(entry.getKey());
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Solution448 solution448 = new Solution448();
        List<Integer> disappearedNumbers = solution448.findDisappearedNumbers3(new int[]{4, 3, 2, 7, 8, 2, 3, 1});
        System.out.println(disappearedNumbers);
    }
}
