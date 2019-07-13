package 剑指offer;

import java.util.ArrayList;

public class 顺序打印矩阵 {
    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        int sum = matrix.length * matrix[0].length;
        ArrayList<Integer> list = new ArrayList<>(sum);
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;
        int i = 0, j = 0;
        // 定义此时的方向，0代表向右，1 = 下，2 = 左， 3 = 上。
        int status = 0;
        while (list.size() < sum ) {
            if (status == 0) {
               // System.out.println("i = " + i + ", j = " + j);
                while (j <= right) {
                    list.add(matrix[i][j]);
                 //   System.out.println(matrix[i][j]);
                    j++;
                }
                status = 1;
                top++;
                i = top;
                j = right;
            } else if (status == 1) {
                while (i <= bottom) {
                    list.add(matrix[i][j]);
                 //   System.out.println(matrix[i][j]);
                    i++;
                }
                status = 2;
                right--;
                j = right;
                i = bottom;

            } else if (status == 2) {
                while (j >= left) {
                    list.add(matrix[i][j]);
                 //   System.out.println(matrix[i][j]);
                    j--;
                }
                status = 3;
                bottom--;
                j = left;
                i = bottom;
            } else if (status == 3) {
                while (i >= top) {
                    list.add(matrix[i][j]);
                 //   System.out.println(matrix[i][j]);
                    i--;
                }
                status = 0;
                left ++;
                i = top;
                j = left;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        printMatrix(arr);

    }
}
