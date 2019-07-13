package leetcode;

public class NO26_remove_duplicates_from_sorted_array {
    public int removeDuplicates(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] == nums[i])
                continue;
            nums[sum++] = nums[i];
        }
        return sum;
    }


}
