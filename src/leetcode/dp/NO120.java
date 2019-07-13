package leetcode.dp;

import java.util.List;

public class NO120 {
    public int minimumTotal(List<List<Integer>> triangle) {

        int n = triangle.size();
        int[][] dp = new int[n][n];

        for(int i = 0; i < n; i++){
            dp[n-1][i] = triangle.get(n-1).get(i);
        }

        for(int i = n - 2; i >= 0; i--){
            for(int j = i; j >= 0; j--){
                dp[i][j] = triangle.get(i).get(j);
                dp[i][j] += dp[i+1][j+1] > dp[i+1][j] ? dp[i+1][j] : dp[i+1][j+1];
            }
        }

        return dp[0][0];
    }
    // 优化版本
    public int minimumTotal2(List<List<Integer>> triangle) {

        int n = triangle.size();
        int[] dp = new int[n];

        for(int i = 0; i < n; i++){
            dp[i] = triangle.get(n-1).get(i);
        }

        for(int i = n - 2; i >= 0; i--){
            for(int j = 0; j <= i; j++){
                if(dp[j] < dp[j+1]){
                    dp[j] = dp[j] + triangle.get(i).get(j);
                }else{
                    dp[j] = dp[j+1] + triangle.get(i).get(j);
                }
            }
        }

        return dp[0];
    }
}
