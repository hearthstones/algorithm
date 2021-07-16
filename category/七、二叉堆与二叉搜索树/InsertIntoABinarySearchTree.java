package leetcode.editor.cn;

/**
 * [701]二叉搜索树中的插入操作
 * @author luchao
 */
public class InsertIntoABinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new InsertIntoABinarySearchTree().new Solution();
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
     * 二叉搜索树的插入
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        // 终止条件
        if (root == null) {
            return new TreeNode(val);
        }
        // 左右子树
        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        }
        if (val > root.val) {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
