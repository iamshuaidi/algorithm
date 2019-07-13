package leetcode;

public class Search_In_Rotated_Sorted_Array {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length < 1)
            return -1;
        int r = nums.length - 1;
        int l = 0;

        while(l <= r){
            int mid = l + (r - l) / 2;
            if(target == nums[mid]){
                return mid;
            }else{
                if(nums[mid] >= nums[l]){
                    if(target < nums[mid] && target >= nums[l]){
                        r = mid -1;
                    }else{
                        l = mid + 1;
                    }
                }else{
                    if(target > nums[mid] && target <= nums[r]){
                        l = mid + 1;
                    }else{
                        r = mid - 1;
                    }
                }
            }
        }

        return -1;
    }
}
