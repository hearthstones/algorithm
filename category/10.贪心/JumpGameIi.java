package leetcode.editor.cn;

/**
 * [45]跳跃游戏 II
 * @author luchao
 */
public class JumpGameIi {
    public static void main(String[] args) {
        Solution solution = new JumpGameIi().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 决策包容性：
     *   假设：a能跳到b1、b2、b3, 且b1、b2、b3能跳到的最远位置分别为c1、c2、c3。如果c2最大，则a -> b2为局部最优解。
     *   证明：c2最大，即b2能达到c1、c3、c2，该决策包含了选择b1、b2后的可达集合，所以该局部最优决策是正确的。
     *
     * 思路：贪心
     */
    public int jump(int[] nums) {
        int len = nums.length;
        int now = 0;
        int ans = 0;
        // 遍历。不访问最后一个元素，是因为在访问最后一个元素之前，边界一定大于等于最后一个位置，否则就无法跳到最后一个位置
        while (now < len - 1) {
            if (nums[now] == 0) return -1;
            // 当前能跳到的最远位置
            int nowMax = now + nums[now];
            // 之前每步都是局部最优，此时可直接跳到终点，步数+1
            if (nowMax >= len - 1) return ans + 1;
            // 从now起跳，可到达[now + 1, max]
            // 选定该范围内，可达最远位置的点作为下一个起跳点(next)
            int next = now + 1;
            for (int i = now + 2; i <= nowMax; i++) {
                if (i + nums[i] > next + nums[next]) next = i;
            }
            now = next;
            // 跳跃数计数
            ans++;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
