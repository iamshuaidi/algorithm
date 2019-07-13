package leetcode;

import java.util.HashMap;
import java.util.Stack;

public class NO84 {
    // 方法1   O(n^2)
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int sum = 0;

        for(int i = 0; i < n; i++){
            if(i+1 < n && heights[i] < heights[i+1]){
                continue;
            }
            int min = heights[i];
            for(int j = i; j >= 0; j--){
                min = Math.min(heights[j], min);
                sum = Math.max(sum, min * (i - j + 1) );
            }
        }
        return sum;
    }

    // 方法2   O(n) 采用单调栈
    public int f2(int[] heights) {
        int n = heights.length;
        int sum = 0;

        Stack<Integer> stack = new Stack();

        int tmp = 0;
        for(int i = 0; i <= n; i++){
            tmp = i == n ? 0 : heights[i];
            if(stack.isEmpty() || heights[stack.peek()] < tmp){
                stack.push(i);
                continue;
            }
            int t = stack.pop();
            sum = Math.max(sum, heights[t]*(stack.isEmpty()?i:i-stack.peek()-1));
            i--;
        }
        return sum;
    }

    // 方法3  分治法
    public int largestRectangleArea2(int[] heights){
        if(heights.length < 1)
            return 0;

        return largestRectangleArea(heights, 0, heights.length - 1);
    }

    private int largestRectangleArea(int[] h, int left, int right){
        if(left == right)
            return h[left];

        int mid = left + (right - left) / 2;
        int max = Math.max(largestRectangleArea(h, left, mid),
                largestRectangleArea(h, mid+1, right));
        max = Math.max(max, findMax(h, left, right));
        return max;
    }

    private int findMax(int[] h, int left, int right){
        int mid = left + (right - left) / 2;
        int min = Math.min(h[mid], h[mid+1]);
        int max = 2 * min;
        int i = mid - 1, j = mid + 2;
        while(left <= i || j <= right){
            if(i < left || (j <= right && h[i] < h[j])){
                min = Math.min(min, h[j]);
                j++;
            }else{
                min = Math.min(min, h[i]);
                i--;
            }
            max = Math.max(max, min * (j - i - 1));
        }
        return max;
    }
}
