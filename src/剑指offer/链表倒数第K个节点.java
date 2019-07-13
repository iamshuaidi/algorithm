package 剑指offer;

import java.util.List;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class 链表倒数第K个节点 {
    public ListNode FindKthToTail(ListNode head,int k) {
        if(head == null | k < 1)
            return null;
        ListNode cur = head;
        ListNode fast = head;
        while (k > 1) {
            fast = fast.next;
            k--;
        }
        if (fast == null) return null;
        fast = fast.next;
        while (fast != null) {
            fast = fast.next;
            cur = cur.next;
        }
        return cur;
    }
}
