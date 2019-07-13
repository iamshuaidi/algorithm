package 剑指offer;

import java.util.ArrayList;
import java.util.Collections;

public class x二叉树中和为某一值的路径 {
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    ArrayList<Integer> list = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        solve(root, target);
        if(res.size() < 2)
            return res;
        // 进行排序
        ArrayList<ArrayList<Integer>> tmp = new ArrayList<>(res.size());
        while (res.size() > 0) {
            ArrayList<Integer> t = res.get(0);
            for (int i = 1; i < res.size(); i++) {
                if (t.size() < res.get(i).size()) {
                    t = res.get(i);
                }
            }
            tmp.add(t);
            res.remove(t);
        }

        return tmp;
    }
    private void solve(TreeNode root, int target) {
        if (root == null) return;

        target -= root.val;
        list.add(root.val);
        if (target == 0 && root.left == null && root.right == null) {
            res.add(new ArrayList<>(list));
        }
        solve(root.left, target);
        solve(root.right, target);
        list.remove(list.size() - 1);
    }

}
