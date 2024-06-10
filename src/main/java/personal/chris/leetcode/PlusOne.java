package personal.chris.leetcode;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * To solve <a href="https://leetcode.com/problems/plus-one/description/"66. Plus One</a>
 * EASY
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {

        return plusOneRecursive(digits, digits.length-1);

    }

    private int[] plusOneRecursive(int[] digits, int position) {
        if (position == -1) {
            return IntStream.concat(IntStream.of(1), Arrays.stream(digits)).toArray();
        } else if (digits[position] == 9) {
            digits[position] = 0;
            return plusOneRecursive(digits, position -1);
        } else {
            digits[position]++;
            return digits;
        }
    }
}
