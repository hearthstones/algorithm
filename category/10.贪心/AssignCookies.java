package leetcode.editor.cn;

/**
 * [455]分发饼干
 * @author luchao
 */
public class AssignCookies {
    public static void main(String[] args) {
        Solution solution = new AssignCookies().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 思路：排序 + 贪心。孩子i（胃口g[i]）吃满足s[j] >= g[i]的最小s[j]，不满足则不吃
     */
    public int findContentChildren(int[] g, int[] s) {
        // 排序
        Arrays.sort(g);
        Arrays.sort(s);
        // 贪心
        int j = 0;
        int ans = 0;
        for (int i = 0; i < g.length; i++) {
            // g、s排序后，不满足前一个孩子的，也不能满足后面的孩子
            while (j < s.length && s[j] < g[i]) j++;
            // while循环后，满足当前孩子的最小s[j]，计数，并移动j指针
            if (j < s.length) {
                j++;
                ans++;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
