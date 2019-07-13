package leetcode;

public class NO24 {
    public ListNode swapPairs(ListNode head) {
        ListNode result = new ListNode(0);
        ListNode pre = result;
        result.next = head;


        while (pre.next != null && pre.next.next != null) {
            ListNode temp = pre.next;
            pre.next = temp.next;
            temp.next = pre.next.next;
            pre.next.next = temp;
            pre = temp;
        }

        return result.next;
    }
}
