package 剑指offer;

public class 二进制中1的个数 {
    public int NumberOf1(int n) {
        int count = 0;
        int k = 1;
        while (k != 0) {
            if ((n & k) != 0) {
                count++;
            }
            k = k << 1;
        }
        return count;
    }

    public int NumberOf12(int n) {
        int count = 0;
        int k = 1;
        while (n != 0) {
            count++;
            n = (n - 1) & n;
        }
        return count;
    }
}
