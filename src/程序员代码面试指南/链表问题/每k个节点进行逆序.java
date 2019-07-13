package 程序员代码面试指南.链表问题;

@SuppressWarnings("all")
public class 每k个节点进行逆序 {

    //单链表逆序
    public static Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node newHead = reverse(head.next);
        head.next.next =  head;
        head.next = null;
        return newHead;
    }

    //每k个节点为一组的逆转
    public static Node reverseKNodes(Node head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        Node cur = head;
        for (int i = 1; cur != null && i < k; i++) {
            cur = cur.next;
        }
        //判断是否能组成一组。
        if (cur == null) {
            return head;
        }
        //temp指向剩余的链表
        Node temp = cur.next;
        cur.next = null;
        //把k个节点进行反转
        Node newHead = reverse(head);
        //把之后的部分链表进行每K个节点逆转转
        Node newTemp = reverseKNodes(temp, k);
        //把两部分节点连接起来
        return newHead;
    }
}
