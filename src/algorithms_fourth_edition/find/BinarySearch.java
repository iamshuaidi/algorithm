package algorithms_fourth_edition.find;

public class BinarySearch {

    public static int binarySearch(int target, int[] arr) {
        // 数组最左边元素下标
        int left = 0;
        // 数组最右边元素下标
        int right = arr.length - 1;
        while (left <= right) {
            // 中间元素下标
            int mid = (right + left) / 2;
            if (arr[mid] > target) {
                right = mid - 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                return arr[mid];
            }
        }
        return -1;
    }
}
