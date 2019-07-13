package 剑指offer;

import java.util.HashMap;
import java.util.Map;

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
public class 复杂链表的复制 {
    // 采用哈希表
    public static RandomListNode Clone(RandomListNode pHead) {
        Map<RandomListNode,RandomListNode> map = new HashMap<>();
        RandomListNode cur = pHead;
        while (cur != null) {
            map.put(cur,new RandomListNode(cur.label));
            cur = cur.next;
        }
        cur = pHead;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(pHead);
    }
    // 通过指针
    public static RandomListNode Clone1(RandomListNode pHead) {
        if(pHead == null)
            return null;

        RandomListNode cur = pHead;
        RandomListNode tmp = null;
        RandomListNode next = null;
        while (cur != null) {
            tmp = new RandomListNode(cur.label);
            tmp.next = cur.next;
            cur.next = tmp;
            cur = tmp.next;
        }
        // 开始取出来拼接
        cur = pHead;

        while (cur != null) {
            next = cur.next.next;
//            cur.next.next = next != null ? next.next : null;
            cur.next.random = cur.random != null ? cur.random.next : null;
//            tmp = cur.next;
//            tmp.random = cur.random != null ? cur.random.next : null;
            cur = next;
        }
        RandomListNode res = pHead.next;
        cur = pHead;
        while (cur != null) {
            next = cur.next.next;
            //cur.next.next = next != null ? next.next :null;
            tmp = cur.next;
            cur.next = next;
            tmp.next = next != null ? next.next : null;
            cur = next;
        }
        return res;
    }

    public static void main(String[] args) {
        RandomListNode node1 = new RandomListNode(1);
        RandomListNode node2 = new RandomListNode(2);
        RandomListNode node3 = new RandomListNode(3);

        node1.next = node2;
        node2.next = node3;

        node1.random = node3;
        node2.random = node2;
        node3.random = node1;

        RandomListNode res = Clone(node1);

        while (res != null && node1 != null) {
            if(res != node1)
            System.out.println(res.label + ":" +res.random.label );
            // System.out.println();
            res = res.next;
            node1 = node2.next;
        }
    }
}
