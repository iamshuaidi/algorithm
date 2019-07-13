package test;

import java.util.ArrayList;
import java.util.List;
public class 组合 {
    static void f(int[] arr) {
        int n = arr.length;
        // 存放每次组合的结果
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            // i 位数的组合,从第 0 位开始选起
            solve(arr, i, 0, list);
        }
    }
    // i 位数的组合,j表示从第j位开始选起，每选择一个数，则 i减1
    static void solve(int[] arr, int i, int j, List<Integer> list) {
        // i 小于0时则表示已经选好了
        if (i < 0) {
            System.out.println(list.toString());
        } else {
            for (int k = j; k < arr.length; k++) {
                list.add(arr[k]);
                // 递归选择下一个数
                solve(arr, i - 1, k + 1, list);
                // 回溯，把这个选的数去掉，重新循环选择另一个数
                list.remove(list.size()-1);
            }
        }
    }
    // 测试
    public static void main(String[] args) {
        aa();
    }

    public static void aa() {
        aa();
    }
}
