package leetcode;

public class NO11 {
    public int maxArea(int[] height) {
        int max = 0;

        for (int i = 0; i < height.length; i++) {
            int temp = 0;
            for (int j = i + 1; j < height.length; j++) {
                // 算出所围成的面积
                max = Math.max(max,(j-i)*Math.min(height[i], height[j]));
            }
        }
        return max;
    }

    //双指针的模式做
    public int maxArea2(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while (right > left) {
            max = Math.max(max,(right-left)*Math.min(height[right], height[left]));
            if(height[right]>height[left])
                left++;
            else
                right--;
        }
        return max;
    }


}
