package leetcode;

public class NO23 {

    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length < 1)
            return null;
        return divideSort(lists, 0, lists.length - 1);
    }

    private static ListNode divideSort(ListNode[] lists, int left, int right) {
        if (right == left) {
            return lists[left];
        } else {
            int center = left + (right - left) / 2;
            ListNode left_list = divideSort(lists, left, center);
            ListNode right_list = divideSort(lists, center + 1, right);
            ListNode result = mergeTowLists(left_list, right_list);
            return result;
        }
    }

    private static ListNode mergeTowLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 != null ? l1 : l2;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTowLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTowLists(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {

    }
}
