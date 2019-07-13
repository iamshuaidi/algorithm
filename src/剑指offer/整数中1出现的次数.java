package 剑指offer;

public class 整数中1出现的次数 {
    // 计算每个位
    public int NumberOf1Between1AndN_Solution(int n) {
        // 从各位开始算, i 表示当前是各位、十位还是百位
        int i = 1;
        int count = 0;
        while (n / i != 0) {
            int lower = n % i;
            int cur = (n / i) % 10;
            int high = n / (i * 10);
            // 进行判断当前位是0，1还是大于1
            if (cur == 0) {
                count += high * i;
            } else if (cur == 1) {
                count += high * i + lower + 1;
            } else {
                count += (high + 1) * i;
            }
            i = i * 10;
        }
        return count;
    }
}
