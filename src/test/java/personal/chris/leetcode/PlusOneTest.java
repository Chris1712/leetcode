package personal.chris.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PlusOneTest {

    PlusOne tar = new PlusOne();

    @Test
    void example1() {
        int[] input = {1,2,3};

        assertTrue(Arrays.equals(new int[]{1,2,4}, tar.plusOne(input)));
    }

    @Test
    void example3() {
        int[] input = {9};

        assertTrue(Arrays.equals(new int[]{1,0}, tar.plusOne(input)));
    }

    @Test
    void repeatedRounding() {
        int[] input = {9,9};

        assertTrue(Arrays.equals(new int[]{1,0,0}, tar.plusOne(input)));
    }


    @Test
    void repeatedRounding2() {
        int[] input = {9,0,9};

        assertTrue(Arrays.equals(new int[]{9,1,0}, tar.plusOne(input)));
    }

}
