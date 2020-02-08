package personal.chris.leetcode;

/**
 * To solve <a href="https://leetcode.com/problems/divide-two-integers/">29. Divide Two Integers</a>
 * MEDIUM
 */
public class DivideTwoIntegers {

    public int divide(int dividend, int divisor) {
        return bitwise(dividend, divisor);
    }

    /**
     * O(n) approach using repeated addition until we exceed dividend
     */
    public int repeatedAddition(int dividend, int divisor) {
        // Treat eveything as positive and put a sign back on at the end if needed
        int sign = ((dividend < 0 ) ^ (divisor < 0)) ? -1 : 1;

        // Set positive
        dividend = dividend < 0 ? 0 - dividend : dividend;
        divisor = divisor < 0 ? 0 - divisor : divisor;

        // Need to find quotient, such that quotient * divisor <= dividend, quotient + 1 * divisor > dividend

        int product = 0;
        int quotient = 0;

        while (product <= dividend) {
            quotient++;
            product += divisor;
        }

        return sign * (quotient - 1); // Do this with subtraction if we really care about no *
    }

    /**
     * O(log n) approach using bitwise logic (incrementing in powers of 2 instead of linearly)
     */
    public int bitwise(long dividend, long divisor) {
        // Treat eveything as positive and put a sign back on at the end if needed
        int sign = ((dividend < 0 ) ^ (divisor < 0)) ? -1 : 1;

        // Set positive
        dividend = dividend < 0 ? 0 - dividend : dividend;
        divisor = divisor < 0 ? 0 - divisor : divisor;

        long quotient = 0, temp = 0;

        for (int i = 31; i >= 0; --i)
        {
            // Check if each power of 2 * divisor is less than dividend, if so add that power of 2 to the quotient
            if ((temp + (divisor << i)) <= dividend)
            {
                temp += divisor << i;
                quotient |= 1L << i;
            }
        }
        return sign * (int) quotient; // Do this with subtraction if we really care about no *
    }
}
