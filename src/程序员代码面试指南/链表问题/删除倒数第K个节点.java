package 程序员代码面试指南.链表问题;

//节点
class Node{
    public int value;
    public Node next;
    public Node(int data) {
        this.value = data;
    }
}
public class 删除倒数第K个节点 {

    //删除单链表倒数第 K 个节点
    public Node removeLastKthNode(Node head, int K) {
        if(head == null || K < 1)
            return head;
        Node temp = head;
        int num = 0;
        while (temp != null) {
            num++;
            temp = temp.next;
        }
        if (num == K) {
            return head.next;
        }
        if (num > K) {
            temp = head;
            //删除第(num-k+1)个节点
            //定位到这个点的前驱
            while (num - K != 0) {
                temp = temp.next;
                num--;
            }
            temp.next = temp.next.next;
        }
        return head;
    }
}
