package personal.chris.leetcode;

import java.util.regex.Pattern;

/**
 * To solve
 * https://leetcode.com/problems/regular-expression-matching
 */
public class RegexMatching {

    public static boolean isMatch(String s, String p) {
        return verify(s,p);
    }

    public static boolean verify(String s, String p) {
        return Pattern.compile("^" + p + "$").matcher(s).find();
    }

}
