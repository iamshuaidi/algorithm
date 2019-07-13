package 程序员代码面试指南.其他问题;

import com.sun.org.apache.bcel.internal.generic.LoadClass;

public class 在两个长度相等的排序数组中找到上中位数 extends ClassLoader{
    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        return super.loadClass(name, resolve);
    }

    public static int getUpMedian(int[] arr1, int[] arr2) {
        if(arr1 == null || arr2 == null )
            return -1;
        // 开始寻找
        return find(arr1, 0, arr1.length - 1, arr2, 0, arr2.length - 1);
    }

    public static int find(int[] arr1, int l1, int r1, int[] arr2, int l2, int r2) {
        int mid1 = l1 + (r1 - l1) / 2;
        int mid2 = l2 + (r2 - l2) / 2;
        // 表示数组只剩下一个数，把两个数组中较小的数返回去
        if (l1 >= r1) {
            return Math.min(arr1[l1], arr2[l2]);
        }
        // 元素个数为奇数，则offset为0，为偶数则 offset 为 1
        int offset = ((r1 - l1 + 1) & 1) ^ 1;// 用位运算比较快
        if (arr1[mid1] < arr2[mid2]) {
            return find(arr1, mid1+offset, r1, arr2, l2, mid2);
        } else if (arr1[mid1] > arr2[mid2]) {
            return find(arr1, l1, mid1, arr2, mid2 + offset, r2);
        } else {
            return arr1[mid1];// 返回 arr2[mid2]也可以。
        }
    }



    // 迭代版本
    public int getUpMedian2(int[] arr1, int[] arr2) {
        if (arr1 == null || arr2 == null) {
            return -1;
        }
        int l1 = 0;
        int r1 = arr1.length - 1;
        int l2 = 0;
        int r2 = arr2.length - 1;
        int mid1 = 0;
        int mid2 = 0;
        int offset = 0;
        while (l1 < r1) {
            mid1 = l1 + (r1 - l1) / 2;
            mid2 = l2 + (r2 - l2) / 2;
            offset = ((r1 - l1 + 1) & 1)^1;
            if (arr1[mid1] < arr2[mid2]) {
                l1 = mid1 + offset;
                r2 = mid2;
            } else if (arr1[mid1] > arr2[mid2]) {
                r1 = mid1;
                l2 = mid2 + offset;
            } else {
                return arr2[mid1];
            }
        }
        return Math.min(arr1[l1], arr2[l2]);
    }

    public static void main(String[] args) {
        int[] arr1 = {1,2,5,};
        int[] arr2 = {3,4,5,};
        System.out.println(getUpMedian(arr1, arr2));
    }
}
