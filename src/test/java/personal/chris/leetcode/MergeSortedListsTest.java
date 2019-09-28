package personal.chris.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import personal.chris.leetcode.util.ListNode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MergeSortedListsTest {

    MergeSortedLists merge;

    @BeforeEach
    void setup() {
        merge = new MergeSortedLists();
    }

    @Test
    void singleListOneElement() {
        ListNode[] lists = new ListNode[]{
                new ListNode(1),
        };

        ListNode result = merge.mergeKLists(lists);

        assertTrue(result.isSorted());
    }

    @Test
    void singleListManyElements() {
        ListNode[] lists = new ListNode[]{
                new ListNode(new int[]{1,2,4,5,6}),
        };

        ListNode result = merge.mergeKLists(lists);

        assertTrue(result.isSorted());
    }

    @Test
    void twoLists() {
        ListNode[] lists = new ListNode[]{
                new ListNode(new int[]{1,2,3,4,4,5}),
                new ListNode(new int[]{5,6,7,8})
        };

        ListNode result = merge.mergeKLists(lists);

        assertTrue(result.isSorted());
    }

    @Test
    void addAtStart() {
        ListNode[] lists = new ListNode[]{
                new ListNode(new int[]{4,5}),
                new ListNode(new int[]{1,2})
        };

        ListNode result = merge.mergeKLists(lists);

        assertTrue(result.isSorted());
    }

    @Test
    void manyLists() {
        ListNode[] lists = new ListNode[]{
                new ListNode(new int[]{1,2,3}),
                new ListNode(new int[]{4}),
                new ListNode(new int[]{1,1,1,50}),
                new ListNode(new int[]{1,2,100,100}),
                new ListNode(new int[]{100,100,100,100}),
                new ListNode(new int[]{0})
        };

        ListNode result = merge.mergeKLists(lists);

        assertTrue(result.isSorted());
        assertEquals("0,1,1,1,1,1,2,2,3,4,50,100,100,100,100,100,100", result.printList());
    }

    @Test
    void tiresomeNullList() {
        ListNode[] lists = new ListNode[]{};

        ListNode result = merge.mergeKLists(lists);

        assertNull(result);
    }

    @Test
    void tiresomeNullLists() {
        ListNode[] lists = new ListNode[]{null, null};

        ListNode result = merge.mergeKLists(lists);

        assertNull(result);
    }

    @Test
    void tiresomeNullListThenRealList() {
        ListNode[] lists = new ListNode[]{null, new ListNode(new int[]{4})};

        ListNode result = merge.mergeKLists(lists);

        assertTrue(result.isSorted());
        assertEquals("4", result.printList());
    }

}