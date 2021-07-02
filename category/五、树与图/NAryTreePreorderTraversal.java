package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
 * [589]N叉树的前序遍历
 * @author luchao
 */
public class NAryTreePreorderTraversal {
    public static void main(String[] args) {
        Solution solution = new NAryTreePreorderTraversal().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    // 全局
    private List<Integer> ans;

    /**
     * 主体：递归。二叉树的前序遍历 -> N叉树的前序遍历
     */
    public List<Integer> preorder(Node root) {
        this.ans = new ArrayList<>();
        recur(root);
        return ans;
    }

    // 递归方法
    private void recur(Node root) {
        // 终止条件
        if (root == null) {
            return;
        }
        // 本层逻辑
        ans.add(root.val);
        // 下层递归
        for (Node child : root.children) {
            recur(child);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
