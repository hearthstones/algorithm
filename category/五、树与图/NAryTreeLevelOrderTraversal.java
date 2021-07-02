package leetcode.editor.cn;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * [429]N叉树的层序遍历
 * @author luchao
 */
public class NAryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new NAryTreeLevelOrderTraversal().new Solution();
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
    /**
     * 特征：N叉树、层次遍历、ans结构包含层次信息
     * 主体：队列 - Deque<Pair<Node, Integer>>
     * 细节：记录层次信息
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        // 队列，元素 - <结点, 所在层次>
        Deque<Pair<Node, Integer>> deque = new LinkedList<>();
        deque.offer(new Pair<Node, Integer>(root, 0));
        while(!deque.isEmpty()) {
            // 出队
            Pair<Node, Integer> pair = deque.poll();
            Node node = pair.getKey();
            int depth = pair.getValue();
            // ans的index范围为 [0, depth] => ans.size() = depth + 1
            // ans.size() < depth + 1时，先在ans中加一个链表
            if (ans.size() < depth + 1) {
                ans.add(new ArrayList<Integer>());
            }
            ans.get(depth).add(node.val);
            // 子节点入队
            for (Node child : node.children) {
                deque.offer(new Pair<Node, Integer>(child, depth + 1));
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
