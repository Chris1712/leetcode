package personal.chris.leetcode.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListNodeTest {

    @Test
    void constructorSetsValOnly() {
        ListNode node = new ListNode(5);
        assertEquals(5, node.val);
        assertNull(node.next);
    }

    @Test
    void constructorSetsNext() {
        ListNode node = new ListNode(new int[]{1,2});
        assertEquals(1, node.val);
        assertEquals(2, node.next.val);
    }

    @Test
    void verifyNotSorted() {
        ListNode head = new ListNode(new int[]{1,2,3,4,3,4,5});
        assertFalse(head.isSorted());
    }

    @Test
    void verifyNotSorted2() {
        ListNode head = new ListNode(new int[]{11,2});
        assertFalse(head.isSorted());
    }

    @Test
    void verifySorted() {
        ListNode head = new ListNode(new int[]{1,2,3,4,4,5,9999999});
        assertTrue(head.isSorted());
    }

    @Test
    void verifySorted2() {
        ListNode head = new ListNode(new int[]{1});
        assertTrue(head.isSorted());
    }

    @Test
    void printSingle() {
        ListNode node = new ListNode(1);
        assertEquals("1", node.printList());
    }

    @Test
    void printMulti() {
        ListNode node = new ListNode(new int[]{55,66,1,2,7});
        assertEquals("55,66,1,2,7", node.printList());
    }

}