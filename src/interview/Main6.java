package interview;

import java.util.*;

public class Main6 {

    static Set<String> sets = new HashSet<>();
    static String target = null;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        in.nextLine();
        for (int i = 0; i < m; i++) {
            String s = in.nextLine();
            sets.add(s);
        }
        target = in.nextLine();

        int sum = sovle(0, target.length(), 0);
        System.out.println(sum);

    }

    public static int sovle(int left, int right, int sum) {
        if (left > right) {
            return sum;
        }

        int tt = 0;
        int res = sum;
        for (int i = left; i < target.length(); i++) {
            String tmp = target.substring(0, i + 1);
            if (sets.contains(tmp)) {
                tt = sovle(i + 1, target.length(), sum + 1);
                if (sum < tt) {
                    sum = tt;
                }
            }
        }
        return sum;
    }
}
