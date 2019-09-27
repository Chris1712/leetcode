package personal.chris.leetcode;

import personal.chris.leetcode.util.ListNode;

public class MergeSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode sortedHead = null;

        /**
         *  two approaches:
         *  1: take first list, traverse and merge next list, repeat
         *  If we have k lists of length l, expect to traverse ~ k^2 l / 2 nodes?
         *  (First list k-1 times, second list k-2 times, ..., last list 1 time)
         *  2: go through head of each list, pull out into new list. Seems messy and probably slower
         *  Presumably there's something better
         */


        /**
         * 8 lists
         *  4 merges, 4 left
         *  2 merges, 2 left
         *  1 merge, done = 7 merges
         *
         *  16 lists
         *  8 merges, 4 left
         *  4 merges, 4 left
         *  2 merges, 2 left
         *  1 merge, done = 15 merges
         */

        return sortedHead;
    }

}
