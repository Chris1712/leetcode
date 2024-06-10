package personal.chris.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimumPathSumTest {

    final MinimumPathSum target = new MinimumPathSum();

    @Test
    void example1() {
        int[][] data = {
            {1, 3, 1},
            {1, 5, 1},
            {4, 2, 1},
        };

        assertEquals(7, target.minPathSum(data));
    }

    @Test
    void example2() {
        int[][] data = {
            {1, 2, 3},
            {4, 5, 6},
        };

        assertEquals(12, target.minPathSum(data));
    }

    @Test
    void singleRow() {
        int[][] data = {
            {1, 2, 3}
        };

        assertEquals(6, target.minPathSum(data));
    }

    @Test
    void singleCol() {
        int[][] data = {
            {1},
            {5},
            {100}
        };

        assertEquals(106, target.minPathSum(data));
    }

    @Test
    void singleVal() {
        int[][] data = {
            {5},
        };

        assertEquals(5, target.minPathSum(data));
    }

}
