package 程序员代码面试指南.链表问题;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 删除重复出现的节点 {
    //方法1
    public static Node deleteRepNode(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node cur = head;
        Node next = head.next;
        while (next != null) {
            if (isRepeat(head, next)) {
                cur.next = next.next;
                next = cur.next;
            } else {
                cur = cur.next;
                next = cur.next;
            }
        }
        return head;
    }

    private static boolean isRepeat(Node head, Node next) {
        while (head != next) {
            if (head.value == next.value) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    //方法2：用哈希表
    public static Node deleteRepNodes2(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node cur = head;
        Node next = cur.next;
        Set<Integer> set = new HashSet<>();
        set.add(head.value);
        while (next != null) {
            if (set.contains(next.value)) {
                cur.next = next.next;
            } else {
                set.add(next.value);
                cur = cur.next;
            }
            next = cur.next;
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
        Node head = deleteRepNodes2(nodes[0]);
        while (head != null) {
            System.out.println(head.value);
            head = head.next;
        }
    }
}
