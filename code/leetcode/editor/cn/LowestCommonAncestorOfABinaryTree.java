package leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;

/**
 * [236]二叉树的最近公共祖先
 * @author luchao
 */
public class LowestCommonAncestorOfABinaryTree {
    public static void main(String[] args) {
        Solution solution = new LowestCommonAncestorOfABinaryTree().new Solution();
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
    // 全局
    private Map<Integer, TreeNode> fatherMap;

    /**
     * 特征：pq的最近公共祖先、所有node.val各不相同（哈希表存储）
     * 主体：1.哈希表存储所有节点的父节点；2.p往上走到根，路径即p的所有祖先，标红；3.q往上走，遇到的第一个red节点即最近公共祖先。
     * 细节：node.val各不相同
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.fatherMap = new HashMap<>();
        // 1.dfs存储所有节点的父节点
        father(root);
        // 2.p往上走到根，标红所有祖先
        Set<TreeNode> redSet = new HashSet<>();
        redSet.add(p);
        while(p != root) {
            p = fatherMap.get(p.val);
            redSet.add(p);
        }
        // 3.q往上走，返回遇到的第一个red节点
        while(!redSet.contains(q)) {
            q = fatherMap.get(q.val);
        }
        return q;
    }

    // dfs存储所有节点的父节点
    private void father(TreeNode root) {
        // 终止条件
        if (root == null) {
            return;
        }
        // 左右子树
        if (root.left != null) {
            fatherMap.put(root.left.val, root);
            father(root.left);
        }
        if (root.right != null) {
            fatherMap.put(root.right.val, root);
            father(root.right);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
