package personal.chris.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SubstringConcatenationTest {

    SubstringConcatenation substr;

    @BeforeEach
    void setup() {
        substr = new SubstringConcatenation();
    }

    @Test
    void mismatch() {
        List<Integer> result = substr.findSubstring("barfoothefoobarman", new String[]{"foo", "bar"});
        assertEquals(Arrays.asList(0,9), result);
    }

}
