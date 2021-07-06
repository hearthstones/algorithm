package leetcode.editor.cn;

import java.util.*;

/**
 * [17]电话号码的字母组合
 * @author luchao
 */
public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 全局
    private List<String> ans;
    private StringBuilder per;
    private char[] digitArr;
    private Map<Character, String> edges;

    /**
     * 特征：2~9、每次从数字对应的字母数组中选择一个字母
     * 主体：DFS, 模拟出状态空间
     * 细节：1.实际问题抽象成dfs；2.per的数据结构
     */
    public List<String> letterCombinations(String digits) {
        this.ans = new ArrayList<>();
        this.per = new StringBuilder();
        this.digitArr = digits.toCharArray();
        if (digitArr.length == 0) {
            return ans;
        }
        // init data
        this.edges = new HashMap<>(8);
        edges.put('2', "abc");
        edges.put('3', "def");
        edges.put('4', "ghi");
        edges.put('5', "jkl");
        edges.put('6', "mno");
        edges.put('7', "pqrs");
        edges.put('8', "tuv");
        edges.put('9', "wxyz");
        // dfs
        dfs(0);
        return ans;
    }

    // dfs
    private void dfs(int depth) {
        // 终止条件
        if (depth == digitArr.length) {
            ans.add(per.toString());
            return;
        }
        // 状态空间
        String edge = edges.get(digitArr[depth]);
        for (char ch : edge.toCharArray()) {
            per.append(ch);
            dfs(depth + 1);
            per.deleteCharAt(per.length() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
