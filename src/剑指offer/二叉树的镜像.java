package 剑指offer;

public class 二叉树的镜像 {
    public void Mirror(TreeNode root) {
        if(root == null)
            return;
        root = solve(root);
    }
    private TreeNode solve(TreeNode root) {
        if(root == null)
            return root;
        // 递归先把左右节点镜像化
        TreeNode left = solve(root.left);
        TreeNode right = solve(root.right);
        // 对左右子树镜像
        root.left = right;
        root.right = left;
        return root;
    }
}
