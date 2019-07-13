package leetcode;

import java.util.Stack;

class ListNode2 {
      int val;
      ListNode2 next;
      ListNode2(int x) { val = x; }
 }

public class NO19 {
    public static ListNode2 removeNthFromEnd(ListNode2 head, int n) {
        ListNode2 temp = head;
        int sum = 1;
        //求一个有多少个节点
        while (temp.next != null) {
            sum++;
            temp = temp.next;
        }
        //排除这种删除头节点的情况
        if (sum == n ) {
            head = head.next;
        } else if(n >= 1) {
            temp = head;
            for (int i = 1; i < sum - n; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
        }
        return head;
    }



    public static void main(String[] args) {
    }
}
