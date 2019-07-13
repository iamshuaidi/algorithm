package leetcode.dp;

public class NO72_Edit_Distance {
    // 方法1
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        if(n < 1)
            return m;
        if(m < 1)
            return n;
        int[][] dp = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                dp[i][j] = -1;
            }
        }

        return solve(word1, 0, n, word2, 0, m, dp);
    }

    private int solve(String word1,int i, int n, String word2, int j, int m, int[][] dp){
        if(i >= n && j >= m ){
            return 0;
        }
        if(i >= n && j < m){
            return m - j;
        }
        if(i < n && j >= m){
            return n - i;
        }
        if(dp[i][j] != -1)
            return dp[i][j];

        if(word1.charAt(i) == word2.charAt(j)){
            return solve(word1, i+1, n, word2, j+1, m, dp);
        }
        int t1 = solve(word1, i, n, word2, j + 1, m, dp) + 1;
        int t2 = solve(word1, i + 1, n, word2, j, m, dp) + 1;
        int t3 = solve(word1, i + 1, n, word2, j + 1, m, dp) + 1;
        dp[i][j] = Math.min(t1, t2);
        dp[i][j] = Math.min(t3, dp[i][j]);
        return dp[i][j];
    }

    // 方法2
    public int minDistance2(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n+1][m+1];

        for(int i = 0; i <= n; i++){
            dp[i][0] = i;
        }
        for(int i = 0; i <= m; i++){
            dp[0][i] = i;
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    int t1 = dp[i-1][j] + 1;
                    int t2 = dp[i][j-1] + 1;
                    int t3 = dp[i - 1][j - 1] + 1;
                    dp[i][j] = Math.min(t1, t2);
                    dp[i][j] = Math.min(t3, dp[i][j]);
                }
            }
        }

        return dp[n][m];
    }
}
