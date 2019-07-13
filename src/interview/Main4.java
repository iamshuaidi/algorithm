package interview;

import java.util.Scanner;

public class Main4 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.nextLine();
        String s2 = in.nextLine();
        int min = s1.length() < s2.length() ? s1.length() : s2.length();
        int max = s1.length() < s2.length() ? s2.length() : s1.length();
        int res = 0;
        for (int i = 0; i < min; i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                res++;
            }
        }
        System.out.println(max - res);
    }
}
