package leetcode.editor.cn;

/**
 * [106]从中序与后序遍历序列构造二叉树
 * @author luchao
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();
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
    private int[] postorder;
    private int[] inorder;

    /**
     * 一、推导
     * 1.init
     * [9,3,15,20,7] inorder 中序找子树
     * [9,15,7,20,3] postorder 后序找root
     * 2.split
     * [9 | 3 | 15,20,7]
     * [9,15,7,20 | 3]
     *
     * 二、主体：DFS, 递归
     * 三、细节：引起状态空间变化的参数 post<l1, r1>, in<l2, r2>
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        this.inorder = inorder;
        return dfs(0, postorder.length - 1, 0, inorder.length - 1);
    }

    /**
     * DFS
     * 子树: postorder范围 [l1, r1], inorder范围 [l2, r2]
     */
    private TreeNode dfs(int l1, int r1, int l2, int r2) {
        // 终止条件
        if (l1 > r1) {
            return null;
        }
        // 状态空间变化
        TreeNode root = new TreeNode(postorder[r1]);
        // 找到左右子树大小
        // [9,15,7,20 | 3]
        // [9 | 3 | 15,20,7]
        int split = l2;
        while(inorder[split] != root.val) {
            split++;
        }
        int leftSize = split - l2;
        // 递归构造左右子树
        root.left = dfs(l1, l1 + leftSize - 1, l2, split - 1);
        root.right = dfs(l1 + leftSize, r1 - 1, split + 1, r2);

        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
