package personal.chris.leetcode;

import java.util.Arrays;

/**
 * To solve <a href="https://leetcode.com/problems/first-missing-positive/>41. First Missing Positive</a>
 * HARD
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] A) {
        if (A.length == 0) {
            return 1;
        }

        // Make all the negative elements big, we don't care about them
        int biggest = 1+A.length;
        for (int i = 0; i < A.length; i++) {
            if (A[i] <= 0) {
                A[i] = biggest;
            }
        }

        // Now iterate through the array, and mark position A[i] as negative, if A[i] < biggest
        for (int i = 0; i < A.length; i++) {
            int element = Math.abs(A[i]);
            if (element < biggest) {
                A[element-1] = A[element-1] < 0 ? A[element-1] : -1 * A[element-1];
            }
        }

        // Now iterate through and find first non-negative position, that's our missing int.
        int i = 0;
        int lowestNonNegative = 0;
        while (i < A.length && lowestNonNegative == 0) {
            lowestNonNegative = A[i] < 0 ? 0 : i+1;
            i++;
        }
        if (lowestNonNegative == 0) {
            lowestNonNegative = biggest;
        }

        return lowestNonNegative;
    }
}
