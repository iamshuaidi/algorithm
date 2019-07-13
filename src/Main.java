import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

class Node{
    int date;
    Node next;

    public Node(int date) {
        this.date = date;
    }

    public static int solve(int n, int m) {
        if(m == 1 || n < 2)
            return n;
        // 创建环形链表

        Node head = createLinkedList(n);
        // 遍历删除
        int count = 1;
        Node cur = head;
        Node pre = null;//前驱节点
        while (head.next != head) {
            // 删除节点
            if (count == m) {
                count = 1;
                pre.next = cur.next;
                cur = pre.next;
            } else {
                count++;
                pre = cur;
                cur = cur.next;
            }
        }
        return head.date;
    }

    static Node createLinkedList(int n) {
        Node head = new Node(1);
        Node next = head;
        for (int i = 2; i <= n; i++) {
            Node tmp = new Node(i);
            next.next = tmp;
            next = next.next;
        }
        // 头尾串联
        next.next = head;
        return head;
    }
}

public class Main {

    public static int f(int[] arr) {
        if(arr.length < 1)
            return 0;
        int len = arr.length;
        int dp[] = new int[len + 1];
        dp[0] = 0;
        dp[1] = arr[0];

        for (int i = 1; i < len; i++) {
            if (arr[i] + dp[i - 1] > dp[i]) {
                dp[i + 1] = arr[i] + dp[i - 1];
            } else {
                dp[i+1] = dp[i];
            }
        }
        return dp[len];
    }

    public static void main(String[] args) {
        int arr[] = {2,20,10,5,6,8,9,4, 15, 3};
        System.out.println(Node.solve(6, 3));
    }
}