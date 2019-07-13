package 剑指offer;

import com.sun.xml.internal.bind.v2.model.core.ID;

public class 二叉树的后序序列 {
    public static boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence == null || sequence.length < 1)
            return false;
        return judge(sequence, 0, sequence.length - 1);
    }

    private static boolean judge(int[] sequence, int left, int right) {
        // 只有一个节点，递归结束
        if(left >= right)
            return true;
        // 最右边的节点相当于根节点
        int t = sequence[right];
        // 用来记录序列中第一个比根节点大节点的下标
        int index = right;
        for (int i = left; i <= right - 1; i++) {
            // 找到根节点的右孩子
            if (sequence[i] > t) {
                index = i;
                i++;
                // 如果右子树中有比根节点还小的树的话，显然是不成立的。
                while (i <= right - 1) {
                    if(sequence[i] < t)
                        return false;
                    i++;
                }
            }
        }
        // 递归检查左右子树
        return judge(sequence, left, index - 1) && judge(sequence,index, right - 1);
    }

    public static void main(String[] args) {
        int[] tt = {3, 5, 4, 7, 9, 8, 6};
        System.out.println();
    }
}
