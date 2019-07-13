package 剑指offer;

import java.lang.reflect.Array;
import java.util.Arrays;

public class 调整数组顺序使奇数位于偶数前面 {
    public static void reOrderArray(int [] array) {
        if(array == null || array.length < 2)
            return;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] % 2 == 0 && array[j + 1] % 2 == 1) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j+1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        reOrderArray(arr);
        System.out.println(Arrays.toString(arr));

    }
}
