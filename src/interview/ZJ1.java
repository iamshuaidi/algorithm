package interview;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ZJ1 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        while (in.hasNext()) {
            String s = in.nextLine();
            list.add(s);
        }

        int[][] res = new int[list.size()][list.get(0).length() / 2 + 1];

        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            //    System.out.println(s);
            for (int j = 0, k = 0; j < s.length(); j += 2, k++) {

                res[i][k] = s.charAt(j) - '0';
            }
        }

        boolean flag = false;
        int sum = 0;
        int n = res.length;
        int m = res[0].length;
        while (true) {
            flag = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                   // System.out.printf("%d ", res[i][j]);
                    if (res[i][j] == 2) {
                      //  System.out.printf("jjj");
                        if (i - 1 >= 0 && res[i - 1][j] == 1) {
                            res[i - 1][j] = 3;
                            flag = true;
                        }
                        if (i + 1 < n && res[i + 1][j] == 1) {
                            res[i + 1][j] = 3;
                            flag = true;
                        }
                        if (j - 1 >= 0 && res[i][j - 1] == 1) {
                            res[i][j - 1] = 3;
                            flag = true;
                        }
                        if (j + 1 < m && res[i][j + 1] == 1) {
                          //  System.out.printf("ddgg");
                            res[i][j + 1] = 3;
                            flag = true;
                        }
                    }
                }
              //  System.out.println();
            }

            if (flag == false) {
                break;
            }
            sum++;
            for (int i1 = 0; i1 < n; i1++) {
                for (int j1 = 0; j1 < m; j1++) {
                    if (res[i1][j1] == 3) {
                        res[i1][j1] = 2;
                    }
                }
            }
        }

        boolean tt = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (res[i][j] == 1) {
                    tt = true;
                    break;
                }
            }
        }
        if (tt == true) {
            System.out.printf("-1");
        } else {
            System.out.println(sum);
        }
    }
}