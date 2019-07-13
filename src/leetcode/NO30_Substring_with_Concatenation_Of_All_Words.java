package leetcode;

import java.util.*;

public class NO30_Substring_with_Concatenation_Of_All_Words {
    public List<Integer> findSubstring(String s, String[] words) {
        if (s == null || s.length() < 1 || words == null || words.length < 1) {
            return new ArrayList<>();
        }
        Map<String, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        int count = 0;// 用来保存此时有多少个单词匹配了
        int len = words[0].length();
        int n = s.length();

        for (String str : words) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        for (int i = 0; i < n - words.length * len + 1; i++) {
            count = 0;
            Map<String, Integer> tmp = new HashMap<>();
            for (int j = i; j < n - len + 1; j += len) {
                String str = s.substring(j, j + len);
                tmp.put(str, tmp.getOrDefault(str, 0) + 1);
                if (map.containsKey(str) && map.get(str) >= tmp.get(str)) {
                    count++;
                } else {
                    break;
                }
                if (count == words.length) {
                    res.add(i);
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
    }
}
