package personal.chris.leetcode;

/**
 * To solve <a href="https://leetcode.com/problems/trapping-rain-water/">42. Trapping Rain Water</a>
 * HARD
 */
public class TrappingRainWater {

    public int trap(int[] height) {

        int water = 0; // count of water filled in

        int wall = -1; // position of current wall
        int dip = -1; // height of lowest section since wall

        int i = 0;
        while (i < height.length) {

            if (wall == -1) {
                // If we have no current wall
                if (height[i] > 0)
                    wall = i;

            } else {
                // We have a wall before the current position.
                if (height[i] < height[wall] && (height[i] < dip || dip == -1)) {
;                   // Nadir, set dip to this!
                    dip = height[i];
                } else if (height[i] > dip && dip >= 0) {
                    // We have a dip lower than this. So fill in everything in between with water, and go back to the wall

                    int fillUpTo = height[wall] < height[i] ? height[wall] : height[i]; // min of wall and current
                    for (int j = wall+1; j < i; j++) {
                        if (height[j] < fillUpTo) {
                            water += fillUpTo - height[j];
                            height[j] = fillUpTo;
                        }
                    }
                    i = wall;
                    dip = -1;
                    continue;


                } else if (height[i] >= height[wall] && dip == -1) {
                    wall = i;
                }
            }

            i++;
        }

        return water;
    }

}
