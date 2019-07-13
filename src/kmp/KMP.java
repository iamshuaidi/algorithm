package kmp;

import java.lang.reflect.Array;

public class KMP {
    public int strStr(String haystack, String needle) {
        if(needle == null || needle.length() < 1)
            return 0;
        return KMP(haystack, needle);
    }

    public static int KMP(String str, String subStr) {
        //获取部分匹配值
        int[] next = getNext(subStr, new int[subStr.length()]);
        int k = -1;
        for (int i = 0; i < str.length(); i++) {
            //如果有部分匹配，则回溯
            while(k > -1 && str.charAt(i) != subStr.charAt(k+1)){
                k = next[k];
            }
            if(str.charAt(i) == subStr.charAt(k+1)){
                k++;
            }
            if (k == subStr.length() - 1) {
                return i - k;
            }
        }
        return -1;
    }

    private static int[] getNext(String str, int[] next) {
        next[0] = -1;
        int k = -1;
        for (int i = 1; i < str.length(); i++) {
            while(k > -1 && str.charAt(k+1) != str.charAt(i)){
                k = next[k];
            }
            if(str.charAt(k+1) == str.charAt(i)){
                k++;
            }
            next[i] = k;
        }
        return next;
    }

    public static void main(String[] args) {
        String a = "issipi";
        String b = "mississippi";
        System.out.println("匹配的位置：" + KMP(b, a));
    }
}
