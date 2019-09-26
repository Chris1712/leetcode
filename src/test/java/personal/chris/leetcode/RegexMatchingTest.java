package personal.chris.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RegexMatchingTest {

    RegexMatching matching;

    @BeforeEach
    void setup() {
        matching = new RegexMatching();
    }

    @Test
    void mismatch() {
        boolean result = matching.isMatch("aa", "a");
        assertFalse(result);
    }

    @Test
    void mismatch2() {
        boolean result = matching.isMatch("aa", "aaa");
        assertFalse(result);
    }

    @Test
    void Simplematch() {
        boolean result = matching.isMatch("aa", "aa");
        assertTrue(result);
    }

    @Test
    void Simplematch2() {
        boolean result = matching.isMatch("abc", "abc");
        assertTrue(result);
    }

    @Test
    void Repetition() {
        boolean result = matching.isMatch("aba", "ab*a");
        assertTrue(result);
    }

    @Test
    void Repetition2() {
        boolean result = matching.isMatch("abbbb", "a*b*");
        assertTrue(result);
    }

    @Test
    void Repetition3() {
        boolean result = matching.isMatch("aabbbb", "c*a*b*c*");
        assertTrue(result);
    }

    @Test
    void RepetitionNegative() {
        boolean result = matching.isMatch("abbbbc", "a*b*");
        assertFalse(result);
    }

    @Test
    void RepetitionNegative2() {
        boolean result = matching.isMatch("ac", "a*b*");
        assertFalse(result);
    }

    @Test
    void Wildcard() {
        boolean result = matching.isMatch("ab", "a.");
        assertTrue(result);
    }

    @Test
    void Wildcard2() {
        boolean result = matching.isMatch("abc", "..c");
        assertTrue(result);
    }

    @Test
    void WildcardNegative() {
        boolean result = matching.isMatch("ab", "a.b");
        assertFalse(result);
    }

    @Test
    void WildcardNegative2() {
        boolean result = matching.isMatch("aa", ".");
        assertFalse(result);
    }

    @Test
    void WildcardRepetition() {
        boolean result = matching.isMatch("bbbba", ".*a*a");
        assertTrue(result);
    }

    @Test
    void EmptyPattern() {
        boolean result = matching.isMatch("aa", "");
        assertFalse(result);
    }

    @Test
    void EmptyString() {
        boolean result = matching.isMatch("", ".");
        assertFalse(result);
    }

    @Test
    void EmptyBoth() {
        boolean result = matching.isMatch("", "");
        assertTrue(result);
    }

    @Test
    void LongPattern() {
        boolean result = matching.isMatch("aaaaaaaaaaaaab", "a*a*a*a*a*a*a*a*a*a*c");
        assertFalse(result);
    }



}