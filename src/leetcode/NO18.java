package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NO18 {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>>result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            } else {
                threeSum(nums, i, target - nums[i], result);
            }
        }
        return result;
    }


    public static void threeSum(int[] nums, int i1, int target, List<List<Integer>> result) {
        int i = i1 + 1;
        for ( ; i < nums.length; i++) {
            //to check the duplicate compare it with prev no
            // if u do i + 1 < nums[i] != nums[i+1] yoou will miss
            //some number.
            if (i > i1+1 && nums[i] == nums[i - 1]) {
                continue;
            } else {
                twoSum(nums, i1, i, target - nums[i], result);
            }
        }

    }

    private static void twoSum(int[] nums,int i1, int i2, int target, List<List<Integer>> result) {
        int i = i2 + 1;
        int j = nums.length - 1;
        while (i < j) {
            if (nums[i] + nums[j] < target) {
                i++;
            } else if (nums[i] + nums[j] > target) {
                j--;
            } else {
                List<Integer> temp = new ArrayList<>();
                temp.add(nums[i1]);
                temp.add(nums[i2]);
                temp.add(nums[i]);
                temp.add(nums[j]);
                result.add(temp);
                i++;
                j--;
                while (i < j && nums[i] == nums[i - 1]) {
                    i++;
                }
                while (i < j && nums[j] == nums[j + 1]) {
                    j--;
                }

            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 0, -1, 0, -2, 2};
        System.out.println(fourSum(nums, 0));
    }
}
