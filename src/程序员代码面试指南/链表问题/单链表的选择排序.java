package 程序员代码面试指南.链表问题;

public class 单链表的选择排序 {
    public static Node sortList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node cur = head.next;
        head.next = null;
        Node next = null;
        Node temp = null;
        Node help = new Node(0);
        help.next = head;
        Node pre = null;
        for (int i = 1; cur != null; i++) {
            next = cur.next;
            cur.next = null;
            pre = help;
            temp = pre.next;
            for (int j = 0; j < i; j++) {
                if (temp.value > cur.value) {
                    pre.next = cur;
                    cur.next = temp;
                    break;
                } else {
                    if (j == i - 1) {
                        temp.next = cur;
                    } else {
                        pre = temp;
                        temp = temp.next;
                    }
                }
            }
            cur = next;
        }
        return help.next;
    }

    public static Node selectSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node tai = null;//排序部分的尾部
        Node small = null;
        Node smallPre = null;
        Node newHead = null;//排序部分的头部
        Node cur = head;

        while (cur != null) {
            smallPre = getSmallNode(cur);
            //把最小节点从原链表中删除
            if (smallPre != null) {
                small = smallPre.next;
                smallPre.next = small.next;
            }else{
                small = cur;
                cur = cur.next;
            }
            small.next = null;

            if (tai == null) {
                newHead = small;
            } else {
                tai.next = small;
            }
            tai = small;
        }
        return newHead;
    }

    //获取最小值节点，并删除该节点
    public static Node getSmallNode(Node head) {
        Node smallPre = null;
        Node small = head;
        Node pre = head;
        Node cur = head.next;
        while (cur != null) {
            if (cur.value < small.value) {
                small = cur;
                smallPre = pre;
            }
            pre = cur;
            cur = cur.next;
        }
        return smallPre;
    }

    public static void main(String[] args) {
        Node[] nodes = new Node[8];
        for (int i = 0; i < 7; i++) {
            nodes[i] = new Node((int)(100 * Math.random()));
            System.out.println(nodes[i].value);
        }
        System.out.println("------------");
        for (int i = 1; i < 7; i++) {
            nodes[i - 1].next = nodes[i];
        }
        Node head = sortList(nodes[0]);
        while (head != null) {
            System.out.println(head.value);
            head = head.next;
        }
    }
}
