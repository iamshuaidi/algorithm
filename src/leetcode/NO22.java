package leetcode;
import java.util.ArrayList;
import java.util.List;

public class NO22 {
    public static List<String> generateParenthesis(int n) {
        StringBuilder builder = new StringBuilder();
        List<String> result = new ArrayList<>();
        combination(builder, result, 0, 0, 0, n);
        return result;
    }

    //right表示当前')'的个数，left表示'('的个数。index = left + right
    private static void combination(StringBuilder builder, List<String> result, int left,
                             int right, int index, int n){
        if (index == 2 * n && right == left) {
            result.add(builder.toString());
        } else {
            if (left > right) {
                builder.append(')');
                combination(builder, result, left, right+1, index+1, n);
                builder.deleteCharAt(index);
                if(left < n){
                    builder.append('(');
                    combination(builder, result, left+1, right, index+1, n);
                    builder.deleteCharAt(index);
                }
            } else if (left == right) {
                builder.append('(');
                combination(builder, result, left+1, right, index+1, n);
                builder.deleteCharAt(index);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}
