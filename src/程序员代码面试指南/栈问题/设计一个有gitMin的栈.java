package 程序员代码面试指南.栈问题;

import java.util.Stack;

public class 设计一个有gitMin的栈 {
    public static Stack<Integer> stack = new Stack<>();
    public static Stack<Integer> helper = new Stack<>();

    public static Integer getMin() {

        return helper.isEmpty() ? null : helper.peek();
    }

    public static void add(Integer data) {
        stack.push(data);
        if (helper.isEmpty()) {
            helper.push(data);
        } else {
            if (helper.peek() >= data) {
                helper.push(data);
            }
        }
    }

    public static Integer pop() {
        if (stack.isEmpty()) {
            return null;
        }
        Integer res = stack.pop();
        if (res == helper.peek()) {
            helper.pop();
        }
        return res;
    }

    //方法二
    public static void add2(Integer data) {
        stack.push(data);
        if (helper.isEmpty()) {
            helper.push(data);
        }
        else if (helper.peek() < data) {
            helper.push(data);
        } else {
            helper.push(helper.peek());
        }
    }

    public static Integer pop2() {
        if (stack.isEmpty()) {
            return null;
        }
        helper.pop();
        return stack.pop();
    }
}


