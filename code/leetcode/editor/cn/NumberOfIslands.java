package leetcode.editor.cn;

/**
 * [200]岛屿数量
 * @author luchao
 */
public class NumberOfIslands {
    public static void main(String[] args) {
        Solution solution = new NumberOfIslands().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 全局
    private char[][] grid;
    private int m;
    private int n;
    private boolean[][] visit;

    /**
     * 特征：地图类问题
     * 主体：DFS + 标记
     *   1.双循环。每次循环中，grid(i,j) == '1'且没被标记过，就向四个方向dfs，在dfs的过程中标记点visit，遇岛屿边界或已标记过时停止。
     *   2.dfs的目的是标记，在连续的陆地中不会重复dfs => ans++最终就是岛屿数量。
     */
    public int numIslands(char[][] grid) {
        // init
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        this.visit = new boolean[m][n];
        int ans = 0;
        // dfs未标记过的陆地(i, j)
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visit[i][j]) {
                    dfs(i, j);
                    ans++;
                }
            }
        }
        return ans;
    }

    // dfs
    private void dfs(int row, int col) {
        // 终止条件
        // 1.岛屿边界，网格边界 或 水('0'); 2.去重，标记visit[row][col] == true.
        if (row < 0 || row >= m || col < 0 || col >= n || grid[row][col] == '0' || visit[row][col]) {
            return;
        }
        // 状态空间变化
        visit[row][col] = true;
        // 四个方向出边
        dfs(row - 1, col);
        dfs(row + 1, col);
        dfs(row, col - 1);
        dfs(row, col + 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
