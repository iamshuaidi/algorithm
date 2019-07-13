package leetcode.dp;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }

public class NO95 {
    // brute force
    public List<TreeNode> generateTrees(int n) {
        if(n < 1)
            return new ArrayList<>();
        return generateTrees(1, n);
    }


    private List<TreeNode> generateTrees(int start, int end){
        List<TreeNode> res = new ArrayList<>();
        if(start > end){
            res.add(null);
            return res;
        }

        for(int rootValue = start; rootValue <= end; rootValue++){
            List<TreeNode> leftSubTrees = generateTrees(start, rootValue - 1);
            List<TreeNode> rightSubTrees = generateTrees(rootValue + 1, end);

            for(TreeNode l : leftSubTrees){
                for(TreeNode r : rightSubTrees){
                    TreeNode root = new TreeNode(rootValue);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }
        }
        return res;
    }

    // dp
}
