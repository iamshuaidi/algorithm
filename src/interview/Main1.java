package interview;

import java.util.BitSet;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        BitSet bitSet = new BitSet(Integer.MAX_VALUE);
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int s = in.nextInt();
            if (bitSet.get(s)) {
                sum++;
            } else {
                bitSet.set(s);
            }
        }
        System.out.printf("" + (n - sum));
    }
}
