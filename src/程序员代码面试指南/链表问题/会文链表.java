package 程序员代码面试指南.链表问题;

import java.util.Stack;

public class 会文链表 {

    //方法1
    public static boolean f1(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Node temp = head;
        Stack<Node> stack = new Stack<>();
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        while (!stack.isEmpty()) {
            Node t = stack.pop();
            if (t.value != head.value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    //方法2
    public static boolean f(Node head) {
        if(head == null || head.next == null)
            return true;
        Node slow = head;//慢指针
        Node fast = head;//快指针
        Stack<Node> stack = new Stack<>();
        //slow最终指向中间节点
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println(slow.value);
        slow = slow.next;
        while (slow != null) {
            stack.push(slow);
            slow = slow.next;
        }
        //进行判断
        while (!stack.isEmpty()) {
            Node temp = stack.pop();
            if (head.value != temp.value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    //方法3
    public static boolean f2(Node head) {
        if(head == null || head.next == null)
            return true;
        Node slow = head;//慢指针
        Node fast = head;//快指针
        //slow最终指向中间节点
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node revHead = reverse(slow.next);//反转后半部分
        //进行比较
        while (revHead != null) {
            System.out.println(revHead.value);
            if (revHead.value != head.value) {
                return false;
            }
            head = head.next;
            revHead = revHead.next;
        }
        return true;
    }
    //反转链表
    private static Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(2);
        Node d = new Node(1);

        a.next = b;
        b.next = c;
        c.next = d;
        System.out.println(f2(a));
    }
}
