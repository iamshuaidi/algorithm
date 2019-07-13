package algorithms_fourth_edition.find.sort;

import java.util.Arrays;

public interface Test {

    public static void main(String[] args) {
        int[] arr = { 1,5,4,3,2,1};

        arr = Quick.sort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }
}
