package test;

public class N的阶乘 {

    public static String f(int n) {
        String s = "1";
        Integer t = null;
        for (int i = 2; i <= n; i++) {
            t = i;
            s = 大整数相乘.mul(s,t.toString());
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(f(100));
    }
}
