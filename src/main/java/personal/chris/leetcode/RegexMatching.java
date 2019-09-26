package personal.chris.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * To solve <a href="https://leetcode.com/problems/regular-expression-matching">10. Regular Expression Matching</a>
 */
public class RegexMatching {

    private Map<String, Boolean> resultLookup = new HashMap<>();

    /**
     * Wrapping method to handle caching
     */
    boolean isMatch(String s, String p) {
        String mapKey = s + "-" + p;
        if (resultLookup.containsKey(mapKey)) {
            return resultLookup.get(mapKey);
        }
        boolean result = checkMatch(s, p);
        resultLookup.put(mapKey, result);
        return result;
    }

    /**
     * Method for checking match logic
     */
    private boolean checkMatch(String s, String p) {
        if (s.length() == 0 && p.length() == 0) {
            return true; // We made it to the end of both strings!
        }

        if (p.length() > 1 && p.charAt(1) == '*') {
            // If we have a repeating character, try skipping it.
            if (isMatch(s, p.substring(2))) {
                return true;
            }
        }
        if (s.length() != 0 ^ p.length() != 0) {
            // If only one string has characters left then we can't have a match
            return false;
        }
        // Now we have both strings non-empty
        if(s.charAt(0) != p.charAt(0) && p.charAt(0) != '.') {
            // If the first characters of both strings aren't equal (up to wildcards) we've lost
            return false;
        }
        if(p.length() > 1 && p.charAt(1) == '*') {
            // We have a repeating char, so we have to branch to decide whether to remove the character or not
            return isMatch(s.substring(1), p.substring(2)) || isMatch(s.substring(1), p);
        } else {
            return (isMatch(s.substring(1), p.substring(1)));
        }
    }

    public static boolean verify(String s, String p) {
        return Pattern.compile("^" + p + "$").matcher(s).find();
    }

}
