package 程序员代码面试指南.链表问题;

public class 约瑟夫问题 {
    //时间复杂度为O(n*m)的解决方法
    public static Node josephusKill(Node head, int m) {
        if(head == null || m < 1)
            return head;
        Node last = head;
        //定位到最后一个节点
        while (head.next != last) {
            head = head.next;
        }
        System.out.println(head.value);
        int count = 0;
        while (head.next != head) {
            if (++count == m) {
                head.next = head.next.next;
                count = 0;
            } else {
                head = head.next;
            }
        }
        return head;
    }

    //时间复杂度为O(n)
    public static Node josephusKill2(Node head, int m) {
        if(head == null || m < 1)
            return head;
        int n = 1;//统计一共有多少个节点
        Node last = head;
        while (last.next != head) {
            n++;
            last = last.next;
        }
        //直接用递归算出目的编号
        int des = getDes(n, m);
        //把目的节点取出来
        while (--des != 0) {
            head = head.next;
        }
        head.next = head;
        return head;
    }

    private static int getDes(int n, int m) {
        if (n == 1) {
            return 1;
        }
        return (getDes(n - 1, m) + m - 1) % n + 1;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node last = head;
        for (int i = 2; i <= 5; i++) {
            last.next = new Node(i);
            last = last.next;
        }
        last.next = head;
        Node result = josephusKill2(head, 1);
        System.out.println(result.value);
    }
}
