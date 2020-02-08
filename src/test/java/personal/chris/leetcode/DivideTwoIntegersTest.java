package personal.chris.leetcode;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DivideTwoIntegersTest {

    static DivideTwoIntegers divide;

    @BeforeAll
    static void setup() {
        divide = new DivideTwoIntegers();
    }

    @Test
    void providedExample1() {
        int result = divide.divide(10, 3);

        assertEquals(result, 3);
    }

    @Test
    void providedExample2() {
        int result = divide.divide(7, -3);

        assertEquals(result, -2);
    }

    @Test
    void negativeDividend() {
        int result = divide.divide(-7, 2);

        assertEquals(result, -3);
    }

    @Test
    void negativeBoth() {
        int result = divide.divide(-8, -2);

        assertEquals(result, 4);
    }

    @Test
    void negativeBothWithRemainder() {
        int result = divide.divide(-8, -3);

        assertEquals(result, 2);
    }

    @Test
    void divisorDividendEqual() {
        int result = divide.divide(10, 10);

        assertEquals(result, 1);
    }

    @Test
    void divisorDividendEqual2() {
        int result = divide.divide(1, 1);

        assertEquals(result, 1);
    }

    @Test
    void divisorLarger() {
        int result = divide.divide(10, 20);

        assertEquals(result, 0);
    }

}