package personal.chris.leetcode.util;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) { val = x; }

    public ListNode(int[] vals) {
        this.val = vals[0];
        int i = 1;
        ListNode currentNode = this;
        while (i < vals.length) {
            currentNode.next = new ListNode(vals[i]);
            currentNode = currentNode.next;
            i++;
        }
    }

    public boolean isSorted() {
        ListNode node = this;
        while (node.next != null) {
            if (node.next.val < node.val) {
                return false;
            }
            node = node.next;
        }
        return true;
    }

    public String printList() {
        StringBuilder builder = new StringBuilder().append(val);
        ListNode node = this;
        while (node.next != null) {
            node = node.next;
            builder.append(',').append(node.val);
        }
        return builder.toString();
    }
}