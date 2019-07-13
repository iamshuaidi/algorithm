package leetcode.dp;

public class NO91 {
    public int numDecodings(String s) {
        if(s.length() < 1 || s.charAt(0) == '0')
            return 0;

        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int i = 1; i <= n; i++){
            if(s.charAt(i-1) == '0'){
                if(s.charAt(i-2) == '0' || s.charAt(i-2) > '2'){
                    return 0;
                }else{
                    dp[i] += dp[i-2];
                }
            }else{
                dp[i] += dp[i-1];
                if(i > 1 && s.charAt(i-2) != '0' && (s.charAt(i-2) < '2' ||
                        s.charAt(i-2) == '2' && s.charAt(i-1) <= '6')){
                    dp[i] += dp[i-2];
                }
            }
        }
        return dp[n];

    }
}
