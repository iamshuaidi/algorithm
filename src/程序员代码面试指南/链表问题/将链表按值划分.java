package 程序员代码面试指南.链表问题;

public class 将链表按值划分 {

    //用三个指针处理，这道题主要是要注意细节
    public static Node listPartition(Node head, int pivot) {
        Node sB = null;//小的指针头，即small begin
        Node sE = null;//小的指针尾，即 small end
        Node eB = null;//中的指针头，即 equal begin
        Node eE = null;//中的指针尾，即emall end
        Node bB = null;//大的指针头，即 big begin
        Node bE = null;//大的指针尾，即 big end
        Node next = null;//保存下一个节点
        //进行划分
        while (head != null) {
            next = head.next;
            head.next = null;
            if (head.value < pivot) {
                if (sB == null) {
                    sB = head;
                    sE = head;
                } else {
                    sE.next = head;
                    sE = sE.next;
                }
            } else if (head.value == pivot) {
                if (eB == null) {
                    eB = head;
                    eE = head;
                } else {
                    eE.next = head;
                    eE = eE.next;
                }
            } else {
                if (bB == null) {
                    bB = head;
                    bE = head;
                } else {
                    bE.next = head;
                    bE = bE.next;
                }
            }
            head = next;
        }
        //把三部分串连起来，串联的时候细节还是挺多的，
        //串联的过程下面代码的精简程度是最学习的部分了

        //1.小的与中的串联
        if (sB != null) {
            sE.next = eB;
            eE = eE == null ? sE : eE;
        }
        //2.中的和大的连接
        if (eB != null) {
            eE.next = bB;
        }
        return sB != null ? sB : eB != null ? eB : bB;
    }
}
