package leetcode;

public class NO43MultyplyStrings {
    public static String multiply(String num1, String num2) {
        int n1 = num1.length();
        int n2 = num2.length();
        int [] res = new int[n1+n2];
        int cin = 0;// 表示进位
        for(int i = n1 - 1; i >= 0; i--){
            for(int j = n2 - 1; j >= 0; j--){
                int t = (num1.charAt(i)-'0')*(num2.charAt(j)-'0');
                res[i+j+1] += t % 10 + cin;
                cin = t / 10 + res[i+j+1] / 10;
                res[i+j+1] = res[i+j+1] % 10;
            }
            res[i] = cin;
            cin = 0;
        }
        StringBuilder build = new StringBuilder();
        int k = 0;
        while(k < n1+n2 && res[k] == 0)
            k++;
        if(k >= n1 + n2)
            return "0";

        for(int i = k; i < n1 + n2; i++){
            build.append(res[i]);
        }
        return build.toString();
    }

    public static void main(String[] args) {
        System.out.println(multiply("0","456"));
    }
}
