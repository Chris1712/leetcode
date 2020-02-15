package personal.chris.leetcode.util;

import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class Assert2DArrayEquals {

    public static void assert2DArrayEquals(Object[][] expected, Object[][] actual) {

        if (expected == null || actual == null) {
            if (expected == null && actual == null) {
                return;
            } else {
                Assertions.fail("Both arrays not null");
            }
        }

        Assertions.assertEquals(expected.length, actual.length, "Array lengths differ");

        for (int i = 0; i < expected.length; i++) {
            Assertions.assertArrayEquals(expected[i], actual[i], "Failed on row " + i);
        }

    }

}
