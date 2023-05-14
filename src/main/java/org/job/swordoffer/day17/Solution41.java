package org.job.swordoffer.day17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution41 {
    List<Integer> nums;

    /**
     * initialize your data structure here.
     */
    public Solution41() {
        nums = new ArrayList<>();
    }

    public void addNum(int num) {
        nums.add(num);
    }

    public double findMedian() {
        Collections.sort(nums);
        int len = nums.size();
        if (len % 2 == 0) {
            int n = len >> 1;
            return (nums.get(n) + nums.get(n-1)) / 2.0;
        } else {
            return nums.get(nums.size() >> 1);
        }

    }
    /**
     * Your MedianFinder object will be instantiated and called as such:
     * MedianFinder obj = new MedianFinder();
     * obj.addNum(num);
     * double param_2 = obj.findMedian();
     */
}
