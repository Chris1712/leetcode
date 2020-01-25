package personal.chris.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SubstringConcatenationTest {

    SubstringConcatenation substr;

    @BeforeEach
    void setup() {
        substr = new SubstringConcatenation();
    }

    @Test
    void oneMatch() {
        List<Integer> result = substr.findSubstring("barfodthefoobarman", new String[]{"foo", "bar"});
        assertEquals(Arrays.asList(9), result);
    }

    @Test
    void twoMatch() {
        List<Integer> result = substr.findSubstring("barfoothefoobarman", new String[]{"foo", "bar"});
        assertEquals(Arrays.asList(0, 9), result);
    }

    @Test
    void noMatch() {
        List<Integer> result = substr.findSubstring("barfoothefoobarman", new String[]{"foo", "bar", "hey"});
        assertEquals(Collections.emptyList(), result);
    }

    @Test
    void emptyString() {
        List<Integer> result = substr.findSubstring("", new String[]{"foo", "bar"});
        assertEquals(Collections.emptyList(), result);
    }

    @Test
    void listTooLong() {
        List<Integer> result = substr.findSubstring("foo", new String[]{"foo", "bar"});
        assertEquals(Collections.emptyList(), result);
    }

    @Test
    void repeatedMatch() {
        List<Integer> result = substr.findSubstring("foo", new String[]{"foo", "foo"});
        assertEquals(Collections.emptyList(), result);
    }

    @Test
    void repeatedMatch2() {
        List<Integer> result = substr.findSubstring("foofoo", new String[]{"foo", "foo"});
        assertEquals(Arrays.asList(0), result);
    }

}
