package personal.chris.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * To solve <a href="https://leetcode.com/problems/substring-with-concatenation-of-all-words">30. Substring with Concatenation of All Words</a>
 */
public class SubstringConcatenation {

    public List<Integer> findSubstring(String s, String[] words) {
        // Edge cases for words:
        if (words == null || words.length == 0) {
            return Collections.emptyList();
        }

        List<Integer> indices = new ArrayList<>();
        int wordLength = words[0].length(); // Length of each word in list
        int candidateLength = wordLength * words.length; // Total length of string to match:


        // Edge cases for string:
        if (s == null || s.length() < candidateLength) {
            return Collections.emptyList();
        }

        // Iterate through each string that could be a concatenation of the provided words
        for (int i = 0; i <= (s.length()-candidateLength); i++) {
            String candidate = s.substring(i, i+candidateLength);

            List<String> tempList = new ArrayList(Arrays.asList(words));
            // Iterate through the words in the string - remember each member of words is the same length (wordLength)
            for (int j = 0; j < words.length; j++) {
                Integer index = j * wordLength;
                String word = candidate.substring(index, index + wordLength);
                if (!tempList.contains(word)) {
                    break;
                }
                tempList.remove(word);
            }

            if (tempList.isEmpty()) {
                indices.add(i);
            }
        }

        return indices;
    }
}
