package personal.chris.leetcode;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FirstMissingPositiveTest {

    static FirstMissingPositive first;

    @BeforeAll
    static void setup() {
        first = new FirstMissingPositive();
    }

    @Test
    void example1() {
        int result = first.firstMissingPositive(new int[]{1,2,0});

        assertEquals(3, result);
    }

    @Test
    void example2() {
        int result = first.firstMissingPositive(new int[]{3,4,-1,1});

        assertEquals(2, result);
    }

    @Test
    void example3() {
        int result = first.firstMissingPositive(new int[]{7,8,9,11,12});

        assertEquals(1, result);
    }

    @Test
    void emptyArray() {
        int result = first.firstMissingPositive(new int[]{});

        assertEquals(1, result);
    }

    @Test
    void allNegative() {
        int result = first.firstMissingPositive(new int[]{-7,-8,-9});

        assertEquals(1, result);
    }

    @Test
    void oneTwoThree() {
        int result = first.firstMissingPositive(new int[]{1,2,3});

        assertEquals(4, result);
    }

}