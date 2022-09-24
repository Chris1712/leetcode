package personal.chris.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WildcardMatchingTest {

    WildcardMatching matching;

    @BeforeEach
    void setup() {
        matching = new WildcardMatching();
    }

    @Test
    void simple() {
        assertFalse(matching.isMatch("aa", "a"));
    }

    @Test
    void simple2() {
        assertTrue(matching.isMatch("aa", "aa"));
    }

    @Test
    void singleChar() {
        assertTrue(matching.isMatch("aa", "?a"));
    }

    @Test
    void wildcardChar() {
        assertTrue(matching.isMatch("zbhjbhjdsa", "*a"));
    }

    @Test
    void entireStringFromStart() {
        assertFalse(matching.isMatch("abc", "?c"));
    }

    @Test
    void entireStringFromEnd() {
        assertFalse(matching.isMatch("abc", "a?"));
    }

}
