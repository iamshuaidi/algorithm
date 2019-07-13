package 剑指offer;

import 程序员代码面试指南.链表问题.ReverseList;

import java.util.List;

//class ListNode{
//    int x;
//    ListNode next;
//    public ListNode(int x) {
//        this.x = x;
//    }
//}

public class 反转链表 {
    public static ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = ReverseList(head.next);
        ListNode temp = head.next;
        temp.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode listNode[] = new ListNode[5];
        for (int i = 0; i < 5; i++) {
            listNode[i] = new ListNode(i);
        }
        listNode[0].next = listNode[1];
        listNode[1].next = listNode[2];
        listNode[2].next = listNode[3];
        listNode[3].next = listNode[4];

        ListNode head = listNode[0];
        //进行反正
        head = ReverseList(head);
        //打印
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
