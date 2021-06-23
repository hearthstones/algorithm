package leetcode.editor.cn;

/**
 * [20]有效的括号
 * @author luchao
 */
public class ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new ValidParentheses().new Solution();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 特征：最近相关性，栈
     * 主体：遇左括号入栈；遇右括号匹配，匹配成功出栈，不成功返回false。
     * 细节：边界
     */
    public boolean isValid(String s) {
        char[] arr = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char ch : arr) {
            // 遇左括号，入栈
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            // 遇右括号，匹配
            } else {
                if (stack.isEmpty()
                        || (ch == ')' && stack.peek() != '(')
                        || (ch == '}' && stack.peek() != '{')
                        || (ch == ']' && stack.peek() != '[')) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}