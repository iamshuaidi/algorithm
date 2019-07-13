package leetcode.dp;

public class NO10 {

    public boolean isMatch(String s, String p) {
        if(s == null || p == null)
            return false;
        if(s.length() >= 1 && p.length() < 1)
            return false;
        int i = 0;
        int j = 0;
        int arr[] = new int[10];
        return match(s, i, p, j);
    }



    public  boolean match(String s, int i, String p, int j){
        //先验证是否匹配结束
        //同时都到结尾了
        if(i >= s.length() && j >= p.length())
            return true;
        //s还没结尾，但p到达结尾了
        if(i < s.length() && j >= p.length())
            return false;

        //如果下一个字符不是*，或者这个字符就是最后一个字符了，则直接匹配
        if(j+1<p.length() && p.charAt(j+1)!='*' || p.length()==j+1){
            if(i<s.length() && (s.charAt(i)==p.charAt(j)||p.charAt(j)=='.'))
                return match(s,i+1, p, j+1);
            else
                return false;
        }else{
            //下一个字符是*，则分为两种种情况
            //1.如果当前字符不匹配(或者s已经越界了)，
            // 则p字符移动2位，而s不移动
            if((i<s.length()&&s.charAt(i)!=p.charAt(j)&&p.charAt(j)!='.') || i == s.length())
                return match(s, i, p, j+2);
            //2.如果当前字符匹配的话，分两种情况讨论
            else{
                //(1).匹配0个字符,则p直接移动2位,s不移动
                //(2).匹配一个，s移动一位，p移动两位
                //(3),匹配多个，s移动一位，p不移动
                return match(s, i, p, j+2) || match(s, i+1, p, j) ||
                        match(s, i+1, p, j+2);
            }
        }
    }

    //采用动态规划的方法
    public boolean isMatch1(String s, String p){
        if(s == null || p == null)
            return false;
        int len_s = s.length();
        int len_p = p.length();
        //存放状态
        boolean[][]dp = new boolean[len_s+1][len_p+1];
        //初始化
        dp[0][0] = true;
        for(int i = 1; i <= len_p; i++){
            if(p.charAt(i-1) == '*')
                dp[0][i] = dp[0][i-2];
        }
        for(int i = 1; i <= len_s; i++){
            for(int j = 1; j <= len_p; j++){
                //如果不为‘*’且匹配
                if(p.charAt(j-1)=='.'||p.charAt(j-1)==s.charAt(i-1))
                    dp[i][j] = dp[i-1][j-1];
                //如果是*
                else if(p.charAt(j-1)=='*'){
                    //如果p中*号前面的字符与s当前字符不匹配，则匹配0个
                    if(j!=1&&p.charAt(j-2)!='.'&&p.charAt(j-2)!=s.charAt(i-1)){
                        dp[i][j] = dp[i][j-2];
                    }else{
                        //否则有三种情况：
                        //匹配0个，匹配1个，匹配多个
                        dp[i][j] = dp[i][j-2] || dp[i][j-1]||dp[i-1][j];
                    }
                }
            }
        }
        return dp[len_s][len_p];
    }
}
