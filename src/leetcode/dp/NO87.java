package leetcode.dp;

public class NO87 {
    // 暴力递归
    public boolean isScramble(String s1, String s2) {
        if(s1.length() < 1)
            return true;

        return isScramble(s1, 0, s1.length() - 1, s2, 0, s2.length() - 1);
    }

    private boolean isScramble(String s1, int l1, int r1, String s2, int l2, int r2){
        if(l1 == r1)
            return s1.charAt(l1) == s2.charAt(l2);

        int[] count = new int[256];
        for(int i = l1, j = l2; i <= r1; i++, j++){
            count[s1.charAt(i)]++;
            count[s2.charAt(j)]--;
        }
        boolean flag = false;
        for(int i = 0; i < 256; i++){
            if(count[i] != 0){
                flag = true;
                break;
            }
        }
        if(flag) return false;
        for(int i = 0; i < r1 - l1; i++){
            if((isScramble(s1, l1, l1 + i, s2, l2, l2 + i) &&
                    isScramble(s1, l1 + i + 1, r1, s2, l2 + i + 1, r2)) ||
                    (isScramble(s1, l1, l1 + i, s2, r2 - i, r2) &&
                            isScramble(s1, l1 + i + 1, r1, s2, l2, r2 - i - 1))){
                return true;
            }
        }
        return false;
    }

    // dp
    public boolean isScramble2(String s1, String s2) {
        if(s1.length() < 1)
            return true;
        if(s1.length() != s2.length())
            return false;

        int n = s1.length();
        boolean[][][] dp = new boolean[n][n][n + 1];
        // init
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(s1.charAt(i) == s2.charAt(j)){
                    dp[i][j][1] = true;
                }
            }
        }

        for(int len = 2; len <= n; len++){
            for(int i = 0; i <= n - len; i++){
                for(int j = 0; j <= n - len; j++){
                    for(int k = 1; k < len; k++){
                        if((dp[i][j][k] && dp[i+k][j+k][len-k]) ||
                                dp[i][j+len-k][k] && dp[i+k][j][len-k]){
                            dp[i][j][len] = true;
                        }
                    }
                }
            }
        }
        return dp[0][0][n];
    }
}
