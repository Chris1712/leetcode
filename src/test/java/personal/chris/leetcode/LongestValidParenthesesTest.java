package personal.chris.leetcode;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestValidParenthesesTest {

    static LongestValidParentheses parens;

    @BeforeAll
    static void setup() {
        parens = new LongestValidParentheses();
    }

    @Test
    void providedExample1() {
        int result = parens.longestValidParentheses("(()");

        assertEquals(2, result);
    }

    @Test
    void providedExample2() {
        int result = parens.longestValidParentheses(")()())");

        assertEquals(4, result);
    }

    @Test
    void nested() {
        int result = parens.longestValidParentheses("((()))()");

        assertEquals(8, result);
    }

    @Test
    void nested2() {
        int result = parens.longestValidParentheses("((())))()");

        assertEquals(6, result);
    }

    @Test
    void noValid() {
        int result = parens.longestValidParentheses("))");

        assertEquals(0, result);
    }

    @Test
    void emptyString() {
        int result = parens.longestValidParentheses("");

        assertEquals(0, result);
    }
}