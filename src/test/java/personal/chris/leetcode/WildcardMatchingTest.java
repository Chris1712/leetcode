package personal.chris.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

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
    void wildcardMiddle() {
        assertTrue(matching.isMatch("agyugyua", "a*a"));
    }

    @Test
    void wildcardEmpty() {
        assertTrue(matching.isMatch("ab", "ab*"));
    }

    @Test
    void twoWildcards() {
        assertTrue(matching.isMatch("zbhjbhjdsab", "*a*"));
    }

    @Test
    void twoWildcardsInARow() {
        assertTrue(matching.isMatch("abc", "*a***"));
    }

    @Test
    void twoWildcardsInARow2() {
        assertTrue(matching.isMatch("a", "*a***"));
    }

    @Test
    void entireStringFromStart() {
        assertFalse(matching.isMatch("abc", "?c"));
    }

    @Test
    void entireStringFromEnd() {
        assertFalse(matching.isMatch("abc", "a?"));
    }

    @Test
    void slow() {
        var start = Instant.now();
        Boolean result = matching.isMatch(
                "abbabbbaabaaabbbbbabbabbabbbabbaaabbbababbabaaabbab",
                "*aabb***aa**a******aa*"
        );
        Duration taken = Duration.between(start, Instant.now());

        assertTrue(taken.toMillis() < 100);
        assertTrue(result);
    }

    @Test
    void slow2() {
        var start = Instant.now();
        Boolean result = matching.isMatch(
                "abbaabbbbababaababababbabbbaaaabbbbaaabbbabaabbbbbabbbbabbabbaaabaaaabbbbbbaaabbabbbbababbbaaabbabbabb",
                "***b**a*a*b***b*a*b*bbb**baa*bba**b**bb***b*a*aab*a**"
        );
        Duration taken = Duration.between(start, Instant.now());

        assertTrue(taken.toMillis() < 1000);
        assertTrue(result);
    }

    @Test
    void big() {
        var start = Instant.now();

        Boolean result = matching.isMatch(
        "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
        "*aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa*"
        );
        Duration taken = Duration.between(start, Instant.now());

        assertTrue(taken.toMillis() < 1000);
        assertTrue(matching.getBadStrings().size() < 1000);
        assertTrue(matching.getGoodStrings().size() < 1000);
        assertFalse(result);
    }


    @Nested
    class removeStars {
        @Test
        void oneStar() {
            String res = matching.removeStars("*abc*");

            assertEquals("abc*", res);
        }

        @Test
        void manyStars() {
            String res = matching.removeStars("***x*yz");

            assertEquals("x*yz", res);
        }

        @Test
        void allStars() {
            String res = matching.removeStars("*");

            assertEquals("", res);
        }

    }

}
