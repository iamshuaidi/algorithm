package 剑指offer;

public class 连续子数组的最大和 {
    public int FindGreatestSumOfSubArray(int[] array) {
        if(array == null || array.length < 1)
            return 0;
        int sum = 0;
        int tmp = 0;
        int maxSum = array[0];// 记录最大值是否小于0
        for (int i = 0; i < array.length; i++) {
            tmp += array[i];
            if (tmp < 0) {
                tmp = 0;
            }
            if (sum < tmp) {
                sum = tmp;
            }
            if (maxSum < array[i]) {
                maxSum = array[i];
            }
        }
        return maxSum < 0 ? maxSum : sum;
    }
}
