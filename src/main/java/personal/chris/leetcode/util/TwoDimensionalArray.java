package personal.chris.leetcode.util;

public class TwoDimensionalArray {

    public static char[][] deepClone(char[][] input) {
        if (input == null) {
            return null;
        }
        if (input.length == 0) {
            return new char[][]{};
        }

        char[][] returnArray = new char[input.length][];

        for (int i = 0; i < input.length; i++) {

            if (input[i] == null) {
                returnArray[i] = null;
            } else {
                returnArray[i] = new char[input[i].length];

                for (int j = 0; j < input[i].length; j ++) {
                    returnArray[i][j] = input[i][j];
                }

            }
        }

        return returnArray;
    }

}
