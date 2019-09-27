package personal.chris.leetcode;

import personal.chris.leetcode.util.ListNode;

/**
 * To solve <a href="https://leetcode.com/problems/merge-k-sorted-lists/">23. Merge k Sorted Lists</a>
 */
public class MergeSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode sortedHead = lists[0];
        int i = 1; // the array we're merging into
        while (i < lists.length) {
            ListNode merged = sortedHead;
            ListNode add = lists[i];
            while (add != null) {
                if (add.val >= merged.val && (merged.next == null || add.val <= merged.next.val)) {
                    ListNode addNext = add.next;
                    addAfter(merged, add);
                    add = addNext;
                    merged = merged.next;
                } else {
                    merged = merged.next;
                }
            }
            i++;
        }
        return sortedHead;
    }

    /**
     * Change the successor for a node
     * @param first the node for which to change the successor
     * @param second the new successor
     */
    private void addAfter(ListNode first, ListNode second) {
        second.next = first.next;
        first.next = second;
    }

}
