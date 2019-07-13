package interview;

import java.lang.reflect.Array;
import java.util.Scanner;

public class JZ2 {
    static int[] res = new int[100000];
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        for (int i = 0; i < n; i++) {
            res[i] = in.nextInt();
        }
        for (int sum = res[0]; sum < 100001; sum++) {
            int cur = sum;
            boolean tt = false;
            for (int i = 0; i < n; i++) {
                if (res[i] > cur) {
                    cur -= res[i] - cur;
                } else {
                    cur += cur - res[i];
                }
                if (cur < 0) {
                    tt = true;
                    break;
                }
            }
            if (tt == false) {
                System.out.println(sum);
                break;
            }
        }

    }

}
