package com.leetcode.hot100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            if (i == 1) {
                lists.add(Collections.singletonList(1));
                continue;
            }
            setList(lists, i);
        }
        return lists;
    }

    private void setList(List<List<Integer>> lists, int i) {
        List<Integer> list = lists.get(i - 2);
        List<Integer> nextList = new ArrayList<>(i);
        if (i == 2) {
            nextList.add(1);
            nextList.add(1);
            lists.add(nextList);
            return;
        }
        for (int i1 = 0; i1 < i; i1++) {
            if (i1 == 0 || (i1 == i - 1)) {
                nextList.add(1);
                continue;
            }
            nextList.add(list.get(i1 - 1) + list.get(i1));
        }
        lists.add(nextList);
    }

    public static void main(String[] args) {
        Solution118 solution118 = new Solution118();
        List<List<Integer>> generate = solution118.generate(5);
        generate.forEach(System.out::println);
    }

}
