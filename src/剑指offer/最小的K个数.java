package 剑指offer;

import java.util.ArrayList;

public class 最小的K个数 {

    // 通过构建最小堆来实现
    static public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if(input == null || input.length < 1 || k < 1 || k > input.length)
            return list;
        // 构建堆
        int n = input.length - 1;
        for (int i = (n - 1) / 2; i >= 0; i--) {
            down(input, i, n);
        }
        for (int i = 0; i < k; i++) {
            int t = input[0];
            input[0] = input[n - i];
            input[n - i] = t;
            down(input, 0, n - i - 1);
        }
        for (int i = 0; i < k; i++) {
            list.add(input[n - i]);
        }
        return list;
    }

    static private void down(int[] input, int parent, int n) {
        int child = parent * 2 + 1;
        int tmp = input[parent];
        while (child <= n) {
            // 定位到右孩子
            if (child + 1 <= n && input[child] > input[child + 1]) {
                child++;
            }
            if (input[child] >= tmp) {
                break;
            }
            input[parent] = input[child];
            parent = child;
            child = child * 2 + 1;
        }
        input[parent] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 3, 10, 0, 8};
        System.out.println(GetLeastNumbers_Solution(arr, 7));
    }
}
