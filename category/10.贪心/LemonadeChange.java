package leetcode.editor.cn;

/**
 * [860]柠檬水找零
 * @author luchao
 */
public class LemonadeChange {
    public static void main(String[] args) {
        Solution solution = new LemonadeChange().new Solution();
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 计数数组，元素为面额
    private int[] count;

    /**
     * 思路：5、10、20，成倍，找零具有决策包容性
     */
    public boolean lemonadeChange(int[] bills) {
        this.count = new int[21];
        for (int bill : bills) {
            // 计数
            count[bill]++;
            // 是否可以找零
            if (!exchange(bill - 5)) return false;
        }
        return true;
    }

    // 是否可以找零
    private boolean exchange(int amount) {
        // 贪心，决策包容性。先找10块，再找5块
        while (amount >= 10 && count[10] > 0) {
            amount -= 10;
            count[10]--;
        }
        while (amount >= 5 && count[5] > 0) {
            amount -= 5;
            count[5]--;
        }
        return amount == 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
