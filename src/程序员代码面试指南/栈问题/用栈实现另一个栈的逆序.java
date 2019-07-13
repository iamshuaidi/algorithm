package 程序员代码面试指南.栈问题;

import java.util.Stack;

public class 用栈实现另一个栈的逆序 {

    public static Stack<Integer> sortStackByStack(Stack<Integer> stack) {
        if (stack == null || stack.size() < 2) {
            return stack;
        }
        Stack<Integer> help = new Stack<>();
        while (!stack.isEmpty()) {
            Integer cur = stack.pop();
            while (!help.isEmpty() && help.peek() < cur) {
                stack.push(help.pop());
            }
            help.push(cur);
        }
        while (!help.isEmpty()) {
            stack.push(help.pop());
        }
        return stack;
    }
}
