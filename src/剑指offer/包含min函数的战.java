package 剑指offer;

import com.sun.prism.ReadbackRenderTarget;

import java.util.Stack;

public class 包含min函数的战 {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> help = new Stack<>();

    public void push(int node) {
        stack.push(node);
        if (help.isEmpty()) {
            help.push(node);
        } else {
            int min = min();
            if (node <= min) {
                help.push(node);
            } else {
                help.push(min);
            }
        }
    }

    public void pop() {
        stack.pop();
        help.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return help.peek();
    }
}
