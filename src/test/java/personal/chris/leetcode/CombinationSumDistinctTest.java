package personal.chris.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CombinationSumDistinctTest {

    static CombinationSumDistinct sum;

    @BeforeEach
    void setup() {
        sum = new CombinationSumDistinct();
    }

    @Test
    void example1() {
        int[] candidates = new int[]{10,1,2,7,6,1,5};

        var result = sum.combinationSum2(candidates, 8);

        assertEquals(4, result.size());
        assertTrue(result.contains(List.of(1,7)));
        assertTrue(result.contains(List.of(1,2,5)));
        assertTrue(result.contains(List.of(2,6)));
        assertTrue(result.contains(List.of(1,1,6)));
    }

    @Test
    void example2() {
        int[] candidates = new int[]{2,5,2,1,2};

        var result = sum.combinationSum2(candidates, 5);

        assertEquals(2, result.size());
        assertTrue(result.contains(List.of(1,2,2)));
        assertTrue(result.contains(List.of(5)));
    }


    @Test
    void simpleExample() {
        int[] candidates = new int[]{5,2,1};

        var result = sum.combinationSum2(candidates, 3);

        assertEquals(1, result.size());
        assertTrue(result.contains(List.of(1,2)));
    }

    @Test
    void noSolutions() {
        int[] candidates = new int[]{2,4,6};

        var result = sum.combinationSum2(candidates, 3);

        assertEquals(0, result.size());
    }

}