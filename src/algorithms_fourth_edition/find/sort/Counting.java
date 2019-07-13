package algorithms_fourth_edition.find.sort;

public class Counting {
    public static int[] sort(int[] arr) {
        if(arr == null || arr.length < 2) return arr;

        int n = arr.length;
        int min = arr[0];
        int max = arr[0];
        // 寻找数组的最大值与最小值
        for (int i = 1; i < n; i++) {
            if(max < arr[i])
                max = arr[i];
            if(min > arr[i])
                min = arr[i];
        }
        int d = max - min + 1;
        //创建大小为max的临时数组
        int[] temp = new int[d];
        //统计元素i出现的次数
        for (int i = 0; i < n; i++) {
            temp[arr[i] - min]++;
        }
        int k = 0;
        //把临时数组统计好的数据汇总到原数组
        for (int i = 0; i < d; i++) {
            for (int j = temp[i]; j > 0; j--) {
                arr[k++] = i + min;
            }
        }
        return arr;
    }
}
