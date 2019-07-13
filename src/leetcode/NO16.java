package leetcode;

import java.util.Arrays;
import java.util.List;

public class NO16 {

    public static int threeSumClose(int[] nums, int target) {
        //存他们之间的差
        int result = Math.abs(nums[0] + nums[1] + nums[2] - target);
        int sum = nums[0] + nums[1] + nums[2];
        //排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            } else {
                int j = i + 1;
                int k = nums.length - 1;
                int temp = target - nums[i];

                while (j < k) {
                    int t = nums[j] + nums[k];
                    if (t < temp) {
                        if (result > temp - t) {
                            result = temp - t;
                            sum = t + nums[i];
                        }
                        j++;
                    } else if (t > temp) {
                        if (Math.abs(result) > t - temp) {
                            result = t - temp;
                            sum = t + nums[i];
                        }
                        k--;
                    } else {
                        return nums[i] + t;
                    }
                }
            }

        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {0, 2, 1, -3};
        System.out.println(threeSumClose(nums, 1));
    }
}
