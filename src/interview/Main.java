package interview;


import java.util.HashSet;
import java.util.Scanner;

public class Main {
    static HashSet<String> set = new HashSet<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String ss = in.nextLine();
        for (int i = 0; i < n; i++) {
            String s = in.nextLine();
            set.add(s);
        }
        Integer tt = set.size();
        System.out.println(tt - 1);
    }
}
