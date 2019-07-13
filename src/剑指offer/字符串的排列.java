package 剑指offer;

import java.util.ArrayList;
import java.util.Collections;

public class 字符串的排列 {

    public static ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if(str == null | str.length() < 1)
            return res;
        char[] c = str.toCharArray();
        permutation(res, c, 0);
        Collections.sort(res);
        return res;
    }

    public static void permutation(ArrayList<String>res, char[] c, int i) {
        if (i == c.length) {
            String s = new String(c);
            res.add(s);
        } else {
            char t;
            for (int j = i; j < c.length; j++) {
                boolean flag = false;
                for (int k = i; k < j; k++) {
                    if (c[k] == c[j]) {
                        flag = true;
                        break;
                    }
                }
                if(flag)
                    continue;
                t = c[j];
                c[j] = c[i];
                c[i] = t;
                permutation(res, c, i + 1);
                // 交换回来
                t = c[j];
                c[j] = c[i];
                c[i] = t;
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<String> str = Permutation("abc");
        System.out.println(str);
    }
}
