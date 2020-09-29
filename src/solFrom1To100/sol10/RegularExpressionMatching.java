package solFrom1To100.sol10;

import java.util.Scanner;

public class RegularExpressionMatching {
    /**
     * 回溯法
     * @param s: 待匹配字符串
     * @param p: 字符规律
     * @return 是否能够匹配
     */
    public boolean isMatch_1(String s, String p) {
        // 特判
        if(p.isEmpty()) return s.isEmpty();

        // 判断第一个字符能否完成匹配
        boolean firstMatch = !s.isEmpty() &&
                (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.');

        // 根据是否有*号来决定递归方式
        if(p.length() >= 2 && p.charAt(1) == '*') {
            return (isMatch_1(s, p.substring(2)) ||
                    (firstMatch && isMatch_1(s.substring(1), p)));
        } else {
            return firstMatch && isMatch_1(s.substring(1), p.substring(1));
        }
    }

    /**
     * 自底向上的动态规划法
     * @param s: 待匹配的String
     * @param p: 字符规律
     * @return 是否能够匹配
     */
    public boolean isMatch_2(String s, String p) {
        // 建立优化函数
        // dp[i][j]: s[i:]是否与p[j:]相匹配
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        // 初始化
        int sLen = s.length();
        dp[sLen][p.length()] = true;
        // 多步判断的过程
        for (int i = s.length(); i >= 0; --i) {  // 计算dp[i]
            for (int j = p.length() - 1; j >= 0; --j) {  // 计算dp[i][j]
                // s[i]与p[j]是否能够匹配
                boolean firstMatch = (i < s.length()) &&
                        (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
                // 针对是否有星号使用不同的优化递推方程
                if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                    dp[i][j] = dp[i][j + 2] || (firstMatch && dp[i + 1][j]);
                } else {
                    dp[i][j] = firstMatch && dp[i + 1][j + 1];
                }
            }
        }
        return dp[0][0];
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RegularExpressionMatching r = new RegularExpressionMatching();
        while(sc.hasNext()) {
            String s = sc.next();
            String p = sc.next();
            System.out.println(r.isMatch_2(s, p));
        }
    }
}

