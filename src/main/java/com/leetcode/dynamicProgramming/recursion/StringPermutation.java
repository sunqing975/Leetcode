package com.leetcode.dynamicProgramming.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * 生成字符的全部排列
 * @author Superman
 */
public class StringPermutation {
    /**
     * 生成字符的全部排列
     * @param s
     * @return
     */
    public List<String> getStringAllPermutation(String s){
        if (s == null || s.isEmpty()) {
            return new ArrayList<>();
        }
        char[] chars = s.toCharArray();
        ArrayList<Character> characters = new ArrayList<>();
        for (char aChar : chars) {
            characters.add(aChar);
        }
        ArrayList<String> ans = new ArrayList<>();
        String str = "";
        recur1(characters, str, ans);
        return ans;
    }

    private void recur1(ArrayList<Character> characters, String str, ArrayList<String> ans) {
        if (characters.isEmpty()){
            ans.add(str);
            return;
        }
        int size = characters.size();
        for (int i = 0; i < size; i++) {
            Character character = characters.get(i);
            characters.remove(i);
            recur1(characters,str+character,ans);
            characters.add(i, character);
        }
    }

    public static void main(String[] args) {
        StringPermutation permutation = new StringPermutation();
        String s1 = "abc";
        List<String> list = permutation.getStringAllPermutation(s1);
        System.out.println("生成字符的全部排列");
        for (String s : list) {
            System.out.println(s);
        }
    }
}
