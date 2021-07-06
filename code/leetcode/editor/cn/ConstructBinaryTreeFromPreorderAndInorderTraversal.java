package leetcode.editor.cn;

/**
 * [105]从前序与中序遍历序列构造二叉树
 * @author luchao
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // 全局
    private int[] preorder;
    private int[] inorder;

    /**
     * 一、推导：
     * [3,9,20,15,7] preorder
     * [9,3,15,20,7] inorder
     * 1.前序确定root，中序确定左右子树
     * [3 | 9 | 20,15,7]
     * [9 | 3 | 15,20,7]
     * 2.递归处理子树
     *
     * 二、主体：DFS
     * 三、细节：决定空间状态变化的参数 pre<start, end>、in<start, end>
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        return dfs(0, preorder.length - 1, 0, inorder.length - 1);
    }

    /**
     * DFS
     *
     * @param preStart 前序 start index
     * @param preEnd 前序 end index
     * @param inStart 中序 start index
     * @param inEnd 中序 end index
     * @return 子树root
     */
    private TreeNode dfs(int preStart, int preEnd, int inStart, int inEnd) {
        // 终止条件
        if (preStart > preEnd) {
            return null;
        }
        // 空间状态变化
        // [3 | 9,20,15,7] 前序找root
        // [9 | 3 | 15,20,7] 中序找左右子树
        TreeNode root = new TreeNode(preorder[preStart]);
        // 中序分割点index
        int split = inStart;
        while(inorder[split] != root.val) {
            split++;
        }
        // 左右子树
        int leftSize = split - inStart;
        root.left = dfs(preStart + 1, preStart + leftSize, inStart, split - 1);
        root.right = dfs(preStart + leftSize + 1, preEnd, split + 1, inEnd);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
