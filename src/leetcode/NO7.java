package leetcode;

public class NO7 {
    public int reverse(int x) {
        //标记正负数
        boolean flag = false;
        //存放反转后的数
        long y = 0;
        if(x < 0){
            flag = true;
            x = -x;
        }
        //进行反转
        while(x > 0){
            y = y * 10 + x % 10;
            x = x / 10;
        }
        if(flag)
            y = -y;

        if(y > Math.pow(2,31) - 1 || y < Math.pow(-2,31)){
            return 0;
        }else{
            return (int)y;
        }
    }

    public static void main(String[] args){
        Integer i = 3;
        Long l = 3l;
        System.out.println(i.equals(2 + 1.0));

    }

}
