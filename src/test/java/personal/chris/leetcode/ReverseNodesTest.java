package personal.chris.leetcode;

import jdk.jfr.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import personal.chris.leetcode.util.ListNode;

import static org.junit.jupiter.api.Assertions.*;

class ReverseNodesTest {

    ReverseNodes reverse;

    @BeforeEach
    void setup() {
        reverse = new ReverseNodes();
    }

    @Test
    void example1() {
        ListNode list = new ListNode(new int[]{1,2,3,4,5});

        ListNode result = reverse.reverseKGroup(list, 2);

        assertEquals("2,1,4,3,5", result.printList());
    }

    @Test
    void example2() {
        ListNode list = new ListNode(new int[]{1,2,3,4,5});

        ListNode result = reverse.reverseKGroup(list, 3);

        assertEquals("3,2,1,4,5", result.printList());
    }

    @Test
    void listSizeEqualsOne() {
        ListNode list = new ListNode(new int[]{1,2,3,4,5});

        ListNode result = reverse.reverseKGroup(list, 1);

        assertEquals("1,2,3,4,5", result.printList());
    }

    @Test
    void nullList() {
        ListNode result = reverse.reverseKGroup(null, 3);

        assertNull(result);
    }

    @Nested
    class ReverseRange {

        @Test @Description("Reverse single node range")
        void oneNode() {
            ListNode list = new ListNode(new int[]{1});

            ListNode reversed = reverse.reverseRange(list, list);

            assertEquals(("1"), reversed.printList());
        }

        @Test @Description("Reverse 2 node range")
        void twoNodes() {
            ListNode list = new ListNode(new int[]{1, 3});

            ListNode reversed = reverse.reverseRange(list, list.next);

            assertEquals(("3,1"), reversed.printList());
        }

        @Test @Description("Reverse 2 nodes of 5 node range")
        void twoNodesFromRange() {
            ListNode list = new ListNode(new int[]{1,2,3,4,10});

            ListNode reversed = reverse.reverseRange(list, list.next);

            assertEquals(("2,1"), reversed.printList());
        }

        @Test @Description("Reverse 4 nodes of 5 node range")
        void threeNodesFromRange() {
            ListNode list = new ListNode(new int[]{1,2,3,4,10});

            ListNode reversed = reverse.reverseRange(list, list.next.next.next);

            assertEquals(("4,3,2,1"), reversed.printList());
        }

        @Test @Description("Reverse 5 nodes of 5 node range")
        void fiveNodesFromRange() {
            ListNode list = new ListNode(new int[]{1,2,3,4,10});

            ListNode reversed = reverse.reverseRange(list, list.next.next.next.next);

            assertEquals(("10,4,3,2,1"), reversed.printList());
        }

    }



}