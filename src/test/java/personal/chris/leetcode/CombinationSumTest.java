package personal.chris.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CombinationSumTest {

    static CombinationSum sum;

    @BeforeEach
    void setup() {
        sum = new CombinationSum();
    }

    @Test
    void example1() {
        int[] candidates = new int[]{2,3,6,7};

        var result = sum.combinationSum(candidates, 7);

        assertEquals(2, result.size());
        assertTrue(result.contains(List.of(7)));
        assertTrue(result.contains(List.of(2,2,3)));
    }

    @Test
    void example2() {
        int[] candidates = new int[]{2,3,5};

        var result = sum.combinationSum(candidates, 8);

        assertEquals(3, result.size());
        assertTrue(result.contains(List.of(2,2,2,2)));
        assertTrue(result.contains(List.of(2,3,3)));
        assertTrue(result.contains(List.of(3,5)));
    }


    @Test
    void simpleExample() {
        int[] candidates = new int[]{5,2,1};

        var result = sum.combinationSum(candidates, 3);

        assertEquals(2, result.size());
        assertTrue(result.contains(List.of(1,2)));
        assertTrue(result.contains(List.of(1,1,1)));
    }

    @Test
    void noSolutions() {
        int[] candidates = new int[]{2,4,6};

        var result = sum.combinationSum(candidates, 3);

        assertEquals(0, result.size());
    }



}