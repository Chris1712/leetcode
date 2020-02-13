package personal.chris.leetcode;

import java.rmi.UnexpectedException;

/**
 * To solve <a href="https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/>34. Find First and Last Position of Element in Sorted Array</a>
 * MEDIUM
 */
public class FirstAndLastInSortedArray {

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }

        return new int[] {lowerBound(nums, target, 0, nums.length-1), upperBound(nums, target, 0, nums.length-1)};
    }

    /**
     * Binary search to find lower position of range
     */
    public int lowerBound(int[] nums, int target, int lower, int upper) {
        int mid = (lower + upper) / 2; // we want mid to be the first target number

        if (mid == lower || lower == upper) {
            // Only one or two elements left
            if (nums[lower] == target) {
                return lower;
            } else if (nums[upper] == target) {
                return upper;
            } else {
                return -1;
            }
        } else if (nums[mid-1] < target && nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            return lowerBound(nums, target, mid, upper);
        } else if (nums[mid] >= target) {
            return lowerBound(nums, target, lower, mid);
        } else {
            throw new RuntimeException("Didn't think we'd end up here");
        }
    }

    /**
     * Binary search to return upper position of range
     */
    public int upperBound(int[] nums, int target, int lower, int upper) {
        int mid = (lower + upper) / 2; // we want mid to be the last target number

        if (mid == lower || lower == upper) {
            // Only one or two elements left
            if (nums[upper] == target) {
                return upper;
            } else if (nums[lower] == target) {
                return lower;
            } else {
                return -1;
            }
        } else if (nums[mid] == target && nums[mid+1] > target) {
            return mid;
        } else if (nums[mid] > target) {
            return upperBound(nums, target, lower, mid);
        } else if (nums[mid] <= target) {
            return upperBound(nums, target, mid, upper);
        } else {
            throw new RuntimeException("Didn't think we'd end up here");
        }
    }

}
