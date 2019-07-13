package bitmap;

import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;

public class Test {
    //为了方便，假设数据是以数组的形式给我们的
    public static Set<Integer> test(int[] arr) {
        int j = 0;
        //用来把重复的数返回，存在Set里，这样避免返回重复的数。
        Set<Integer> output = new HashSet<>();
        BitSet bitSet = new BitSet(Integer.MAX_VALUE);
        int i = 0;
        while (i < arr.length) {
            int value = arr[i];
            //判断该数是否存在bitSet里
            if (bitSet.get(value)) {
                output.add(value);
            } else {
                bitSet.set(value, true);
            }
            i++;
        }
        return output;
    }
    //测试
    public static void main(String[] args) {
        int[] t = {1,2,3,4,5,6,7,8,3,4};
        Set<Integer> t2 = test(t);
        System.out.println(t2);
    }
}
