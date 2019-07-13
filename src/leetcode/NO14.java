package leetcode;

public class NO14 {
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length <= 0) {
            return "";
        }
        String s = "";
        for (int j = 0; j < strs[0].length(); j++) {
            char c = strs[0].charAt(j);
            // 开始纵向遍历
            for (int i = 1; i < strs.length; i++) {
                if (j >= strs[i].length() || c != strs[i].charAt(j)) {
                    return s;
                }
            }
            s += c;
        }
        return s;
    }

    public static void main(String[] strings) {
        String[] str = new String[] {};
        System.out.println(longestCommonPrefix(str));
    }
}
