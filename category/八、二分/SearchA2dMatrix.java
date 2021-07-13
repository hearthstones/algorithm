package leetcode.editor.cn;

/**
 * [74]搜索二维矩阵
 * @author luchao
 */
public class SearchA2dMatrix {
    public static void main(String[] args) {
        Solution solution = new SearchA2dMatrix().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 特征：升序二维
     * 主体：降维 + 二分查找
     *     如何降维？不能构造一维数组，因为会遍历矩阵 => 二维数组下标映射成一维
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = m * n - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            // 转换成二维坐标(i, j)
            int element = matrix[mid / n][mid % n];
            if (element == target) {
                return true;
            } else if (element > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
