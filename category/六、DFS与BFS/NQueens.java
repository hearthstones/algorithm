package leetcode.editor.cn;

import java.util.*;

/**
 * [51]N皇后
 * @author luchao
 */
public class NQueens {
    public static void main(String[] args) {
        Solution solution = new NQueens().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 全局
    private List<List<String>> ans;
    private List<String> per;
    private int n;
    // 标记皇后所在的列
    private boolean[] usedCol;
    // 标记皇后所在的斜线
    private Map<Integer, Boolean> usedIPlusJ;
    private Map<Integer, Boolean> usedIMinusJ;

    /**
     * 特征：N皇后问题
     * 主体：DFS，每一行选一个位置放置皇后 + 不互相攻击 => 全排列 + 过滤条件
     * 细节：过滤条件 - 不同行、不同列、不同斜线
     * 元素下标(row, column)，对角线规律如下：
     *   1.'/'形，[(i, j), (i-1, j+1), (i-2, j+2), ...], 同一斜线下标之和 = i + j
     *   2.'\'形，[(i, j), (i+1, j+1), (i+2, j+2), ...], 同一斜线下标之差 = i - j
     */
    public List<List<String>> solveNQueens(int n) {
        // init
        this.ans = new ArrayList<>();
        this.per = new ArrayList<>();
        this.n = n;
        this.usedCol = new boolean[n];
        this.usedIPlusJ = new HashMap<>();
        this.usedIMinusJ = new HashMap<>();
        // dfs
        dfs(0);
        return ans;
    }

    // dfs
    private void dfs(int row) {
        // 终止条件
        if (row == n) {
            ans.add(new ArrayList<>(per));
            return;
        }
        char[] temp = new char[n];
        Arrays.fill(temp, '.');
        // 状态空间
        for (int col = 0; col < n; col++) {
            // 过滤条件：不同列、不同斜线（两条）
            if (usedCol[col] || usedIPlusJ.getOrDefault(row + col, false) || usedIMinusJ.getOrDefault(row - col, false)) {
                continue;
            }
            // 标记皇后所在的列、斜线为已使用
            usedCol[col] = true;
            usedIPlusJ.put(row + col, true);
            usedIMinusJ.put(row - col, true);
            // 状态空间变化
            temp[col] = 'Q';
            per.add(new String(temp));
            temp[col] = '.';
            dfs(row + 1);
            // 回溯还原
            per.remove(per.size() - 1);
            usedIMinusJ.put(row - col, false);
            usedIPlusJ.put(row + col, false);
            usedCol[col] = false;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
