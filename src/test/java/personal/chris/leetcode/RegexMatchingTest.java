package personal.chris.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RegexMatchingTest {

    @Test
    void mismatch() {
        boolean result = RegexMatching.isMatch("aa", "a");
        assertFalse(result);
    }

    @Test
    void mismatch2() {
        boolean result = RegexMatching.isMatch("aa", "aaa");
        assertFalse(result);
    }

    @Test
    void Simplematch() {
        boolean result = RegexMatching.isMatch("aa", "aa");
        assertTrue(result);
    }

    @Test
    void Simplematch2() {
        boolean result = RegexMatching.isMatch("abc", "abc");
        assertTrue(result);
    }

    @Test
    void Repetition() {
        boolean result = RegexMatching.isMatch("aba", "ab*a");
        assertTrue(result);
    }

    @Test
    void Repetition2() {
        boolean result = RegexMatching.isMatch("abbbb", "a*b*");
        assertTrue(result);
    }

    @Test
    void RepetitionNegative() {
        boolean result = RegexMatching.isMatch("abbbbc", "a*b*");
        assertFalse(result);
    }

    @Test
    void RepetitionNegative2() {
        boolean result = RegexMatching.isMatch("ac", "a*b*");
        assertFalse(result);
    }

    @Test
    void Wildcard() {
        boolean result = RegexMatching.isMatch("ab", "a.");
        assertTrue(result);
    }

    @Test
    void Wildcard2() {
        boolean result = RegexMatching.isMatch("abc", "..c");
        assertTrue(result);
    }

    @Test
    void WildcardNegative() {
        boolean result = RegexMatching.isMatch("ab", "a.b");
        assertFalse(result);
    }

    @Test
    void WildcardNegative2() {
        boolean result = RegexMatching.isMatch("aa", ".");
        assertFalse(result);
    }

    @Test
    void EmptyPattern() {
        boolean result = RegexMatching.isMatch("aa", "");
        assertFalse(result);
    }

    @Test
    void EmptyString() {
        boolean result = RegexMatching.isMatch("", ".");
        assertFalse(result);
    }

    @Test
    void EmptyBoth() {
        boolean result = RegexMatching.isMatch("", "");
        assertTrue(result);
    }



}