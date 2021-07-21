package leetcode.editor.cn;

/**
 * [875]爱吃香蕉的珂珂
 * @author luchao
 */
public class KokoEatingBananas {
    public static void main(String[] args) {
        Solution solution = new KokoEatingBananas().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 特征：H小时内吃掉所有香蕉的最小速度K
     * 主体：从速度K开始，都可以吃完 => 分段0/1函数 => 二分答案
     */
    public int minEatingSpeed(int[] piles, int h) {
        // 范围 1 <= piles[i] <= 10^9
        int left = 1;
        int right = 1_000_000_000;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isValid(piles, h, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    // 判定: 以速度k，是否可以在H小时内吃掉所有香蕉
    private boolean isValid(int[] piles, int h, int k) {
        // 小时计数
        int hourCount = 0;
        for (int pile : piles) {
            // 上取整
            hourCount += (pile - 1) / k + 1;
        }
        return hourCount <= h;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}