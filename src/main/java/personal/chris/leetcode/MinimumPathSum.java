package personal.chris.leetcode;

/**
 * To solve <a href="https://leetcode.com/problems/minimum-path-sum/description/">64. Minimum Path Sum</a>
 * MEDIUM
 */
public class MinimumPathSum {

    public int minPathSum(int[][] grid) {
        // loop through the grid to identify the cheapest path to each point, using the computed cheapest points so far
        int[][] minPaths = new int[grid.length][grid[0].length];

        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[0].length; x++) {
                if (y == 0) {
                    // Special behaviour for first row
                    if (x == 0) {
                        minPaths[y][x] = grid[y][x]; // upper left min path is just upper left from grid
                    } else {
                        minPaths[y][x] = minPaths[y][x-1] + grid[y][x];
                    }
                } else {
                    // We are on at least the second row
                    if (x == 0) {
                        minPaths[y][x] = minPaths[y-1][x] + grid[y][x];
                    } else {
                        // Pick between getting here from above or from left
                        minPaths[y][x] = Math.min(minPaths[y-1][x], minPaths[y][x-1]) + grid[y][x];
                    }
                }
            }
        }

        return minPaths[minPaths.length-1][minPaths[0].length-1];
    }

}
