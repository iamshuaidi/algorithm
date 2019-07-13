package 程序员代码面试指南.链表问题;

import java.util.LinkedList;
import java.util.Queue;

class Node2{
    public int value;
    public Node2 left;
    public Node2 right;

    public Node2(int value) {
        this.value = value;
    }
}

public class 将搜索二叉树转换成双向链表 {

    public static Node2 conver(Node2 head) {
        if (head == null) {
            return head;
        }
        Node2 leftE = conver(head.left);
        Node2 rightE = conver(head.right);
        Node2 leftB = leftE != null ? leftE.right : null;
        Node2 rightB = rightE != null ? rightE.right : null;
        if (leftE != null && rightE != null) {
            leftE.right = head;
            head.left = leftE;
            head.right = rightB;
            rightB.left = head;
            rightE.right = leftB;
            return rightE;
        } else if (leftE != null) {
            leftE.right = head;
            head.left = leftE;
            head.right = leftB;
            return head;
        } else if (rightE != null) {
            head.right = rightB;
            rightB.left = head;
            rightE.right = head;
            return rightE;
        } else {
            head.right = head;
            return head;
        }
    }

    public static Node2 convert1(Node2 head) {
        Queue<Node2> queue = new LinkedList<>();
        //将节点按中序遍历放进队列里
        inOrderToQueue(head, queue);
        head = queue.poll();
        Node2 pre = head;
        pre.left = null;
        Node2 cur = null;
        while (!queue.isEmpty()) {
            cur = queue.poll();
            pre.right = cur;
            cur.left = pre;
            pre = cur;
        }
        pre.right = null;
        return head;
    }

    private static void inOrderToQueue(Node2 head, Queue<Node2> queue) {
        if (head == null) {
            return;
        }
        inOrderToQueue(head.left, queue);
        queue.offer(head);
        inOrderToQueue(head.right, queue);
    }
}

