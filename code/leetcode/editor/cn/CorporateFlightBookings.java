package leetcode.editor.cn;

/**
 * [1109]航班预订统计
 * @author luchao
 */
public class CorporateFlightBookings {
    public static void main(String[] args) {
        Solution solution = new CorporateFlightBookings().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 思路：遍历O(mn) => 差分优化O(m + n)
     */
    public int[] corpFlightBookings(int[][] bookings, int n) {
        // 差分数组
        int[] sub = new int[n + 2];
        for (int[] booking : bookings) {
            // 差分性质：原数组[l, r]各加d => 差分数组sub[l] + d, sub[r + 1] - d
            int first = booking[0];
            int last = booking[1];
            int seats = booking[2];
            sub[first] += seats;
            sub[last + 1] -= seats;
        }
        // ans, 差分数组的前缀和数组即原数组
        int[] ans = new int[n];
        ans[0] = sub[1];
        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] + sub[i + 1];
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
