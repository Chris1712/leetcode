package personal.chris.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SudokuSolverTest {

    static SudokuSolver solver;

    @BeforeAll
    static void setup() {
        solver = new SudokuSolver();
    }

    @Test
    void example1() {
        char[][] gridToSolve = new char[9][9];

        gridToSolve[0] = new char[] {'5','3','.','.','7','.','.','.','.'};
        gridToSolve[1] = new char[] {'6','.','.','1','9','5','.','.','.'};
        gridToSolve[2] = new char[] {'.','9','8','.','.','.','.','6','.'};
        gridToSolve[3] = new char[] {'8','.','.','.','6','.','.','.','3'};
        gridToSolve[4] = new char[] {'4','.','.','8','.','3','.','.','1'};
        gridToSolve[5] = new char[] {'7','.','.','.','2','.','.','.','6'};
        gridToSolve[6] = new char[] {'.','6','.','.','.','.','2','8','.'};
        gridToSolve[7] = new char[] {'.','.','.','4','1','9','.','.','5'};
        gridToSolve[8] = new char[] {'.','.','.','.','8','.','.','7','9'};

        char[][] solvedGrid = new char[9][9];

        solvedGrid[0] = new char[] {'5','3','4','6','7','8','9','1','2'};
        solvedGrid[1] = new char[] {'6','7','2','1','9','5','3','4','8'};
        solvedGrid[2] = new char[] {'1','9','8','3','4','2','5','6','7'};
        solvedGrid[3] = new char[] {'8','5','9','7','6','1','4','2','3'};
        solvedGrid[4] = new char[] {'4','2','6','8','5','3','7','9','1'};
        solvedGrid[5] = new char[] {'7','1','3','9','2','4','8','5','6'};
        solvedGrid[6] = new char[] {'9','6','1','5','3','7','2','8','4'};
        solvedGrid[7] = new char[] {'2','8','7','4','1','9','6','3','5'};
        solvedGrid[8] = new char[] {'3','4','5','2','8','6','1','7','9'};

        assertArrayEquals(solvedGrid, solver.solveSudokuRecurse(gridToSolve));
    }
}