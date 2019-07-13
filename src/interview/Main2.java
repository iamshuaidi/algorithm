package interview;

import java.util.LinkedList;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] res = s.split(",");
        char[] a = res[0].toCharArray();
        char[] b = res[1].toCharArray();
        int sum = 0;

        int i = 0, j = 0;
        while (j < b.length) {
            if (a[i] == b[j]) {
                i++;
                j++;
            }  else {
                int k = 0;
                if (a[i] == '2' || a[i] == '1') {
                    if ((k = findIndex(a, i, b[j])) != i) {
                        char tmp = a[k];
                        a[k] = a[i];
                        a[i] = tmp;
                        i++;
                        j++;
                        sum++;
                    } else {
                        sum += Math.abs(a[i] - b[j]);
                        i++;
                        j++;
                    }
                } else {
                    if (Math.abs(a[i] - b[j]) < 2) {
                        i++;
                        j++;
                        sum++;
                    } else {
                        if ((k = findIndex(a, i, b[j])) != i) {
                            char tmp = a[k];
                            a[k] = a[i];
                            a[i] = tmp;
                            i++;
                            j++;
                            sum++;
                        } else {
                            sum += Math.abs(a[i] - b[j]);
                            i++;
                            j++;
                        }
                    }
                }

            }
        }
        System.out.println(sum);

    }

    static int findIndex(char[] a, int i, char c) {
        for (int j = i + 1; j < a.length; j++) {
            if (a[j] == c) {
                return j;
            }
        }
        return i;
    }
}
