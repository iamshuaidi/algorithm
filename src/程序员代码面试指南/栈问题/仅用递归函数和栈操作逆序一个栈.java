package 程序员代码面试指南.栈问题;

import java.util.Stack;

public class 仅用递归函数和栈操作逆序一个栈 {

    //把栈逆序
    public static Stack<Integer> reverse(Stack<Integer> stack) {
        if (stack == null || stack.size() < 2) {
            return stack;
        }
        int last = getAndRemoveLastElement(stack);
        Stack<Integer> newStack = reverse(stack);
        newStack.push(last);
        return newStack;
    }

    public static Integer getAndRemoveLastElement(Stack<Integer> stack) {
        int result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        } else {
            int last = getAndRemoveLastElement(stack);
            stack.push(result);
            return last;
        }
    }

}
