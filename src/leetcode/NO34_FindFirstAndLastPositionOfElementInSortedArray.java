package leetcode;

public class NO34_FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        if(nums == null || nums.length < 1)
            return res;

        int l = 0;
        int r = nums.length - 1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(nums[mid] > target){
                r = mid - 1;
            }else if(nums[mid] < target){
                l = mid + 1;
            }else{
                int t = mid;
                while(t >= 0 && nums[t] == target){
                    t--;
                }
                res[0] = t + 1;
                t = mid;
                while(t < nums.length && nums[t] == target){
                    t++;
                }
                res[1] = t - 1;
                return res;
            }
        }
        return res;
    }
}
