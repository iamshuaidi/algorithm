package 程序员代码面试指南.链表问题;

public class 按照左右分区重新组合链表 {

    public static Node reBuilderList(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        Node slow = head;
        Node fast = head.next;
        //最后slow指向第 n / 2 个节点
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node left = head;
        Node right = slow.next;
        slow.next = null;
        Node lNext = null;
        Node rNext = null;
        while (left != null) {
            lNext = left.next;
            rNext = right.next;
            //把右边的节点插进去
            left.next = right;
            right.next = lNext;

            left = lNext;
            right = left == null ? right : rNext;
        }
        right.next = rNext;

        return head;
    }

    public static void main(String[] args) {
        Node[] nodes = new Node[8];
        for (int i = 0; i < 7; i++) {
            nodes[i] = new Node(i);
        }
        for (int i = 1; i < 5; i++) {
            nodes[i - 1].next = nodes[i];
        }
        Node head = reBuilderList(nodes[0]);
        while (head != null) {
            System.out.println(head.value);
            head = head.next;
        }
    }
}
