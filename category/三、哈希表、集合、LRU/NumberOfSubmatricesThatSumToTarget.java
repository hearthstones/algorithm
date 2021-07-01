package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * [1074]元素和为目标值的子矩阵数量
 * @author luchao
 */
public class NumberOfSubmatricesThatSumToTarget {
    public static void main(String[] args) {
        Solution solution = new NumberOfSubmatricesThatSumToTarget().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 特征：二维区间和。前缀和？
     * 主体：1.降维。枚举上下边界，{每轮}枚举可看作上下边界固定 => {每轮}计算上下边界内每列元素和，作为一维数组 => {每轮}统计一维数组中 [和为K的子数组] 个数
     *      2.统计一维数组中 [560.和为K的子数组] 个数 => 前缀和 + 哈希表计数。
     * 细节：colSum、ans += subArraySumEqualsTarget() 的位置，输出调试
     */
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int ans = 0;
        // 行、列边界
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        // 枚举上边界
        for (int i = 0; i < rowLen; i++) {
            // 枚举下边界
            // j 范围 [i, ..., rowLen - 1]，避免重复枚举
            int[] colSum = new int[colLen];
            for (int j = i; j < rowLen; j++) {
                // 计算上下边界内每列元素和
                for (int k = 0; k < colLen; k++) {
                    colSum[k] += matrix[j][k];
                }
                ans += subArraySumEqualsTarget(colSum, target);
            }
        }
        return ans;
    }

    /**
     * 统计和为target的子数组个数（一维）
     *
     * @param array 一维数组
     * @return 个数
     */
    private int subArraySumEqualsTarget(int[] array, int target) {
        // key - 前缀和元素, value - 次数
        Map<Integer, Integer> countMap = new HashMap<>();
        // 前缀和，区间问题转变为两点问题
        int count = 0;
        int sum = 0;
        countMap.put(0, 1);
        for (int num : array) {
            // 每轮循环中，sum即前缀和数组中的sums[i]
            sum += num;
            // 每轮固定右端i，sums[i] - sums[j] = target => sums[j] = sums[i] - target
            if (countMap.containsKey(sum - target)) {
                count += countMap.get(sum - target);
            }
            countMap.put(sum, countMap.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
