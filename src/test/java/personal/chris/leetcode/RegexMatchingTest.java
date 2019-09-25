package personal.chris.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RegexMatchingTest {

    @Test
    void mismatch() {
        boolean result = RegexMatching.wrapper("aa", "a");
        assertFalse(result);
    }

    @Test
    void mismatch2() {
        boolean result = RegexMatching.wrapper("aa", "aaa");
        assertFalse(result);
    }

    @Test
    void Simplematch() {
        boolean result = RegexMatching.wrapper("aa", "aa");
        assertTrue(result);
    }

    @Test
    void Simplematch2() {
        boolean result = RegexMatching.wrapper("abc", "abc");
        assertTrue(result);
    }

    @Test
    void Repetition() {
        boolean result = RegexMatching.wrapper("aba", "ab*a");
        assertTrue(result);
    }

    @Test
    void Repetition2() {
        boolean result = RegexMatching.wrapper("abbbb", "a*b*");
        assertTrue(result);
    }

    @Test
    void Repetition3() {
        boolean result = RegexMatching.wrapper("aabbbb", "c*a*b*c*");
        assertTrue(result);
    }

    @Test
    void RepetitionNegative() {
        boolean result = RegexMatching.wrapper("abbbbc", "a*b*");
        assertFalse(result);
    }

    @Test
    void RepetitionNegative2() {
        boolean result = RegexMatching.wrapper("ac", "a*b*");
        assertFalse(result);
    }

    @Test
    void Wildcard() {
        boolean result = RegexMatching.wrapper("ab", "a.");
        assertTrue(result);
    }

    @Test
    void Wildcard2() {
        boolean result = RegexMatching.wrapper("abc", "..c");
        assertTrue(result);
    }

    @Test
    void WildcardNegative() {
        boolean result = RegexMatching.wrapper("ab", "a.b");
        assertFalse(result);
    }

    @Test
    void WildcardNegative2() {
        boolean result = RegexMatching.wrapper("aa", ".");
        assertFalse(result);
    }

    @Test
    void WildcardRepetition() {
        boolean result = RegexMatching.wrapper("bbbba", ".*a*a");
        assertTrue(result);
    }

    @Test
    void EmptyPattern() {
        boolean result = RegexMatching.wrapper("aa", "");
        assertFalse(result);
    }

    @Test
    void EmptyString() {
        boolean result = RegexMatching.wrapper("", ".");
        assertFalse(result);
    }

    @Test
    void EmptyBoth() {
        boolean result = RegexMatching.wrapper("", "");
        assertTrue(result);
    }

    @Test
    void LongPattern() {
        boolean result = RegexMatching.wrapper("aaaaaaaaaaaaab", "a*a*a*a*a*a*a*a*a*a*c");
        assertFalse(result);
    }



}