package leetcode.editor.cn;

import java.util.HashSet;

/**
 * [771]宝石与石头
 * @author luchao
 */
public class JewelsAndStones {
    public static void main(String[] args) {
        Solution solution = new JewelsAndStones().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        // 宝石set
        HashSet<Character> set = new HashSet<>();
        for (char jewel : jewels.toCharArray()) {
            set.add(jewel);
        }
        // 计数
        int count = 0;
        for (char stone : stones.toCharArray()) {
            if (set.contains(stone)) {
                count++;
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
