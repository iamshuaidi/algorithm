package test;

public class 大整数相乘 {

    public static String mul(String s1, String s2) {
        // 先把字符串转化为 字符数组。
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int len = c1.length + c2.length;
        // 用来存放两个数的积,字符的初始值为 '\u0000'，也就是 0
        char[] c = new char[len];
        // 由于大整数的低位是在字符串的末尾，所以我们从末尾遍历来计算
        for (int i = c1.length - 1; i >= 0; i--) {
            int index = len - 1;
            int res = 0;//用来存放进位
            for (int j = c2.length - 1; j >= 0; j--) {
                int temp = (c1[i]-'0') * (c2[j]-'0') + c[index] + res;
                res = temp / 10;
                c[index--] = (char)(temp % 10);
            }
            // 每趟乘下来的进位要进行保存。
            c[index] = (char)res;
            len--;
        }
        // 最后把c中的字符加上 '0'
        for (int i = 0; i < c.length; i++) {
            c[i] += '0';
        }
        String s = new String(c);
        // n位数乘以m位数得到积位 (m+n)位数或者(n+m-1)位数
        // 我们只需要判断c[0]是否为0，为0则把它舍弃。
        if(c[0] == '0')
            return s.substring(1);
        else
        return s;
    }

    public static void main(String[] args) {
        System.out.println(mul("2000002", "10000001"));
    }
}
