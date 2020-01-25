package personal.chris.leetcode;

import personal.chris.leetcode.util.ListNode;

public class ReverseNodes {

    /**
     * To solve <a href="https://leetcode.com/problems/reverse-nodes-in-k-group/">25. Reverse Nodes in k-Group</a>
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        // Do with recursion
        // Take first k in list, reverse them, pass rest to self, return pointer to new head (kth element)
        // Sadly this doesn't really use constant memory, so not an acceptable solution
        // We could just iterate through in chunks of k instead

        if (head == null || k == 1) {
            // Edge cases, *yawn*
            return head;
        }

        ListNode workingNode = head;

        // We need k nodes total, so count up k-1
        for (int i = 0; i < k-1; i++) {
            workingNode = workingNode.next;
            if (workingNode == null) {
                return head; // We've got less than k nodes in the list
            }
        }
        // We have a range from currentSubListHead -> endOfRange that needs reversing
        ListNode remainderHead = null;
        if (workingNode.next != null) {
            remainderHead = reverseKGroup(workingNode.next, k);
        }

        ListNode newHead = reverseRange(head, workingNode);
        head.next = remainderHead;
        return newHead;
    }

    /**
     *  Reverse the list between head and tail nodes, returning a reference to the new head
     * 1 -> 2 -> 3 -> 4    ->    4 -> 3 -> 2 -> 1
     * @param head
     * @param tail
     */
    public ListNode reverseRange(ListNode head, ListNode tail) {

        ListNode prevNode = head;
        ListNode currNode = head.next;

        head.next = null; // head is new tail
        while (currNode != null) {
            ListNode nextNode = currNode.next; // Remember the next node
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
            if (prevNode == tail) {
                return tail;
            }
        }
        return tail;
    }
}
