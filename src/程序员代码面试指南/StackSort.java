package 程序员代码面试指南;

import java.util.Stack;

public class StackSort {

    /**
     * 用一个栈实现另一个栈的排序
     * @param stack
     * @return
     */
    public static Stack<Integer> sortStackByStack(Stack<Integer> stack) {
        Stack<Integer> help = new Stack<>();
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            while (!help.isEmpty() && help.peek() > cur) {
                stack.push(help.pop());
            }
        }
        while (!help.isEmpty()) {
            stack.push(help.pop());
        }
        return stack;
    }
}
