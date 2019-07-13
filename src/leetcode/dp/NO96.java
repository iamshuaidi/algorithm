package leetcode.dp;

public class NO96 {
    // 递归状态保存
    public int numTrees(int n) {
        if(n <= 1)
            return n;
        int dp[][] = new int[n+1][n+1];
        return numTrees(1, n, dp);
    }

    private int numTrees(int start, int end, int[][] dp){
        if(start > end)
            return 1;
        if(dp[start][end] != 0)
            return dp[start][end];
        int sum = 0;
        for(int root = start; root <= end; root++){
            int left = numTrees(start, root - 1, dp);
            int right = numTrees(root + 1, end, dp);
            sum += left * right;
        }
        dp[start][end] = sum;
        return sum;
    }

    // dp
    public int numTrees2(int n) {
        if(n <= 1)
            return n;
        int[] dp = new int[n+1];
        dp[0] = dp[1] = 1;
        for(int i = 2; i <= n; i++){
            for(int j = 1; j <= i; j++){
                dp[i] += dp[j-1] * dp[i-j];
            }
        }
        return dp[n];
    }
}
