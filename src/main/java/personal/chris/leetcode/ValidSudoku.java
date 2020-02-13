package personal.chris.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * To solve <a href="https://leetcode.com/problems/valid-sudoku/>36. Valid Sudoku</a>
 * MEDIUM
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {

        for (int i = 0; i < 9; i++) {

            if (!isValidRow(i, board) || !isValidCol(i, board) || !isValidBox(i, board)) {
                return false;
            }
        }

        return true;
    }

    private boolean isValidRow(int i, char[][] board) {
        UniqueChecker uniq = new UniqueChecker();

        for (int j = 0; j < 9; j++) {
            char element = board[i][j];
            if (!uniq.tryAdd(element)) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidCol(int i, char[][] board) {
        UniqueChecker uniq = new UniqueChecker();

        for (int j = 0; j < 9; j++) {
            char element = board[j][i];
            if (!uniq.tryAdd(element)) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidBox(int i, char[][] board) {
        UniqueChecker uniq = new UniqueChecker();

        int hOffSet = 3* (i % 3);
        int vOffSet = 3* (i / 3);

        for (int j = 0; j < 9; j++) {
            char element = board[hOffSet + j%3][vOffSet + j/3];
            if (!uniq.tryAdd(element)) {
                return false;
            }
        }
        return true;
    }
}

class UniqueChecker {

    private Set<Character> chars = new HashSet<Character>();
    private List<Character> validChars = Arrays.asList('1', '2', '3', '4', '5', '6', '7', '8', '9');

    public boolean tryAdd(char element) {
        if (element == '.') {
            return true; // empty, that's fine
        } else if (!validChars.contains(element)) {
            return false; // invalid char
        } else {
            return chars.add(element);
        }

    }

}
