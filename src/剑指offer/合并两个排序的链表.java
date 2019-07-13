package 剑指offer;

public class 合并两个排序的链表 {
    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1 == null || list2 == null)
            return list1 == null ? list2 : list1;

        ListNode head = null;
        if (list1.val < list2.val) {
            head = list1;
            list1 = list1.next;
        } else {
            head = list2;
            list2 = list2.next;
        }
        ListNode temp = head;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }
        temp.next = list1 == null ? list2 : list1;
        return head;
    }
}
