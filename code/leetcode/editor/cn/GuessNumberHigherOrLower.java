package leetcode.editor.cn;

/**
 * [374]猜数字大小
 * @author luchao
 */
public class GuessNumberHigherOrLower {
    public static void main(String[] args) {
        Solution solution = new GuessNumberHigherOrLower().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is lower than the guess number
 *			      1 if num is higher than the guess number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    /**
     * 特征：猜数字、二分
     * 主体：二分答案
     * 细节：(left + right) >> 1 会溢出
     */
    public int guessNumber(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            // (left + right) >> 1 溢出 int
            int mid = left + (right - left) / 2;
            if (guess(mid) <= 0) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
