/*
 * 22. 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 *
 *
 * 示例：
 *
 * 输入：n = 3
 * 输出：[
 *        "((()))",
 *        "(()())",
 *        "(())()",
 *        "()(())",
 *        "()()()"
 *      ]
 */

package solFrom1To100.sol22;

import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        // 特判
        if (n == 0)
            return new LinkedList<>();
        List<String> result = new LinkedList<>();  // 记录所有合法的括号组合
        StringBuilder track = new StringBuilder();  // 回溯过程的路径

        backtrack(track, n, n, result);  // 开始回溯

        return result;
    }


    /**
     * 回溯
     * @param track 路径
     * @param leftNum 左括号的剩余可用数量
     * @param rightNum  右括号的剩余可用数量
     * @param result  解集
     */
    private static void backtrack(StringBuilder track, int leftNum, int rightNum, List<String> result) {
        // 判断是否剪枝
        if (rightNum < 0 || leftNum < 0 || rightNum < leftNum) {
            return;
        }
        // 判断是否为结果
        if (rightNum == 0) {
            result.add(track.toString());
            return;
        }

        // 继续向下走
        // 尝试放一个做括号
        track.append('(');  // 做选择
        backtrack(track, leftNum - 1, rightNum, result);
        track.deleteCharAt(track.length() - 1);  // 撤销选择

        // 尝试放一个右括号
        track.append(')');
        backtrack(track, leftNum, rightNum - 1, result);
        track.deleteCharAt(track.length() - 1);
    }
}
