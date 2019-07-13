package 程序员代码面试指南.栈问题;

import java.util.Stack;
@SuppressWarnings("all")
public class 由两个栈组成的队列 {
    public static Stack<Integer> stack = new Stack<>();//进队用这个栈
    public static Stack<Integer> helper = new Stack<>();//出队用这个栈

    public static void add(int data) {
        stack.push(data);
    }

    public static Integer poll() {
        if (stack.isEmpty() && helper.isEmpty()) {
            return null;
        } else {
            if (helper.isEmpty()) {
                while (!stack.isEmpty()) {
                    helper.push(stack.pop());
                }
            }
        }
        return helper.pop();
    }

    public static Integer peek() {
        if (stack.isEmpty() && helper.isEmpty()) {
            return null;
        } else {
            if (helper.isEmpty()) {
                while (!stack.isEmpty()) {
                    helper.push(stack.pop());
                }
            }
        }
        return helper.peek();
    }
}
