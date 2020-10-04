/*
 * 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 */

package solFrom1To100.sol20;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        final Stack<Character> charStack = new Stack<>();

        for (char c: s.toCharArray()) {
            // 如果是左括号则压入栈中
            if (c == '{' || c == '[' || c == '(') {
                charStack.push(c);
            }
            // 如果是有右括号，则将栈顶对应的左括号弹出，若无对应的左括号则返回匹配失败
            if (c == '}' || c == ']' || c == ')') {
                if (charStack.empty() || leftOf(c) != charStack.peek()) {  // 无法完成匹配
                    return false;
                }
                else
                    charStack.pop();
            }
        }

        return charStack.empty();
    }

    private static final Map<Character, Character> rightToLeft;

    static {
        rightToLeft = new HashMap<>();
        rightToLeft.put('}', '{');
        rightToLeft.put(']', '[');
        rightToLeft.put(')', '(');
    }

    /**
     * 将一个右括号映射成相对应的左括号
     * @param rightBracket: 待映射的右括号
     * @return 映射后的左括号
     */
    private char leftOf(char rightBracket) {
        return rightToLeft.get(rightBracket);
    }
}