package personal.chris.leetcode;

/**
 * To solve <a href="https://leetcode.com/problems/longest-valid-parentheses/">32. Longest Valid Parentheses</a>
 * HARD
 */
public class LongestValidParentheses {

    public int longestValidParentheses(String s) {

        int len = s.length();
        int recordlength = 0;

        // Iterate through starting positions
        for (int i = 0; i < len-1; i++) {

            int open = 0;
            int close = 0;

            // Iterate through ending positions
            for (int j = i; j < len; j++) {

                // Count up ( and )
                if (s.charAt(j) == '(') {
                    open++;
                } else {
                    close++;
                }

                if (close > open) {
                    // This string is invalid if we ever have more closes than opens, break and go to next starting position
                    break;
                } else if (open == close && (1 + j - i) > recordlength) {
                    recordlength = 1 + j - i;
                }
            }


        }

        return recordlength;
    }
}
