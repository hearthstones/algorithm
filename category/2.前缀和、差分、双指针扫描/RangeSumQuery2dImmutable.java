package leetcode.editor.cn;

/**
 * [304]二维区域和检索 - 矩阵不可变
 * @author luchao
 */
public class RangeSumQuery2dImmutable {
    public static void main(String[] args) {
        Solution solution = new RangeSumQuery2dImmutable().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class NumMatrix {
    private int[][] matrix;
    private int[][] sum;

    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        int m = matrix.length;
        int n = matrix[0].length;
        sum = new int[m][n];
        // 二维矩阵前缀和
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sum[i][j] = getSum(i, j - 1) + getSum(i - 1, j) - getSum(i - 1, j - 1) + matrix[i][j];
            }
        }
    }

    // 二维矩阵区间和
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return getSum(row2, col2) - getSum(row2, col1 - 1) - getSum(row1 - 1, col2) + getSum(row1 - 1, col1 - 1);
    }

    /**
     * 处理边界
     * 可忽略 row >= m 或 col >= n 的越界情况
     */
    private int getSum(int row, int col) {
        return (row >= 0 && col >= 0) ? sum[row][col] : 0;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
