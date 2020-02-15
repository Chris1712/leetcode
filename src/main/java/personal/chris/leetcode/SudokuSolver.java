package personal.chris.leetcode;

import personal.chris.leetcode.util.TwoDimensionalArray;

/**
 * To solve <a href="https://leetcode.com/problems/valid-sudoku/>37. Sudoku Solver</a>
 * HARD
 * Times out but meh, optimising it is boring. Just make a smarter choice of recursions and don't clone, modify existing
 */
public class SudokuSolver {

    public void solveSudoku(char[][] board) {
        char[][] solution = solveSudokuRecurse(board);
        board = solution;
    }


    public char[][] solveSudokuRecurse(char[][] sudoku) {

        ValidSudoku checker = new ValidSudoku();

        if (!checker.isValidSudoku(sudoku)) {
            return null;
        }

        char[][] cloneSudoku = TwoDimensionalArray.deepClone(sudoku);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                if (cloneSudoku[i][j] == '.') {

                    for (int k = 1; k< 10; k++) {
                        cloneSudoku[i][j] = Integer.toString(k).charAt(0);
                        char[][] solved = solveSudokuRecurse(cloneSudoku);
                        if (solved != null) {
                            return solved;
                        }
                    }

                }

            }
        }

        return checker.isValidSudoku(cloneSudoku) ? sudoku : null;
    }

}
