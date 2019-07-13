package 剑指offer;

public class 二维数组查找 {
    public boolean Find(int target, int [][] array) {
        if(array == null)return false;
        int row = array.length - 1;
        int col = array[0].length - 1;
        int j = 0;
        while (row >= 0 && j <= col) {
            if (array[row][j] > target) {
                row--;
            } else if (array[row][j] < target) {
                j++;
            } else {
                return true;

            }
        }
        return false;
    }

    public static void main (String[] args) {
        int i = 0;
        while (true) {
            for(i =  0; i < 9600000; i++);
            try {
                Thread.sleep(10);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
