package leetcode.editor.cn;

/**
 * [1011]在 D 天内送达包裹的能力
 * @author luchao
 */
public class CapacityToShipPackagesWithinDDays {
    public static void main(String[] args) {
        Solution solution = new CapacityToShipPackagesWithinDDays().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 特征：在 D 天内将传送带上的所有包裹送达的船的最低运载能力
     * 主体：从运载能力T开始，都可以送达 => 分段0/1函数 => 二分答案，找第一个 >= T
     */
    public int shipWithinDays(int[] weights, int days) {
        // 下界，每个元素为一组，则 left = weights中最大元素
        int left = Integer.MIN_VALUE;
        // 上界，所有元素为一组，则 right = weights元素和
        int right = 0;
        for (int weight : weights) {
            left = Math.max(left, weight);
            right += weight;
        }
        // 二分答案
        while (left < right) {
            int mid = (right + left) / 2;
            if (isValid(weights, days, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    // 判定：以运载能力T，是否可以在D天内将所有包裹送达
    private boolean isValid(int[] weights, int days, int t) {
        // 计数
        int countWeight = 0;
        int countDay = 1;
        // 遍历
        for (int weight : weights) {
            // 不超，放入
            if (countWeight + weight <= t) {
                countWeight += weight;
            } else { // 超过，开启下一个计数
                countDay++;
                countWeight = weight;
            }
        }
        return countDay <= days;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}