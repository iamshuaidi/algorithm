package leetcode;

import java.util.Scanner;

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        Scanner in = new Scanner(System.in);
        if(nums == null || nums.length < 1)
            return 0;
        if(nums[0] > target)
            return 0;
        if(nums[nums.length - 1] < target)
            return nums.length;
        int l = 0;
        int r = nums.length - 1;
        int mid = 0;
        while(l <= r){
            mid = l + (r - l) / 2;
            if(nums[mid] < target){
                l = mid + 1;
            }else if(nums[mid] > target){
                r = mid - 1;
            }else{
                return mid;
            }
        }
        if(nums[mid] < target)
            return mid + 1;
        else
            return mid;
    }
}
