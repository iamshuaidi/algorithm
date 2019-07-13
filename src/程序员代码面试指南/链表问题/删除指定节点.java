package 程序员代码面试指南.链表问题;

public class 删除指定节点 {

    public static Node deleteNode(Node head, int num) {
        while (head != null && head.value == num) {
            head = head.next;
        }
        if (head == null) {
            return head;
        }
        Node pre = head;
        Node cur = head.next;
        while (cur != null) {
            if (cur.value == num) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = pre.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Node[] nodes = new Node[8];
        for (int i = 0; i < 7; i++) {
            nodes[i] = new Node(i % 4);
        }
        for (int i = 1; i < 7; i++) {
            nodes[i - 1].next = nodes[i];
        }
        Node head = deleteNode(nodes[0], 3);
        while (head != null) {
            System.out.println(head.value);
            head = head.next;
        }
    }
}
