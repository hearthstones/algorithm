package leetcode.editor.cn;

import javax.swing.tree.TreeNode;
import java.util.HashMap;

/**
 * [337]打家劫舍 III
 * @author luchao
 */
public class HouseRobberIii {
    public static void main(String[] args) {
        Solution solution = new HouseRobberIii().new Solution();
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
    // key - 结点，value - dp[0]、dp[1]
    private Map<TreeNode, int[]> map;

    /**
     * 特征：树形DP
     *
     * 思路：树形DP
     * 1.定义状态：
     *   dp[x][j], x - 以x为根的子树，j - 0(不偷)、1(偷)
     *   x无法作为数组下标，该状态使用map存储
     * 2.转移方程：
     *   dp[x][0] = max(dp[x.left][0], dp[x.left][1]) + max(dp[x.right][0], dp[x.right][1])
     *   dp[x][1] = x.val + dp[x.left][0] + dp[x.right][0]
     * 3.边界：x == null
     * 4.目标：max(dp[root][0], dp[root][1])
     */
    public int rob(TreeNode root) {
        this.map = new HashMap<>();
        return dfs(root);
    }

    // dfs
    private int dfs(TreeNode x) {
        // 终止条件
        if (x == null) return 0;
        // x - dp[j], 0(不偷)、1(偷)
        int[] dp = new int[2];
        map.put(x, dp);
        if (x.left != null) {
            dp[0] += dfs(x.left);
            dp[1] += map.get(x.left)[0];
        }
        if (x.right != null) {
            dp[0] += dfs(x.right);
            dp[1] += map.get(x.right)[0];
        }
        dp[1] += x.val;
        return Math.max(dp[0], dp[1]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
