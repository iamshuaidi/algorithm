package leetcode;

public class NO13 {
    public static int romanToInt(String s) {
        int len = s.length();
        int i = 0;
        int num = 0;
        //1000
        while (i < len && s.charAt(i) == 'M') {
            num += 1000;
            i++;
        }
        //900
        if (i + 1 < len && s.charAt(i) == 'C' && s.charAt(i + 1) == 'M') {
            num += 900;
            i += 2;
        }
        //500
        if (i < len && s.charAt(i) == 'D') {
            num += 500;
            i++;
        }
        //400
        if (i + 1 < len && s.charAt(i) == 'C' && s.charAt(i + 1) == 'D') {
            num += 400;
            i += 2;
        }
        //100
        while (i < len && s.charAt(i) == 'C') {
            num += 100;
            i++;
        }

        //100以下
        //90
        if (i + 1 < len && s.charAt(i) == 'X' && s.charAt(i + 1) == 'C') {
            num += 90;
            i += 2;
        }
        //50
        if (i < len && s.charAt(i) == 'L') {
            num += 50;
            i++;
        }
        //40
        if (i + 1 < len && s.charAt(i) == 'X' && s.charAt(i + 1) == 'L') {
            num += 40;
            i += 2;
        }
        //10
        while (i < len && s.charAt(i) == 'X') {
            num += 10;
            i++;
        }

        //10以下
        //9
        if (i + 1 < len && s.charAt(i) == 'I' && s.charAt(i + 1) == 'X') {
            num += 9;
            i += 2;
        }
        //5
        if (i < len && s.charAt(i) == 'V') {
            num += 5;
            i++;
        }
        //4
        if (i + 1 < len && s.charAt(i) == 'I' && s.charAt(i + 1) == 'V') {
            num += 4;
            i += 2;
        }
        //1
        while (i < len && s.charAt(i) == 'I') {
            num += 1;
            i++;
        }
        return num;
    }

    //更加简便的方法
    public static int romanToInt2(String s){
        // 这个函数是将单个罗马字符转换为数字

        int sum = charToInt(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            // 如果出现 IV,XC,XL这种情况，那么我们需要减去两倍的 I,X等，
            // 因为它前面被我们多加了一次
            if (charToInt(s.charAt(i)) > charToInt(s.charAt(i - 1))) {

                sum = sum + charToInt(s.charAt(i))- 2 * charToInt(s.charAt(i-1));
            }else {
                sum = sum + charToInt(s.charAt(i));
            }
        }
        return sum;

    }

    // 这个函数是将单个罗马字符转换为数字
    private static int charToInt(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

    public static void main(String[] strings) {
        System.out.println(romanToInt2("MCMXCIV"));
    }
}
