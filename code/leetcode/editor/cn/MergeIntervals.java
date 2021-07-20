package leetcode.editor.cn;

import java.util.Arrays;

/**
 * [56]合并区间
 * @author luchao
 */
public class MergeIntervals {
    public static void main(String[] args) {
        Solution solution = new MergeIntervals().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 特征：单个区间 intervals[i] = [starti, endi]
     * 主体：双关键字排序 + 遍历区间更新远端
     */
    public int[][] merge(int[][] intervals) {
        int[][] ans = new int[intervals.length][2];
        int curr = 0;
        // 单个区间 intervals[i] = [starti, endi]，按starti排序
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        // 遍历区间
        // [[1,3],[2,6],[8,10],[15,18]]
        int start = -1;
        int end = -1;
        for (int[] interval : intervals) {
            // 重叠，更新区间远端
            if (interval[0] <= end) {
                end = Math.max(end, interval[1]);
            } else {  // 不重叠，新开一个区间
                if (start >= 0 && end >= 0) {
                    // 记录上一个区间，并移动curr指针
                    ans[curr++] = new int[]{start, end};
                }
                // 新开一个区间，更新start、end
                start = interval[0];
                end = interval[1];
            }
        }
        // 最后一个区间被忽略，补足
        ans[curr] = new int[]{start, end};
        return Arrays.copyOf(ans, curr + 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
