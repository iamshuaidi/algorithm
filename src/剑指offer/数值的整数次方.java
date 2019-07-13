package 剑指offer;

public class 数值的整数次方 {
    // 暴力求解
    public double Power(double base, int exponent) {
        // 任何数的 0 次方都是 1(0除外，不过题目并没有说 base=0时怎么处理)
        if (exponent == 0) {
            return 1;
        }
        double temp = base;
        int n = exponent;
        if (n < 0) {
            n = -n;
        }
        for (int i = 0; i < n; i++) {
            base *= temp;
        }
        return exponent < 0 ? 1 / base : base;
    }

    // 优化版
    public static double Power2(double base, int exponent) {
        if(exponent == 0)
            return 1.0;
        double temp = base;
        int k = 1;
        boolean flag = true;
        double ee = exponent;
        double tt = base;
        exponent = Math.abs(exponent) - 1;


        while (exponent > 0) {
            if (flag) {
                if (exponent >= k) {
                    base *= temp;
                    exponent -= k;
                    temp *= temp;
                    k += k;
                } else {
                    while (k > exponent) {
                        k /= 2;
                        temp = Math.sqrt(temp);
                    }
                    flag = false;
                }
            } else {
                base *= temp;
                exponent -= k;
                k /= 2;
                temp = Math.sqrt(temp);
                while (k > exponent) {
                    k /= 2;
                    temp = Math.sqrt(temp);
                }
            }
        }

        if (tt < 0 && ee % 2 != 0)
            base = -base;

        if (ee < 0) {
            base = 1 / base;
        }
        return base;
    }
    public double Power3(double base, int exponent) {
        if(exponent == 0)
            return 1.0;
        int n = exponent;
        if (n < 0) {
            n = -n;
        }
        double sum = 1;
        double temp = base;
        while (n != 0) {
            if ((n & 1) != 0) {
                sum *= temp;
            }
            temp *= temp;
            n = n >> 1;
        }
        return exponent < 0 ? 1 / sum : sum;
    }

    public static void main(String[] args) {
        System.out.println(Power2(2, -3));
    }
}
