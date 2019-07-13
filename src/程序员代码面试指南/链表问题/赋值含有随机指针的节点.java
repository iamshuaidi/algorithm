package 程序员代码面试指南.链表问题;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Node1{
    public int value;
    public Node1 next;
    public Node1 rand;

    public Node1(int value) {
        this.value = value;
    }
}

public class 赋值含有随机指针的节点 {

    //方法1：采用哈希表
    public static Node1 copyListWithRand(Node1 head) {
        Map<Node1, Node1> map = new HashMap<>();
        Node1 cur = head;
        while (cur != null) {
            map.put(cur, new Node1(cur.value));
            cur = cur.next;
        }
        //把副节点连接起来
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).rand = map.get(cur.rand);
            cur = cur.next;
        }
        return map.get(head);
    }
    //方法二
    public static Node1 copyListWithRand2(Node1 head){
        Node1 cur = head;
        Node1 next = null;

        //把复制的节点插进去
        while (cur != null) {
            next = cur.next;
            Node1 temp = new Node1(cur.value);//复制节点
            temp.next = cur.next;
            cur.next = temp;
            cur = next;
        }
        //在一边把复制的节点取出来一边连接。
        cur = head;
        next = null;
        while (cur != null) {
            next = cur.next.next;//保存原链表的下一个节点
            cur.next.next = next != null ? next.next : null;
            cur.next.rand = cur.rand != null ? cur.rand.next : null;
            cur = next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        Node1 node1 = new Node1(1);
        Node1 node2 = new Node1(2);
        Node1 node3 = new Node1(3);

        node1.next = node2;
        node2.next = node3;

        node1.rand = node3;
        node2.rand = node3;
        node3.rand = node1;

        Node1 res = copyListWithRand2(node1);

        while (res != null) {
            System.out.println(res.value + ":" +res.rand.value );
           // System.out.println();
            res = res.next;
        }
    }
}
