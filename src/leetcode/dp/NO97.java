package leetcode.dp;

public class NO97 {
    // 暴力递归，其他可以状态保存
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s3.length() != s1.length() + s2.length())
            return false;
        return isInterleave(s1, 0, s2, 0, s3, 0);
    }
    private boolean isInterleave(String s1, int i, String s2, int j, String s3, int k){
        if(i >= s1.length() && j >= s2.length())
            return true;
        if(i >= s1.length()){
            if(s2.charAt(j) == s3.charAt(k))
                return isInterleave(s1, i, s2, j + 1, s3, k + 1);
            else
                return false;
        }
        if(j >= s2.length()){
            if(s1.charAt(i) == s3.charAt(k))
                return isInterleave(s1, i + 1, s2, j, s3, k + 1);
            else
                return false;
        }

        if(s1.charAt(i) != s3.charAt(k) && s2.charAt(j) != s3.charAt(k)){
            return false;
        }else if(s1.charAt(i) == s3.charAt(k) && s2.charAt(j) == s3.charAt(k)){
            return isInterleave(s1, i + 1, s2, j, s3, k + 1) || isInterleave(s1, i, s2, j + 1, s3, k + 1);
        }else if(s1.charAt(i) == s3.charAt(k)){
            return isInterleave(s1, i + 1, s2, j, s3, k + 1);
        }else{
            return isInterleave(s1, i, s2, j + 1, s3, k + 1);
        }
    }
}
