package leetcode;

/*
 题目描述:
 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。

 事例：
 给定 nums = [2, 7, 11, 15], target = 9
因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]
 */


import java.util.HashMap;
import java.util.Map;

public class Solution1 {
    //方法一：简单暴力，两个for循环搞定
    public int[] twoSum1(int[] nums, int target) {
        int[] temp = new int[2];//用来存要找的数的下标
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                    temp[0] = i;
                    temp[1] = j;
                    return temp;
                }
            }
        }
        return null;
    }

    //方法二，通过hashMap来处理
    public int[] twoSum3(int[] nums, int target){
        int[] temp = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        //遍历查找
        for(int i = 0; i < nums.length; i++){
            int a = nums[i];
            if(map.containsKey(target - a)){
                temp[0] = map.get(target - a);
                temp[1] = i;
                return temp;
            }else {//如果找不到则存进去
                map.put(temp[i], i);
            }
        }
        return null;
    }

}
