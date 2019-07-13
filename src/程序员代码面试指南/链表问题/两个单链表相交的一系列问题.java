package 程序员代码面试指南.链表问题;

public class 两个单链表相交的一系列问题 {


    //判断是否为环形链表，如果不是则返回 null，如果是，则返回环形的入口
    public static Node getLoop(Node head) {
        if(head == null || head.next == null || head.next.next == null)
            return null;
        Node slow  = head.next;
        Node fast = head.next.next;
        while (slow != fast) {
            if (fast.next == null || fast.next.next != null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        //寻找入口节点
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

    public static Node noLoop(Node head1, Node head2) {
        if(head1 == null || head2 == null)
            return null;
        Node n1 = head1;
        Node n2 = head2;
        int len1 = 1;
        int len2 = 1;
        while (n1.next != null) {
            n1 = n1.next;
            len1++;
        }
        while (n2.next != null) {
            n2 =  n2.next;
            len2++;
        }
        if (n1 != n2) {
            return null;
        }
        //让n1指向比较长的链表，n2指向比较短的链表
        n1 = len1 >= len2 ? head1 : head2;
        n2 = len1 < len2 ? head1 : head2;
        int n = Math.abs(len1 - len2);
        while (n > 0) {
            n1 = n1.next;
            n--;
        }
        while (n1 != n2) {
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1;
    }

    //如果有圈的话
    public static Node haveLoop(Node head1, Node loop1, Node head2, Node loop2) {
        Node n1 = null;
        Node n2 = null;
        if (loop1 == loop2) {
            n1 = head1;
            n2 = head2;
            int len1 = 0;
            int len2 = 0;
            while (n1 != loop1) {
                n1 = n1.next;
                len1++;
            }
            while (n2 != loop2) {
                n2 = n2.next;
                len2++;
            }
            n1 = len1 >= len2 ? head1 : head2;
            n2 = len1 < len2 ? head1 : head2;
            int n = Math.abs(len1 - len2);
            while (n > 0) {
                n1 = n1.next;
                n--;
            }
            while (n1 != n2) {
                n1 = n1.next;
                n2 = n2.next;
            }
            return n1;
        } else {
            n1 = loop1.next;
            while (n1 != loop1) {
                if (n1 == loop2) {
                    return n1;
                }
                n1 = n1.next;
            }
        }
        return null;
    }

    //整个代码
    public static Node getIntersectNode(Node head1, Node head2) {
        Node loop1 = getLoop(head1);
        Node loop2 = getLoop(head2);
        //都没有环
        if (loop1 == null && loop2 == null) {
            return noLoop(head1, head2);
        } else if (loop1 != null && loop2 != null) {
            return haveLoop(head1, loop1, head2, loop2);
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        Node[] nodes = new Node[8];
        for (int i = 0; i < 7; i++) {
            nodes[i] = new Node(i);
        }
        for (int i = 1; i < 7; i++) {
            nodes[i-1].next = nodes[i];
        }
        Node head1 = nodes[0];
        while (head1 != null) {
            System.out.println(head1.value);
            head1 = head1.next;
        }
        head1 = nodes[0];
        Node head2 = new Node(3);
        head2.next = nodes[3];

        System.out.println(getIntersectNode(head1, head2).value);
    }
}