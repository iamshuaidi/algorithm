package leetcode;

public class NO29_Divide_Tow_Integer {

    public static int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor == 1)return Integer.MIN_VALUE;
        else if(dividend == Integer.MIN_VALUE && divisor == -1)return Integer.MAX_VALUE;
        //用来记录结果是负数还是正数
        int result = 0;
        int flag = 2;
        if (dividend > 0) {
            dividend = -dividend;
            flag--;
        }
        if (divisor > 0) {
            divisor = - divisor;
            flag--;
        }
        //加速效率
        long temp = divisor;
        int inc = 1;
        boolean tt = false;
        while (dividend <= divisor ) {
            if (dividend <= temp) {
                dividend -= temp;
                result += inc;
            }else {
                tt = true;
            }
            if (tt) {
                temp /= 2;
                inc /= 2;
            } else {
                temp *= 2;
                inc *= 2;
            }
            System.out.println(temp);
        }
        return flag == 1 ? -result : result;
    }

    public static void main(String[] args) {
        System.out.println("结果:" + divide(Integer.MAX_VALUE, 1));
    }
}
