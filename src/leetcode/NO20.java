package leetcode;

import java.util.Stack;

public class NO20 {
    public static boolean isValid(String s) {
        if (s == null || s.length() < 1) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                //如果是空，则找不到配对的
                if (stack.isEmpty()) {
                    return false;
                } else {
                    Character cc = stack.pop();
                    if(!isOk(cc, c)){
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    private static boolean isOk(char cc, char c) {
        if (cc == '(' && c == ')' || cc == '{' && c == '}' || cc == '[' && c == ']') {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String s6 = "Python爬虫与数据挖掘";
        String s7 = "业余草";
        String s8 = "淼淼之森";
        String s1 = "Java学习之道";
        String s2 = "程序员良许";
        String s3 = new String("苦逼的码农");
        String s4 = "Java识堂";
        String s5 = "扎心了Python";
        System.out.println("结果如下：");


        System.out.println(s1 + " = " + s1.hashCode() % 177);
        System.out.println(s2 + " = " + s2.hashCode() % 177);
        System.out.println(s3 + " = " + s3.hashCode() % 177);
        System.out.println(s4 + " = " + s4.hashCode() % 177);
        System.out.println(s5 + " = " + s5.hashCode() % 177);
        System.out.println(s6 + " = " + s6.hashCode() % 177);
        System.out.println(s7 + " = " + s7.hashCode() % 177);
        System.out.println(s8 + " = " + s8.hashCode() % 177);

    }
}
