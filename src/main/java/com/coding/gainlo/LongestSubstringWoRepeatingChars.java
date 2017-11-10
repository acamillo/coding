package com.coding.gainlo;

import java.util.HashSet;
import java.util.Set;

/**
 * @author acamillo
 * @since 16/10/17.
 */
public class LongestSubstringWoRepeatingChars {

    public String apply(String s) {
        Set<Character> dups = new HashSet<Character>();

        int start = 0, end = 0;
        String longest = "";

        if (s == null || s.length() == 0) return "";

        while (end < s.length()) {
            Character ch = s.charAt(end);

            if (!dups.contains(ch)) {
                dups.add(ch);
                if (end - start + 1 > longest.length()) {
                    longest = s.substring(start, end + 1);
                }
            } else {
                while(s.charAt(start) != s.charAt(end)) {
                    dups.remove(s.charAt(start));
                    start++;
                }
                start++;
            }
            end++;
        }

        return longest;
    }
}