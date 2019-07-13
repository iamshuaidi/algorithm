package 程序员代码面试指南.链表问题;

public class ReverseList {

    //反转单链表
    public static Node reverseList(Node head) {
        Node next = null;//指向当前节点的后驱
        Node pre = null;//指向当前节点的前驱
        while (head != null) {
            next = head.next;
            //当前节点的后驱指向前驱
            head.next = pre;
            pre = head;
            //处理下一个节点
            head = next;
        }
        return pre;
    }

    //用递归的方法反转链表
    public static Node reverseList2(Node head){
        if (head == null || head.next == null) {
            return head;
        }
        //递归反转子lian链表
        Node newList = reverseList2(head.next);
        //第三张图
        head.next.next = head;
        head.next = null;
        return newList;
    }

    public static Node reversePart(Node head, int from, int to) {
        int len = 0;//记录链表的长度
        Node node1 = head;
        Node fPre = null;//指向第 from-1个节点
        Node tPos = null;//指向第 to + 1个节点
        while (node1 != null) {
            len++;
            if(len == from - 1)
                fPre = node1;
            if(len == to + 1)
                tPos = node1;
            node1 = node1.next;
        }
        //判断给定的值是否合理
        if(from > to || from < 1 || to > len)
            return head;
        //把from-to这部分链表进行反转
        //node1指向部分链表的第一个节点
        node1 = fPre == null ? head : fPre.next;
        Node cur = node1.next;//cur指向当前要处理的节点
        node1.next = tPos;//先把第一个节点给反转处理了
        Node next = null;
        while (cur != tPos) {
            next = cur.next;//保存当前节点的下一个节点
            cur.next = node1;
            node1 = cur;
            cur = next;
        }
        if (fPre != null) {
            fPre.next = node1;
            return head;
        }
        return node1;
    }
}
