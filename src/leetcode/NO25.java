package leetcode;

public class NO25 {

    //逆序单链表
    private static ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode result = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return result;
    }

    //k个为一组逆序
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        for (int i = 1; i < k && temp != null; i++) {
            temp = temp.next;
        }
        //判断节点的数量是否能够凑成一组
        if(temp == null)
            return head;

        ListNode t2 = temp.next;
        temp.next = null;
        //把当前的组进行逆序
        ListNode result = reverseList(head);
        //把之后的节点进行分组逆序
        head.next = reverseKGroup(t2, k);

        return result;
    }


    //k节点交换
    public ListNode reverseKGroup2(ListNode head, int k) {
        if(k <= 1)
            return head;
        ListNode restlt = new ListNode(0);
        restlt.next = head;
        //t1作为t2节点的前驱，t3作为t4节点的前去
        ListNode t1, t2, t3, t4,temp;
        t1 = t2 = t3 = t4 = restlt;

        while (t2.next != null) {
            t1 = t2;
            t2 = t2.next;
            for (int i = 1; i <= k; i++) {
                t3 = t4;
                t4 = t4.next;
                if(t4 == null)
                    return restlt.next;
            }
            //进行交换
            t1.next = t4;
            t3.next = t2;
            temp = t2.next;
            t2.next = t4.next;
            t4.next = temp;
            t4 = t2;
        }
        return restlt.next;
    }
}
