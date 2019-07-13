package 剑指offer;

public class 二叉搜索树与双向链表{
        TreeNode leftLast;
        public TreeNode Convert(TreeNode pRootOfTree) {
            if(pRootOfTree == null)
                return pRootOfTree;
            if (pRootOfTree.left == null && pRootOfTree.right == null) {
                leftLast = pRootOfTree;
                return pRootOfTree;
            }
            TreeNode left = Convert(pRootOfTree.left);
            if (left != null) {
                leftLast.right = pRootOfTree;
                pRootOfTree.left = leftLast;
            }
            leftLast = pRootOfTree;

            TreeNode right = Convert(pRootOfTree.right);
            if (right != null) {
                right.left = pRootOfTree;
                pRootOfTree.right = right;
            }
            return left != null ? left : pRootOfTree;
        }



}
