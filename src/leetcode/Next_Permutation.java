package leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

public class Next_Permutation {
    public static void nextPermutation(int[] nums) {
        boolean flag = false;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                int tmp = i;
                // 从右边找出一个最小的且比nums[i-1]大的数和它交换
                for (int k = i; k < nums.length; k++) {
                    if (nums[k] > nums[i - 1]) {
                        tmp = k;
                    }
                }
                // 进行交换
                int t = nums[i - 1];
                nums[i - 1] = nums[tmp];
                nums[tmp] = t;
                // 对右边的数进行排序
                Arrays.sort(nums, i, nums.length);
                flag = true;
                break;
            }
        }
        if (!flag) {
            Arrays.sort(nums);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));

    }

}
