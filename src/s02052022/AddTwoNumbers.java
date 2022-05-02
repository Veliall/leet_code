package s02052022;

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        int temp = 0;
        int val = l1.val + l2.val;
        if (val < 10) {
            result.val = val;
        } else {
            result.val = val - 10;
            temp = 1;
        }
        recursiveSumChildren(l1.next, l2.next, temp, result);
        return result;
    }

    private void recursiveSumChildren(ListNode l1, ListNode l2, int temp, ListNode parent) {
        if (l1 == null && l2 == null && temp == 0) {
            return;
        }
        int val1 = l1 == null ? 0 : l1.val;
        int val2 = l2 == null ? 0 : l2.val;
        ListNode childNode = new ListNode();

        int val = val1 + val2 + temp;
        if (val < 10) {
            childNode.val = val;
            temp = 0;
        } else {
            childNode.val = val - 10;
            temp = 1;
        }
        parent.next = childNode;
        recursiveSumChildren(l1 == null ? null : l1.next, l2 == null ? null : l2.next, temp, childNode);
    }

    /**
     * Definition for singly-linked list.
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
