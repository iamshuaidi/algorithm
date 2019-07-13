package algorithms_fourth_edition.find.sort;

/**
 * 选择排序：
 * 1. 运行时间与输入无关
 * 2. 数据移动次数是最少的
 */
public class Selection {

    public static void sort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if(a[min] > a[j]) min = j;
            }
            //交换
            exchange(a, i, min);
        }
    }

    private static void exchange(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
