package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Stack;

/**
 * [84]柱状图中最大的矩形
 * @author luchao
 */
public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        Solution solution = new LargestRectangleInHistogram().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 思路：暴力，双循环 => 优化：单调栈
     */
    public int largestRectangleArea(int[] heights) {
        // 哨兵
        int n = heights.length;
        int[] copy = Arrays.copyOf(heights, n + 1);
        copy[n] = 0;
        // init
        Stack<Rect> stack = new Stack<Rect>();
        int ans = 0;
        // 1.枚举
        for (int h : copy) {
            int sumWidth = 0;
            // 2.while(栈顶不满足高度单调性) {累加宽度，出栈}
            while (!stack.isEmpty() && stack.peek().height >= h) {
                // 出栈
                Rect rect = stack.pop();
                sumWidth += rect.width;
                ans = Math.max(ans, sumWidth * rect.height);
            }
            // 3.新元素入栈
            Rect currRect = new Rect();
            currRect.height = h;
            currRect.width = sumWidth + 1;
            stack.push(currRect);
        }
        return ans;
    }

    // 矩形
    private class Rect {
        int height;
        int width;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
