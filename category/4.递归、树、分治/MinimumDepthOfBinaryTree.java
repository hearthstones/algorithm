package leetcode.editor.cn;

/**
 * [111]二叉树的最小深度
 * @author luchao
 */
public class MinimumDepthOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new MinimumDepthOfBinaryTree().new Solution();
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
    /**
     * 主体：递归
     * 细节：叶子节点定义 —— 没有子节点的节点
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 下层递归
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        // 叶子节点的定义
        // 左右子树不是都存在：本层minDepth = 下层left + 下层right + 1。左\右子树不存在 => left\right = 0
        // 左右子树都存在：本层minDepth = 下层minDepth + 1
        return root.left == null || root.right == null ? left + right + 1 : Math.min(left, right) + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}