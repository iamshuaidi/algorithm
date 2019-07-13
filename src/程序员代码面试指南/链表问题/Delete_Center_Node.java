package 程序员代码面试指南.链表问题;

public class Delete_Center_Node {

    public static Node removeMidNode(Node head) {
        if(head == null || head.next == null)
            return head;
        if (head.next.next == null) {
            return head.next;
        }
        Node fast = head.next.next;//快指针
        Node slow = head;//慢指针

        //slow最终指向中间节点的前驱
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //进行删除
        slow.next = slow.next.next;
        return head;
    }

    //这道题可以转换为删除第 K = (a * n / b)个节点。其中n表示链表节点
    //的个数，但由于(a * n / b)有可能出现小数，所以我们取 K的上限。
    //所谓上限就是大于等于K的最小整数。
    public static Node removeByRatio(Node head, int a, int b) {
        if(a < 1 || a > b)
            return head;
        int n = 0;
        Node cur = head;
        //统计一共有多少个节点
        while (cur != null)
            n++;
        //问题转换为删除第K个节点,取(a * n / b)的整数上限
        int K =  (int)Math.ceil((double)(a * n) / (double)b);
        if(K == 1)
            return head.next;
        if (K > 1) {
            cur = head;
            //定位到第K个节点的前驱
            while (--K != 1) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return head;
    }
}
