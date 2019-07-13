package 剑指offer;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 双色塔 {
    final static int MAX = 200001;
    final static int mod = 1000000007;
    static int a = 0;
    static int MAX_HEIGHT = 0;
    static Map<String, Integer> map = new HashMap<>();

    public static int solve(int r, int b, int h) {
        if (h == 0) {
            return 1;
        }
        if(r < h && b < h)
            return 0;

        String s = r + ":" + b;
        if (map.containsKey(s)) {
            a++;
            return map.get(s);
        }
        int sum = 0;
        if (r >= h) {
            sum = solve(r - h, b, h - 1) ;
        }
        if (b >= h) {
            sum += solve(r, b - h, h - 1) ;
        }
        sum = sum % mod;
        map.put(s, sum);
        return sum;
    }

    static int findMax(int n) {
        int sum = 0;
        int t = 1;
        while (n >= t) {
            sum ++;
            n -= t;
            t++;
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //int r = in.nextInt();
        // int b = in.nextInt();
        int r = 200000;
        int b = 20000;
        MAX_HEIGHT = findMax(r +b);
        int sum = solve(r, b, MAX_HEIGHT);
        System.out.println(a);
        System.out.println(sum);
        System.out.println(map.size());
    }
}
