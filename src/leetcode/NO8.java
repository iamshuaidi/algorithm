package leetcode;

public class NO8 {

    public int myAtoi(String str) {
        if(str == null){
            return 0;
        }
        int i = 0;//用来遍历字符串
        int flag = 1;
        long num = 0;

        //去除空格
        while(i < str.length() && str.charAt(i) == ' '){
            i++;
        }
        if(i < str.length() && str.charAt(i) == '-'){
            i++;
            flag = -1;
        }else if(i < str.length() && str.charAt(i) == '+'){
            i++;
            flag = 1;
        }

        while(i < str.length()){
            if(str.charAt(i) <= '9'&&str.charAt(i)>= '0'){
                num = num * 10 + (str.charAt(i) - 48)*flag;
                i++;
            }else{
                break;
            }
            //本来是放到最后来判断的，但是发现这个值还有可能超出long范围
            if(num > Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }else if(num < Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }
        }
        return (int)num;
    }

    public int myAtoi2(String str) {
        if(str == null )return 0;

        int len = str.length();//由于多次用到，用一个变量存起来
        int i = 0;//用来遍历字符串
        int flag = 1;//用来判断正负数
        long num = 0;//存放目标数
        char[] arr = str.toCharArray();
        //去除空格
        while(i < len && arr[i] == ' ')i++;
        //判断正负数
        if(i < len && (arr[i] == '-' || arr[i] == '+')){
            flag = arr[i]=='-'? -1 : 1;
            i++;
        }

        while(i < len){
            if(arr[i] <= '9'&&arr[i]>= '0'){
                num = num * 10 + (arr[i] - '0')*flag;
                i++;
            }else{
                break;
            }
            //本来是放到最后来判断的，但是发现这个值还有可能超出long范围
            if(num > Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }else if(num < Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }
        }
        return (int)num;
    }

    public static void main(String[] args){

    }
}
