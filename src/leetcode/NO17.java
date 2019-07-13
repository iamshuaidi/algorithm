package leetcode;

import java.util.ArrayList;
import java.util.List;

public class NO17 {
    String str = new String("abcdefghijklmnopqrstuvwxyz");
    public List<String> letterCombinations(String digits) {

        List<String> list = new ArrayList<>();
        if (digits == null || digits.length() < 1) {
            return list;
        }

        StringBuilder builder = new StringBuilder();
        combination(digits, list, builder, 0);
        return list;
    }

    private void combination(String digits, List<String>list,StringBuilder builder, int i) {
        if (i == digits.length()) {
            list.add(builder.toString());
        } else {
            int t = digits.charAt(i) - '0';
            if (t < 7) {
                for (int j = (t - 2) * 3; j <  (t - 1) * 3; j++) {
                    builder.append(str.charAt(j));
                    combination(digits, list, builder, i + 1);
                    builder.deleteCharAt(i);
                }
            } else if (t == 7) {
                for (int j = (t - 2) * 3; j < (t - 1) * 3 + 1; j++) {
                    builder.append(str.charAt(j));
                    combination(digits, list, builder, i + 1);
                    builder.deleteCharAt(i);
                }
            } else if (t == 8) {
                for (int j = 19; j < 22; j++) {
                    builder.append(str.charAt(j));
                    combination(digits, list, builder, i + 1);
                    builder.deleteCharAt(i);
                }
            } else {
                for (int j = 22; j < 26; j++) {
                    builder.append(str.charAt(j));
                    combination(digits, list, builder, i + 1);
                    builder.deleteCharAt(i);
                }
            }
        }

    }

    public static void main(String[] args) {
        NO17 n = new NO17();
        System.out.println(n.letterCombinations("234"));
        //System.out.println(n.str.length());
    }
}
