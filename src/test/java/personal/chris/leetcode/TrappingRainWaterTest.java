package personal.chris.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrappingRainWaterTest {

    static TrappingRainWater trap;

    @BeforeEach
    void setup() {
        trap = new TrappingRainWater();
    }

    @Test
    void example1() {
        int[] input = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};

        assertEquals(6, trap.trap(input));
    }

    @Test
    void simple() {
        int[] input = new int[]{1,0,1,0};

        assertEquals(1, trap.trap(input));
    }

    @Test
    void empty() {
        int[] input = new int[]{};

        assertEquals(0, trap.trap(input));
    }

    @Test
    void flat() {
        int[] input = new int[]{0,0,0};

        assertEquals(0, trap.trap(input));
    }

    @Test
    void stepUp() {
        int[] input = new int[]{0,1,1,2,2};

        assertEquals(0, trap.trap(input));
    }

    @Test
    void stepDown() {
        int[] input = new int[]{3,3,0,0};

        assertEquals(0, trap.trap(input));
    }

    @Test
    void bucket() {
        int[] input = new int[]{10,0,0,10};

        assertEquals(20, trap.trap(input));
    }

    @Test
    void bucketLeftLower() {
        int[] input = new int[]{5,0,0,10};

        assertEquals(10, trap.trap(input));
    }

    @Test
    void bucketRightLower() {
        int[] input = new int[]{10,0,0,5};

        assertEquals(10, trap.trap(input));
    }



}