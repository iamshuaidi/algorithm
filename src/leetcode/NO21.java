package leetcode;
import java.util.List;

 class ListNode3 {
      int val;
      ListNode3 next;
      ListNode3(int x) { val = x; }
  }

class Solution {
    public ListNode3 mergeTwoLists(ListNode3 l1, ListNode3 l2) {
        if (l1 == null || l2 == null) {
            return l1 != null ? l1 : l2;
        }
        ListNode3 head = null;
        ListNode3 temp = null;
        if (l1.val > l2.val) {
            temp = head = l2;
            l2 = l2.next;
        } else {
            temp = head = l1;
            l1 = l1.next;
        }

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                    temp.next = l1;
                    l1 = l1.next;
                    temp = temp.next;
            } else {
                    temp.next = l2;
                    l2 = l2.next;
                    temp = temp.next;
                }
            }
        temp.next = l1 != null? l1 : l2;
        return head;
    }

    //递归的方式解
    public ListNode3 mergeTwoLists2(ListNode3 l1, ListNode3 l2) {
        if (l1 == null || l2 == null) {
            return l1 != null?l1 : l2;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }
    }

}
