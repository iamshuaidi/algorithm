package interview;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main5 {
    static HashMap<Integer,Set<Integer>>map = new HashMap<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n - 1; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            Set<Integer> set = null;
            if (map.containsKey(x)) {
               set = map.get(x);
            } else {
                set = new HashSet<>();
            }
            set.add(y);
            map.put(x, set);
            // -------------
            if (map.containsKey(y)) {
                set = map.get(y);
            } else {
                set = new HashSet<>();
            }
            set.add(x);
            map.put(y, set);
        }

        Set<Integer> set = map.get(1);
        int sum = 0;
        int tmp = 0;
        for (Integer i : set) {
            tmp = find(i, 1);
            if (sum < tmp) {
                sum = tmp;
            }
        }
        System.out.println(sum);

    }

    static int find(int key, int parent) {
        int sum = 1;
        Set<Integer> set = map.get(key);
        for (Integer i : set) {
            if (i != parent) {
                sum += find(i, key);
            }
        }
        return sum;
    }
}
