package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NO15 {

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int target = 0;
        for (int i = 0; i < nums.length; i++) {
            //to check the duplicate compare it with prev no
            // if u do i + 1 < nums[i] != nums[i+1] yoou will miss
            //some number.
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            } else {
                twoSum(nums, i, target - nums[i], result);
            }
        }
        return result;

    }

    private static void twoSum(int[] nums, int i, int target, List<List<Integer>> result) {
        int num = nums[i];
        int j = nums.length - 1;
        i = i + 1;
        while (i < j) {
            if (nums[i] + nums[j] < target) {
                i++;
            } else if (nums[i] + nums[j] > target) {
                j--;
            } else {
                List<Integer> temp = new ArrayList<>();
                temp.add(nums[i]);
                temp.add(nums[j]);
                temp.add(num);
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
        int[] nums = new int[] {0, 0, 0, 0};
        System.out.println(threeSum(nums));
    }
}
