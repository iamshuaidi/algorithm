package bitmap;

public class BitMap {
    private byte[] arr;
    //容量，即最多能够存多少个数据
    private int capacity;

    public BitMap(int capacity) {
        this.capacity = capacity;
        //一个byte可以存8个数据，capacity实际上指的是多少个bit
        arr = new byte[(capacity / 8 + 1)];
    }

    //添加数据的操作

    public void add(int n){
        //用>>的操作是，运算会比较快
        int index = n >> 3;
        int position = n & 0x07;
        //把1右移和做or操作两步一起
        //即 << 对应上图的右移，实际上<<是左移符。
        arr[index] |= 1 << position;
    }

    public void delete(int n){
        int index = n >> 3;
        int position = n & 0x07;
        arr[index] &= ~(1 << position);
    }

    public boolean contain(int n){
        int index = n >> 3;
        int position = n & 0x07;
        return (arr[index] & (1 << position)) != 0;
    }
}
