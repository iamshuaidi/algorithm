package 剑指offer;

import javax.lang.model.type.ErrorType;
import java.util.HashMap;
import java.util.Map;

public class 数组中出现次数超过一半的数字 {
    public int MoreThanHalfNum_Solution(int [] array) {
        if(array == null || array.length < 1)
            return 0;
        int n = array.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(array[i])) {
                map.put(array[i], map.get(array[i]) + 1);
            } else {
                map.put(array[i], 1);
            }
        }
        int sum = 0;
        int res = 0;
        for (Integer key : map.keySet()) {
            if (sum < map.get(key)) {
                sum = map.get(key);
                res = key;
            }
        }
        if (sum > n / 2) {
            return res;
        }
        return 0;
    }

    // 解法2
    public int MoreThanHalfNum_Solution2(int [] array) {
        if(array == null || array.length < 1)
            return 0;
        int cur = array[0];
        int sum = 1;
        for (int i = 1; i < array.length; i++) {
            if (sum == 0) {
                cur = array[i];
                sum = 1;
            } else if (array[i] == cur) {
                sum++;
            } else {
                sum--;
            }
        }
        sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == cur) {
                sum++;
            }
        }
        if(sum > array.length/2)
            return cur;
        return 0;
    }
}
