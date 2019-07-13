package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NO4_median_of_tow_sorted_arrays {
    // 由于中位数会受长度是奇偶数的影响，所以我们可以把问题转化为求
    // (（n+m+1)/2+(n+m+2)/2)/2。
    public double findMedianSortedArrays(int[] arr1, int[] arr2) {
        List<Integer> list = new ArrayList<>();
        Arrays.asList(1, 2);
        int n = arr1.length;
        int m = arr2.length;
        return (findKth(arr1, arr2,(n+m+1)/2) + findKth(arr1,arr2,(n+m+2)/2)) /2;
    }

    public static int findKth(int[] arr1, int[] arr2, int k) {
        if(arr1 == null || arr1.length < 1)
            return arr2[k-1];
        if(arr2 == null || arr2.length < 1)
            return arr1[k-1];
        // 注意这个函数的参数有7个，上面那个函数的参数只有3个，同名不同函数哈
        return findKth(arr1, 0, arr1.length - 1, arr2, 0, arr2.length - 1, k);
    }

    public static int findKth(int[] arr1, int l1, int r1, int[] arr2, int l2, int r2, int k) {
        // 递归结束条件
        if(l1 > r1)
            return arr2[l2 + k - 1];
        if(l2 > r2)
            return arr1[l1 + k - 1];
        if (k <= 1)// 注意，k == 0的结束条件与上面两个结束条件不能颠倒。
            return Math.min(arr1[l1],arr2[l2]);
        int md1 = l1 + k/2 - 1 <= r1 ? l1 + k/2 - 1: r1;
        int md2 = l2 + k/2  - 1 <= r2 ? l2 + k/2 - 1: r2;
        if(arr1[md1] < arr2[md2])
            return findKth(arr1, md1 + 1, r1, arr2, l2, r2, k - (md1-l1+1));
        else
            return findKth(arr1, l1, r1, arr2, md2 + 1, r2, k - (md2-l2+1));
    }

    // 测试
    public static void main(String[] args) {
        int[] arr1 = {1,};
        int[] arr2 = {2, 3, 4, 5, 6};
        System.out.println(findKth(arr1, arr2, 3));
        System.out.println(findKth(arr1, arr2, 4));
    }







}
