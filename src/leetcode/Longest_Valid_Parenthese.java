package leetcode;

import java.util.Stack;

public class Longest_Valid_Parenthese {
    public int longestValidParentheses(String s) {
        if(s == null || s.length() < 1)
            return 0;
        int n = s.length();
        int longest = 0;
        Stack<Integer> stack = new Stack();

        for(int i = 0;  i < s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push(i);
            }else{
                if(!stack.empty() && s.charAt(stack.peek()) == '('){
                    stack.pop();
                }else{
                    stack.push(i);
                }
            }
        }
        if(stack.empty())
            return n;
        int tmp = n;
        int a = 0;
        while(!stack.empty()){
            a = stack.pop();
            longest = Math.max(longest, tmp - a - 1);
            tmp = a;
        }
        return longest > tmp ? longest : tmp;
    }
}
