package interview;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main3 {

/** 请完成下面这个函数，实现题目要求的功能 **/
    /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
    static Map<Integer, Integer>map = new HashMap<>();
    static String calculate(int m, int k) {
        StringBuilder builder = new StringBuilder();
        int tt = findM(m);
        builder.append(tt);
        builder.append(",");

        return builder.toString();

    }

    static int findM(int m) {
        if(m <= 4)
            return m + 1;

        if (map.containsKey(m)) {
            return map.get(m);
        } else {
            int sum = findM(m - 2) + findM(m - 3);
            map.put(m, sum);
            return sum;
        }
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String[] line = in.nextLine().split(",");
        int m = Integer.valueOf(line[0]);
        int k = Integer.valueOf(line[1]);;
        System.out.println(calculate(m, k));
    }
}
