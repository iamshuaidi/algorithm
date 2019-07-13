package test;


import java.util.BitSet;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public int firstMissingPositive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] >= 1 && nums[i] <= n) {
                set.add(nums[i]);
            }
        }
        for (int i = 1; i <= n; i++) {
            if (!set.contains(i)) {
                return  i;
            }
        }
        return n + 1;
    }

    public int firstMissingPositive2(int[] nums) {
        BitSet bitSet = new BitSet();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] >= 1 && nums[i] <= n) {
                bitSet.set(nums[i]);
            }
        }
        for (int i = 1; i <= n; i++) {
            if (!bitSet.get(i)) {
                return  i;
            }
        }
        return n + 1;
    }
}
