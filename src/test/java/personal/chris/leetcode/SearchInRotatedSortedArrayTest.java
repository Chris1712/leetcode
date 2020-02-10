package personal.chris.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchInRotatedSortedArrayTest {

    @Nested
    class FindPivot {
        SearchInRotatedSortedArray search;

        @BeforeEach
        void setup() {
            search = new SearchInRotatedSortedArray();
        }

        @Test
        void pivotAtEnd() {
            int[] testArray = {2, 3, 4, 1};

            int result = search.findPivot(testArray, 0, testArray.length-1);

            assertEquals(2, result);
        }

        @Test
        void pivotInMiddle() {
            int[] testArray = {15, 21, 31, 41, 1, 2, 3};

            int result = search.findPivot(testArray, 0, testArray.length-1);

            assertEquals(3, result);
        }
    }


    @Nested
    class Search {
        SearchInRotatedSortedArray search;

        @BeforeEach
        void setup() {
            search = new SearchInRotatedSortedArray();
        }

        @Test
        void providedExample1() {
            int[] testArray = {4,5,6,7,0,1,2};

            int result = search.search(testArray, 0);

            assertEquals(4, result);
        }

        @Test
        void providedExample2() {
            int[] testArray = {4,5,6,7,0,1,2};

            int result = search.search(testArray, 3);

            assertEquals(-1, result);
        }

        @Test
        void length1Array() {
            int[] testArray = {1};

            int result = search.search(testArray, 0);

            assertEquals(-1, result);
        }

        @Test
        void length2Array() {
            int[] testArray = {1, 3};

            int result = search.search(testArray, 0);

            assertEquals(-1, result);
        }

        @Test
        void lameEdgeCase() {
            int[] testArray = new int[]{};

            int result = search.search(testArray, 5);

            assertEquals(0, testArray.length);
            assertEquals(-1, result);
        }
    }




}