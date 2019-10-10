package personal.chris.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * To solve <a href="https://leetcode.com/problems/substring-with-concatenation-of-all-words">30. Substring with Concatenation of All Words</a>
 */
public class SubstringConcatenation {

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> indices = new ArrayList<>();

        // Edge cases for words:
        if (words == null || words.length == 0) {
            return Collections.emptyList();
        }

        // Get total length of string to match:
        int matchLength = 0;
        for (int i = 0; i < words.length; i++) {
            matchLength += words[i].length();
        }

        // Edge cases for string:
        if (s == null || s.length() < matchLength) {
            return Collections.emptyList();
        }

        for (int i = 0; i < (s.length()-matchLength); i++) {
            String subString = s.substring(i, i+matchLength);

        }

        return indices;
    }

}
