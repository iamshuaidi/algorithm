package leetcode;

public class NO41_FirstMissingPositine {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length < 1)
            return 1;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            // 这里还有个要注意的地方，就是 nums[i] 与下标为 nums[i]-1的数如果相等的话
            // 也是不需要交换的。
            while (nums[i] >= 1 && nums[i] <= n && nums[i] != i + 1 && nums[i] != nums[nums[i] - 1]) {
                // 和下标为 nums[i] - 1的数进行交换
                int tmp = nums[i];
                nums[i] = nums[tmp - 1];
                nums[tmp - 1] = tmp;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;

    }
}
