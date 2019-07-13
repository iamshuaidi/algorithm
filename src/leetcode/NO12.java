package leetcode;

public class NO12 {
    public static String intToRoman(int num) {
        StringBuilder str = new StringBuilder();
        while (num >= 1000) {
            str.append("M");
            num -= 1000;
        }
        if (num >= 900) {
            str.append("CM");
            num -= 900;
        }
        if (num >= 500) {
            str.append("D");
            num -= 500;
        }
        if (num >= 400 && num < 500) {
            str.append("CD");
            num -= 400;
        }
        while (num >= 100) {
            str.append("C");
            num -= 100;
        }


        if (num >= 90) {
            str.append("XC");
            num -= 90;
        }
        if (num >= 50) {
            str.append("L");
            num -= 50;
        }
        if (num >= 40 && num < 50) {
            str.append("XL");
            num -= 40;
        }
        while (num >= 10) {
            str.append("X");
            num -= 10;
        }

        if (num >= 9) {
            str.append("IX");
            num -= 9;
        }
        if (num >= 5) {
            str.append("V");
            num -= 5;
        }
        if (num >= 4 && num < 5) {
            str.append("IV");
            num -= 4;
        }
        while (num >= 1) {
            str.append("I");
            num -= 1;
        }
        return str.toString();
    }

    //简化版
    public static String intToRoman2(int num){
        StringBuilder str = new StringBuilder();
        int temp = 100;
        for (int i = 0; i < 3; i++) {
            while (num >= 10 * temp) {
                str.append("M");
                num -= 10 * temp;
            }
            if (num >= 9 * temp) {
                str.append("CM");
                num -= 9 * temp;
            }
            if (num >= 5 * temp) {
                str.append("D");
                num -= 5 * temp;
            }
            if (num >= 4 * temp && num < 5 * temp) {
                str.append("CD");
                num -= 4 * temp;
            }
            while (num >= 1 * temp) {
                str.append("C");
                num -= 1 * temp;
            }
            temp = temp / 10;
        }
        return str.toString();
    }


    public static void main(String[] strings) {
        System.out.println(intToRoman2(1994));
    }
}
