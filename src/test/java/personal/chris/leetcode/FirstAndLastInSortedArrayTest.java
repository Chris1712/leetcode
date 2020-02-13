package personal.chris.leetcode;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FirstAndLastInSortedArrayTest {

    static FirstAndLastInSortedArray firstAndLast;

    @BeforeAll
    static void setup() {
        firstAndLast = new FirstAndLastInSortedArray();
    }

    @Test
    void providedExample1() {
        int[] result = firstAndLast.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);

        assertArrayEquals( new int[]{3, 4}, result);
    }

    @Test
    void providedExample2() {
        int[] result = firstAndLast.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6);

        assertArrayEquals( new int[]{-1, -1}, result);
    }

    @Test
    void emptyRange() {
        int[] result = firstAndLast.searchRange(new int[]{}, 6);

        assertArrayEquals( new int[]{-1, -1}, result);
    }

    @Test
    void singleElement() {
        int[] result = firstAndLast.searchRange(new int[]{5}, 5);

        assertArrayEquals( new int[]{0, 0}, result);
    }

    @Test
    void singleElementNoMatch() {
        int[] result = firstAndLast.searchRange(new int[]{5}, 6);

        assertArrayEquals( new int[]{-1, -1}, result);
    }

    @Test
    void twoElementNoMatch() {
        int[] result = firstAndLast.searchRange(new int[]{5, 6}, 9);

        assertArrayEquals( new int[]{-1, -1}, result);
    }

    @Test
    void twoElementOneMatch() {
        int[] result = firstAndLast.searchRange(new int[]{5, 6}, 5);

        assertArrayEquals( new int[]{0, 0}, result);
    }

    @Test
    void twoElementBothMatch() {
        int[] result = firstAndLast.searchRange(new int[]{9, 9}, 9);

        assertArrayEquals( new int[]{0, 1}, result);
    }

    @Test
    void threeElementAllMatch() {
        int[] result = firstAndLast.searchRange(new int[]{11, 11, 11}, 11);

        assertArrayEquals( new int[]{0, 2}, result);
    }

    @Test
    void threeElementMidMatch() {
        int[] result = firstAndLast.searchRange(new int[]{11, 12, 13}, 12);

        assertArrayEquals( new int[]{1, 1}, result);
    }



}