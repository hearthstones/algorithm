package leetcode.editor.cn;

/**
 * [1482]制作m束花所需的最少天数
 * @author luchao
 */
public class MinimumNumberOfDaysToMakeMBouquets {
    public static void main(String[] args) {
        Solution solution = new MinimumNumberOfDaysToMakeMBouquets().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 特征：m束花，一束花需相邻的k朵花，第i朵花会在bloomDay[i]时盛开，最少天数
     * 主体：最少天数，从第T天开始，都可以制作 => 分段0/1函数 => 二分答案
     * 细节：不合法的情况
     */
    public int minDays(int[] bloomDay, int m, int k) {
        // 下界，第一朵花开需要的天数
        int lower = Integer.MAX_VALUE;
        // 上界，最后一朵花开需要的天数
        int upper = Integer.MIN_VALUE;
        for (int day : bloomDay) {
            lower = Math.min(lower, day);
            upper = Math.max(upper, day);
        }
        // 二分范围：[下界, 上界] + [不合法：上界 + 1]
        int left = lower;
        int right = upper + 1;
        // 二分 + 判定
        while (left < right) {
            int mid = (left + right) >> 1;
            if (isValid(bloomDay, m, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right == upper + 1 ? -1 : right;
    }

    // 判定
    private boolean isValid(int[] bloomDay, int m, int k, int t) {
        // 可制作bouquets束花
        int bouquets = 0;
        // 连续的flowers朵花
        int flowers = 0;
        // 统计
        for (int day : bloomDay) {
            if (day <= t) {
                flowers++;
                if (flowers == k) {
                    bouquets++;
                    flowers = 0;
                }
            } else {
                flowers = 0;
            }
        }
        // 是否可以制作m束花
        return bouquets >= m;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
