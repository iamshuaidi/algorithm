package leetcode;

public class NO42_TrappingRainWater {
    public int trap(int[] height) {
        if(height == null | height.length < 2)
            return 0;
        return solve(height, 0, height.length - 1);
    }

    private int solve(int[] height, int l, int r){
        if(r - 1 <= l) return 0;
        int lIndex = -1;
        int rIndex = -1;
        // find the max number
        int max = -1;
        for(int i = l; i <= r; i++){
            if(max < height[i]){
                max = height[i];
                lIndex = i;
            }
        }
        // find the second max sum
        max = -1;
        for(int i = r; i >= l; i--){
            if(height[i] > max && i != lIndex){
                max = height[i];
                rIndex = i;
            }
        }

        if(lIndex > rIndex){
            int tmp = lIndex;
            lIndex = rIndex;
            rIndex = tmp;
        }
        // 开始计算中间哪部分的面积
        int t = 0;
        for (int i = lIndex + 1; i < rIndex; i++) {
            t += height[i];
        }
        int secMax = height[lIndex] <= height[rIndex] ? height[lIndex] : height[rIndex];
        int centerTrap = secMax * (rIndex - lIndex - 1) - t;

        int leftTrap = solve(height, l, lIndex);
        int rightTrap = solve(height, rIndex, r);
        return centerTrap + leftTrap + rightTrap;
    }

    // 方法2：dp
    public int trap2(int[] height){
        if(height == null || height.length < 2)
            return 0;
        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = height[0];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i-1], height[i]);
        }
        right[n-1] = height[n-1];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(right[i+1], height[i]);
        }
        int sum = 0;
        for (int i = 1; i < n - 1; i++) {
            sum += Math.min(left[i], right[i]) - height[i];
        }
        return  sum;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,2,1,0,1,3,2,1,2,1};
        NO42_TrappingRainWater t = new NO42_TrappingRainWater();
        System.out.println(t.trap(nums));
    }
}
