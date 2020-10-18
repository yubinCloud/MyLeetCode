/*
 * 10. 正则表达式匹配
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 *
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 *
 * 说明:
 *
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 * 示例 1:
 *
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 */

package solFrom1To100.sol10;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

class Solution {
    private class Pair {
        private int first;
        private int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)  // 地址相等
                return true;
            if (obj == null)  // 非空性
                return false;
            if (!(obj instanceof Pair))
                return false;
            Pair other = (Pair) obj;
            return this.first == other.first && this.second == other.second;
        }
    }

    public boolean isMatch(String s, String p) {
        Map<Pair, Boolean> memo = new HashMap<>();  // 备忘录

        return dp(s, 0, p, 0, memo);
    }

    private boolean dp(String str, int i, String pattern, int j, Map<Pair, Boolean> memo) {
        // 检查备忘录
        Boolean memoRes = memo.get(new Pair(i, j));
        if (memoRes != null)
            return memoRes;
        // 递归的base case
        if (j == pattern.length())
            return i == str.length();
        // 检测firstMatch
        boolean firstMatch = i < str.length() && (pattern.charAt(j) == '.' || pattern.charAt(j) == str.charAt(i));
        // 递归计算答案
        boolean ans;
        if (j <= pattern.length() - 2 && pattern.charAt(j + 1) == '*')
            ans = dp(str, i, pattern, j + 2, memo) || (firstMatch && dp(str, i + 1, pattern, j, memo));
        else
            ans = firstMatch && dp(str, i + 1, pattern, j + 1, memo);

        memo.put(new Pair(i, j), ans);  // 将答案放入备忘录
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();
        while(sc.hasNext()) {
            String s = sc.next();
            String p = sc.next();
            System.out.println(sol.isMatch(s, p));
        }
    }
}