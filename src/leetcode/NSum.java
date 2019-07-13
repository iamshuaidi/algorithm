package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NSum {
    public static List<List<Integer>> nSum(int[] nums, int n, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int index = 0;

        List<Integer> list = new ArrayList<>();
        if (n > 2) {
            for (int i = 0; i < nums.length; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                } else {
                    list.add(nums[i]);
                    //递归寻找下一个数
                    findNext(nums, n - 1, result, list, target - nums[i], i, index + 1);
                    //回溯
                    list.remove(index);
                }
            }
        } else if (n == 2) {
            twoSum(nums, result, list, target, 0);
        }
        return result;
    }

    public static void findNext(int[] nums, int n, List<List<Integer>> result,
                                List<Integer> list, int target, int i, int index) {
        if (n > 2) {
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                } else {
                    list.add(nums[j]);
                    findNext(nums, n - 1, result, list, target - nums[j], j, index + 1);
                    //刚开始弄成了j
                    list.remove(index);
                }
            }
        } else {
            twoSum(nums, result, list, target, i);
        }
    }

    public static void twoSum(int[] nums, List<List<Integer>> result,
                              List<Integer> list, int target, int i) {
        int j = i + 1;
        int k = nums.length - 1;
        while (j < k) {
            if (nums[j] + nums[k] > target) {
                k--;
            } else if (nums[j] + nums[k] < target) {
                j++;
            } else {
                //找到目标数
                List<Integer> temp = new ArrayList<>();
                temp.addAll(list);

                temp.add(nums[j]);
                temp.add(nums[k]);
                result.add(temp);
                j++;
                k--;
                while (j < k) {
                    if (nums[j] == nums[j - 1])
                        j++;
                }
                while (j < k) {
                    if (nums[k] == nums[k + 1])
                        k--;
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("jjj");
        int[] nums = new int[]{1, 0, -1, 0, -2, 2};
        System.out.println(nSum(nums, 3, 0));

}
}

