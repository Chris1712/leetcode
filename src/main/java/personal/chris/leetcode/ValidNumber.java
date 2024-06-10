package personal.chris.leetcode;

import java.util.regex.Pattern;

/**
 * To solve <a href="https://leetcode.com/problems/valid-number/description/"65. Valid Number</a>
 * HARD
 */
public class ValidNumber {

    public boolean isNumber(String s) {
        String regex = """
        ^                               # Start of string
        [+-]?                           # Optional sign
        (\\d+\\.|\\d*\\.\\d+|\\d+)      # Digits and decimal
        ([eE][+-]?\\d+)?                # Optional exponent
        """;

        Pattern pattern = Pattern.compile(regex, Pattern.COMMENTS);
        return pattern.matcher(s).matches();
    }

}
