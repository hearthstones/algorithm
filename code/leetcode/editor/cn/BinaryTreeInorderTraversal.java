package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * [94]二叉树的中序遍历
 * @author luchao
 */
public class BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeInorderTraversal().new Solution();
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
    private List<Integer> ans;

    /**
     * 主体：中序遍历。递归 - 左、中、右
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        this.ans = new ArrayList<>();
        recur(root);
        return ans;
    }

    // 递归方法
    private void recur(TreeNode root) {
        if (root == null) {
            return;
        }
        recur(root.left);
        ans.add(root.val);
        recur(root.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
