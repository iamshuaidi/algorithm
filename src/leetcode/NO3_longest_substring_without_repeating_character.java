package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NO3_longest_substring_without_repeating_character{
        public static int lengthOfLongestSubstring(String s) {
            if(s == null | s.length() < 0)
                return 0;
            int sum = 0;
            char[] ar = s.toCharArray();
            List<Character> list = new ArrayList<>();
            for (int i = 0; i < ar.length; i++) {
                if (list.contains(ar[i])) {
                    sum = sum > list.size() ? sum : list.size();
                    remove(list, ar[i]);
                } else {
                    list.add(ar[i]);
                }
            }
            return sum > list.size() ? sum : list.size();
        }

    private static void remove(List<Character> list, Character e) {
            int k = list.indexOf(e);
        for (int i = 0; i <= k; i++) {
            list.remove(i);
        }
        list.add(e);
    }


    public int lengthOfLongestSubstring2(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max=0;
        for (int i=0, j=0; i<s.length(); ++i){
            if (map.containsKey(s.charAt(i))){
                j = Math.max(j,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-j+1);
        }
        return max;
    }
    public static void main(String[] args) {
            String s = "abcabcbb";
            System.out.println(lengthOfLongestSubstring(s));
    }


}
