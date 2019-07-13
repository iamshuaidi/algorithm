package 剑指offer;

public class 树的子结构 {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if (root2 == null || root1 == null) {
            return false;
        }
        // 判断 B 是否为 A 的子结构
        return isSubTree(root1, root2);
    }

    // 判断 B 是否为 A 的子结构
  private boolean isSubTree(TreeNode root1, TreeNode root2) {
      if (root1 == null) {
          return false;
      }// 以root1为root2的根节点，判断子结构是否成立
      if (judge(root1, root2)) {
          return true;
      } else {
          // 如果root1作为起点不行，则递归判断左右节点
          return isSubTree(root1.left, root2) || isSubTree(root1.right, root2);
      }
    }
    // 以root1为root2的根节点，判断子结构是否成立
    private boolean judge(TreeNode root1, TreeNode root2) {
        if(root2 == null)
            return true;
        if(root1 == null)
            return false;
        if(root1.val == root2.val)
            return judge(root1.left, root2.left) && judge(root1.right, root2.right);

        return false;
    }
}
