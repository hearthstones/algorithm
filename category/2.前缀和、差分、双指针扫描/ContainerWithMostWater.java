package leetcode.editor.cn;

/**
 * [11]盛最多水的容器
 * @author luchao
 */
public class ContainerWithMostWater {
    public static void main(String[] args) {
        Solution solution = new ContainerWithMostWater().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 思路：双指针。
     *     容量 = min(height[l], height[r]) * (r - l)
     *  => 容量由高度低的板决定，容量低的板能得到的容量已到上限
     *  => 找更大的容量，需移动低的指针
     */
    public int maxArea(int[] height) {
        // 双指针
        int l = 0;
        int r = height.length - 1;
        // 遍历
        int ans = 0;
        while (l < r) {
            ans = Math.max(ans, Math.min(height[l], height[r]) * (r - l));
            if (height[l] <= height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
