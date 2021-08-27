package leetcode.editor.cn;

/**
 * [104]二叉树的最大深度
 * @author luchao
 */
public class MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new MaximumDepthOfBinaryTree().new Solution();
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
     * 主体：递归。本层 maxDepth = 下层 maxDepth + 1
     * 细节：bottom-top
     */
    public int maxDepth(TreeNode root) {
        // 终止条件
        if (root == null) {
            return 0;
        }
        // 本层逻辑 - 下层 maxDepth + 1
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}