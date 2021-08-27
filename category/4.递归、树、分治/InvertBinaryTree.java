package leetcode.editor.cn;

/**
 * [226]翻转二叉树
 * @author luchao
 */
public class InvertBinaryTree {
    public static void main(String[] args) {
        Solution solution = new InvertBinaryTree().new Solution();
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
     * 特征：翻转二叉树
     * 主体：递归。root、left、right
     */
    public TreeNode invertTree(TreeNode root) {
        // 终止条件
        if (root == null) {
            return null;
        }
        // 本层逻辑 - 翻转
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        // 下层递归
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}