package algorithms_fourth_edition.find;

public class Permutation {

    // 调用方式：
// int[]a = a={1, 2, 3, 4}; printPermutations(a, 4, 4);
// k 表示要处理的子数组的数据个数
    public static void printPermutations(int[] data, int n, int k) {
        if (k == n) {
            for (int i = 0; i < n; ++i) {
                System.out.print(data[i] + " ");
            }
            System.out.println();
        }

        for (int i = k; i < n; ++i) {
            int tmp = data[i];
            data[i] = data[k];
            data[k] = tmp;

            printPermutations(data, n, k + 1);

            tmp = data[i];
            data[i] = data[k];
            data[k] = tmp;
        }
    }

    public static void main(String[] args) {
        int[]a = {1, 2, 3, 4};
        printPermutations(a, 4, 0);
    }

}
