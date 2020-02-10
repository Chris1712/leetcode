package personal.chris.leetcode;

/**
 * To solve <a href="https://leetcode.com/problems/search-in-rotated-sorted-array/">33. Search in Rotated Sorted Array</a>
 * MEDIUM
 */
public class SearchInRotatedSortedArray {

    /**
     * Needs to be O(log n).
     * nums is sorted but rotated at some pivot. And distinct
     */
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        } else if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }

        int pivot = findPivot(nums, 0, nums.length - 1);
        if (pivot == -1) {
            // dick move
            pivot = 0;
        }

        int lowSearch = binarySearch(nums, 0, pivot, target);
        if (lowSearch > -1) {
            return lowSearch;
        } else {
            return binarySearch(nums, pivot +1, nums.length - 1, target);
        }
    }

    /**
     * Return the index of the last element in the first ascending sequence
     * EG 5,6,7,1,2 returns 2
     */
    public int findPivot(int[] nums, int lowIndex, int highIndex) {
        if (nums[lowIndex] > nums[lowIndex+1]) {
            return lowIndex;
        } if (lowIndex + 1 == highIndex) {
            return -1;
        }

        int middle = (lowIndex + highIndex) / 2;

        if (nums[middle] > nums[nums.length - 1]) {
            return findPivot(nums, middle, highIndex);
        } else if (nums[middle] < nums[nums.length - 1]) {
            return findPivot(nums, lowIndex, middle);
        }
        return -1;
    }

    /**
     * Assumes array is sorted within range
     */
    public int binarySearch(int[] nums, int lowIndex, int highIndex, int target) {
        if (nums[lowIndex] == target) {
            return lowIndex;
        } if (nums[highIndex] == target) {
            return highIndex;
        } else if (lowIndex == highIndex || lowIndex + 1 == highIndex) {
            return -1;
        }

        int middle = (lowIndex + highIndex) / 2;
        if (nums[middle] > target) {
            return binarySearch(nums, lowIndex, middle, target);
        } else {
            return binarySearch(nums, middle, highIndex, target);
        }

    }
}
