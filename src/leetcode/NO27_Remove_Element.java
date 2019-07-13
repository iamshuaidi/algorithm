package leetcode;

public class NO27_Remove_Element {
    public int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == val)
                continue;
            nums[k++] = nums[i];
        }
        String a = "";
        return k;
    }
}
