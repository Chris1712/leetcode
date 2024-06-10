package personal.chris.leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ValidNumberTest {

    final ValidNumber tar = new ValidNumber();

    @ParameterizedTest
    @MethodSource("validNumberStrings")
    void validNumberTest(String numberString) {
        assertTrue(tar.isNumber(numberString));
    }

    private static Stream<String> validNumberStrings() {
        return Stream.of("2", "0089", "-0.1", "+3.14", "4.", "-.9",
                "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789");
    }

    @ParameterizedTest
    @MethodSource("invalidNumberStrings")
    void invalidNumberTest(String numberString) {
        assertFalse(tar.isNumber(numberString));
    }

    private static Stream<String> invalidNumberStrings() {
        return Stream.of("abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53");
    }
}
