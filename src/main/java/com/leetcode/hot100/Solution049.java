package com.leetcode.hot100;

import java.util.*;

public class Solution049 {

    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String s = new String(charArray);
            if (map.containsKey(s)) {
                List<String> list = map.get(s);
                list.add(str);
                map.put(s, list);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(s, list);
            }
        }
        List<List<String>> lists = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            lists.add(entry.getValue());
        }
        return lists;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> lists = new ArrayList<>();
        List<String> cpList = new ArrayList<>(Arrays.asList(strs));
        for (int i = 0; i < cpList.size(); i++) {
            StringBuilder builder = new StringBuilder();
            char[] charArray = cpList.get(i).toCharArray();
            List<Character> sortList = new ArrayList<>();
            for (char c : charArray) {
                sortList.add(c);
            }
            List<Character> list = sortList.stream().sorted(Character::compareTo).toList();
            for (Character character : list) {
                builder.append(character);
            }
            cpList.set(i, builder.toString());
        }
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < cpList.size(); i++) {
            List<Integer> list = map.get(cpList.get(i));
            if (Objects.isNull(list)) {
                List<Integer> integers = new ArrayList<>();
                integers.add(i);
                map.put(cpList.get(i), integers);
            } else {
                list.add(i);
            }
        }
        for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
            List<String> list = new ArrayList<>();
            List<Integer> value = entry.getValue();
            for (Integer integer : value) {
                list.add(strs[integer]);
            }
            lists.add(list);
        }
        return lists;
    }

    public static void main(String[] args) {
        Solution049 solution049 = new Solution049();
        //List<List<String>> lists = solution049.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        List<List<String>> lists = solution049.groupAnagrams2(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        lists.forEach(System.out::println);
    }
}
