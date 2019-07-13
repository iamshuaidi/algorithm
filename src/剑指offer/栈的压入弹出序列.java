package 剑指offer;

import kmp.KMP;

import java.util.Stack;

public class 栈的压入弹出序列 {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack = new Stack<>();
        int k = 0;
        for (int i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            while (!stack.isEmpty() && stack.peek() == popA[k]) {
                k++;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
