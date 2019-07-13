package 剑指offer;

 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }


public class 重建二叉树 {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        TreeNode root;
        root = rebuildTree(pre, 0, pre.length - 1, in, 0, in.length - 1);

        return root;
    }
    // preStart-preEnd表示前序序列的起始位置，inStart-inEnd也一样
    private TreeNode rebuildTree(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {
        if(preStart > preEnd | inStart > inEnd)
            return null;
        // 根节点
        TreeNode root = new TreeNode(pre[preStart]);
        // 寻找根节点在中序序列的位置
        for (int i = inStart; i <= inEnd; i++) {
            if (in[i] == pre[preStart]) {
                // 可以计算出中序序列的左右子树序列为:左：inStart~i -1，右：i+1~inEnd。
                // 前序序列的左右子树：左：preStart+1~preStart+i-inStart，右：preStart+i-inStart+1~preEnd
                root.left = rebuildTree(pre,preStart+1, preStart+i-inStart,in, inStart, i - 1);
                root.right = rebuildTree(pre,preStart+i-inStart+1, preEnd, in, i+1, inEnd);
            }
        }
        return root;
    }
}
