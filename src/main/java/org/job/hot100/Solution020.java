package org.job.hot100;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Superman
 */
public class Solution020 {
    public boolean isValid(String s) {
        if (s.length() < 2) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        Deque<Character> deque = new ArrayDeque<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (!map.containsKey(aChar)) {
                deque.push(aChar);
            } else {
                if (deque.isEmpty()) {
                    return false;
                } else {
                    Character peek = deque.peek();
                    if (!peek.equals(map.get(aChar))) {
                        return false;
                    } else {
                        deque.pop();
                    }
                }
            }
        }
        return deque.isEmpty();
    }

    public static void main(String[] args) {
        Solution020 solution020 = new Solution020();
        // boolean valid = solution020.isValid("({[]})");
        boolean valid = solution020.isValid("){");
        System.out.println(valid);
    }
}
