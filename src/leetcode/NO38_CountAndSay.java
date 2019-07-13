package leetcode;

public class NO38_CountAndSay {
    public String countAndSay(int n) {
        return solve("1", n - 1);
    }

    private String solve(String str, int n){
        if(n == 0)
            return str;

        StringBuilder build = new StringBuilder();
        for(int i = 0; i < str.length(); i++){
            int t = 1;
            while(i + 1 < str.length() && str.charAt(i) == str.charAt(i + 1)){
                i++;
                t++;
            }
            build.append(t);
            build.append(str.charAt(i));
        }
        return solve(build.toString(), n - 1);
    }

    public static void main(String[] args) {
        NO38_CountAndSay s = new NO38_CountAndSay();
        System.out.println(s.countAndSay(4));
    }

}
