package personal.chris.leetcode;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidSudokuTest {

    static ValidSudoku valid;

    @BeforeAll
    static void setup() {
        valid = new ValidSudoku();
    }

    @Test
    void example1() {
        char[][] grid = new char[9][9];

        grid[0] = new char[] {'5','3','.','.','7','.','.','.','.'};
        grid[1] = new char[] {'6','.','.','1','9','5','.','.','.'};
        grid[2] = new char[] {'.','9','8','.','.','.','.','6','.'};
        grid[3] = new char[] {'8','.','.','.','6','.','.','.','3'};
        grid[4] = new char[] {'4','.','.','8','.','3','.','.','1'};
        grid[5] = new char[] {'7','.','.','.','2','.','.','.','6'};
        grid[6] = new char[] {'.','6','.','.','.','.','2','8','.'};
        grid[7] = new char[] {'.','.','.','4','1','9','.','.','5'};
        grid[8] = new char[] {'.','.','.','.','8','.','.','7','9'};

        assertEquals(true, valid.isValidSudoku(grid));
    }

    @Test
    void example2() {
        char[][] grid = new char[9][9];

        grid[0] = new char[] {'8','3','.','.','7','.','.','.','.'};
        grid[1] = new char[] {'6','.','.','1','9','5','.','.','.'};
        grid[2] = new char[] {'.','9','8','.','.','.','.','6','.'};
        grid[3] = new char[] {'8','.','.','.','6','.','.','.','3'};
        grid[4] = new char[] {'4','.','.','8','.','3','.','.','1'};
        grid[5] = new char[] {'7','.','.','.','2','.','.','.','6'};
        grid[6] = new char[] {'.','6','.','.','.','.','2','8','.'};
        grid[7] = new char[] {'.','.','.','4','1','9','.','.','5'};
        grid[8] = new char[] {'.','.','.','.','8','.','.','7','9'};

        assertEquals(false, valid.isValidSudoku(grid));
    }

    @Test
    void brokenRow() {
        char[][] grid = new char[9][9];

        grid[0] = new char[] {'5','3','.','.','7','.','.','.','7'};
        grid[1] = new char[] {'6','.','.','1','9','5','.','.','.'};
        grid[2] = new char[] {'.','9','8','.','.','.','.','6','.'};
        grid[3] = new char[] {'8','.','.','.','6','.','.','.','3'};
        grid[4] = new char[] {'4','.','.','8','.','3','.','.','1'};
        grid[5] = new char[] {'7','.','.','.','2','.','.','.','6'};
        grid[6] = new char[] {'.','6','.','.','.','.','2','8','.'};
        grid[7] = new char[] {'.','.','.','4','1','9','.','.','5'};
        grid[8] = new char[] {'.','.','.','.','8','.','.','7','9'};

        assertEquals(false, valid.isValidSudoku(grid));
    }

    @Test
    void brokenCol() {
        char[][] grid = new char[9][9];

        grid[0] = new char[] {'5','3','.','.','7','.','.','.','.'};
        grid[1] = new char[] {'6','.','.','1','9','5','.','.','.'};
        grid[2] = new char[] {'.','9','8','.','.','.','.','6','.'};
        grid[3] = new char[] {'8','.','.','.','6','.','.','.','3'};
        grid[4] = new char[] {'4','6','.','8','.','3','.','.','1'};
        grid[5] = new char[] {'7','.','.','.','2','.','.','.','6'};
        grid[6] = new char[] {'.','6','.','.','.','.','2','8','.'};
        grid[7] = new char[] {'.','.','.','4','1','9','.','.','5'};
        grid[8] = new char[] {'.','.','.','.','8','.','.','7','9'};

        assertEquals(false, valid.isValidSudoku(grid));
    }

    @Test
    void brokenBox() {
        char[][] grid = new char[9][9];
        grid[0] = new char[] {'5','3','.','.','7','.','.','.','.'};
        grid[1] = new char[] {'6','.','.','1','9','5','.','.','.'};
        grid[2] = new char[] {'.','9','8','.','.','.','.','6','.'};
        grid[3] = new char[] {'8','.','.','.','6','.','.','.','3'};
        grid[4] = new char[] {'4','.','.','8','.','3','.','.','1'};
        grid[5] = new char[] {'7','.','.','.','2','.','.','.','6'};
        grid[6] = new char[] {'.','6','.','.','.','.','2','8','.'};
        grid[7] = new char[] {'.','.','.','4','1','9','7','.','5'};
        grid[8] = new char[] {'.','.','.','.','8','.','.','7','9'};

        assertEquals(false, valid.isValidSudoku(grid));
    }

}