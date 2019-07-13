package 剑指offer;

import java.util.*;

public class 二叉树的先序遍历 {
    // 递归版
    static List<Integer> res = new ArrayList<>();
    public static  void preOderTraversal(TreeNode root) {
        if (root != null) {
            res.add(root.val);
            preOderTraversal(root.left);
            preOderTraversal(root.right);
        }
    }

    // 迭代版
    static List<Integer> preOderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root == null)
            return result;
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode tmp = stack.pop();
            result.add(tmp.val);
            if(tmp.right != null)
                stack.push(tmp.right);
            if(tmp.left != null)
                stack.push(tmp.right);
        }
        return result;
    }

    // 中序遍历
    public List<Integer> inOderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }

    // 后序遍历
    public List<Integer> postOderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();// 注意，采用链表
        Stack<TreeNode> stack = new Stack<>();
        if(root == null)
            return res;
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode tmp = stack.pop();
            if(tmp.left != null)
                stack.push(tmp.left);
            if(tmp.right != null)
                stack.push(tmp.right);
            // 注意，是放在第一个位置
            res.addFirst(tmp.val);
        }
        return res;
    }

    //
}
