package leetcode.editor.cn;

/**
 * [130]被围绕的区域
 * @author luchao
 */
public class SurroundedRegions {
    public static void main(String[] args) {
        Solution solution = new SurroundedRegions().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 全局
    private char[][] board;
    private int m;
    private int n;
    private boolean[][] red;

    /**
     * 特征：任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。
     * 主体：边界DFS + 标红不该填充的点
     */
    public void solve(char[][] board) {
        // init
        this.board = board;
        this.m = board.length;
        this.n = board[0].length;
        this.red = new boolean[m][n];
        // 遍历边界，dfs(i, j)
        // 第一列、最后一列
        for (int i = 0; i < m; i++) {
            dfs(i, 0);
            dfs(i, n - 1);
        }
        // 第一行、最后一行（去头尾）
        for (int j = 1; j < n - 1; j++) {
            dfs(0, j);
            dfs(m - 1, j);
        }
        // 填充
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = red[i][j] ? 'O' : 'X';
            }
        }
    }

    // dfs
    private void dfs(int row, int col) {
        // 终止条件：1.超出边界；2.遇见'X'；3.已标红。
        if (row < 0 || col < 0 || row >= m || col >= n || board[row][col] == 'X' || red[row][col]) {
            return;
        }
        // 状态空间变化
        red[row][col] = true;
        // 四个方向出边
        dfs(row + 1, col);
        dfs(row - 1, col);
        dfs(row, col + 1);
        dfs(row, col - 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
