package leetcode.editor.cn;

/**
 * [面试题 04.06]后继者
 * @author luchao
 */
public class SuccessorLcci {
    public static void main(String[] args) {
        Solution solution = new SuccessorLcci().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    /**
     * BST查找后继
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // 终止条件
        if (root == null) {
            return null;
        }
        // 当前节点 <= 目标值，后继一定在右子树
        if (root.val <= p.val) {
            return inorderSuccessor(root.right, p);
        } else {  // 当前节点 > 目标值，尝试往左子树走，
            TreeNode ans = inorderSuccessor(root.left, p);
            return ans == null ? root : ans;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
