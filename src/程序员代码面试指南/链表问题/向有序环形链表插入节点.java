package 程序员代码面试指南.链表问题;

public class 向有序环形链表插入节点 {

    public static Node insertNode(Node head, int num) {
        Node temp = new Node(num);
        if (head == null) {
            temp.next = temp;
            return temp;
        }
        Node pre = head;
        Node cur = head.next;
        while (cur != head) {
            if (cur.value >= num && num >= pre.value) {
                break;
            }
            pre = cur;
            cur = cur.next;
        }
        pre.next = temp;
        temp.next = cur;
        return head.value > temp.value ? head : temp;
    }
}
