package 程序员代码面试指南.栈问题;

import java.lang.annotation.ElementType;
import java.security.MessageDigest;

public class 用栈实现汉诺塔问题 {

    //递归版
    public static int hanoiProblem1(int num, String left, String mid, String right) {
        if (num < 1) {
            return 0;
        }
      //  return solve1(num, left, mid,);
        return 1;
    }

    public static int solve1(int num, String left, String mid,
                             String right, String from, String to) {
        if (num == 1) {
            if (from.equals(mid) || to.equals(mid)) {
                System.out.println("Move 1 from " + from + " to " + to);
                return 1;
            } else {
                System.out.println("Move 1 from " + from + " to " + mid);
                System.out.println("Move 1 from " + mid + " to " + to);
                return 2;
            }
        }
        if (from.equals(mid) || to.equals(mid)) {


        }
        return 1;
    }
}
