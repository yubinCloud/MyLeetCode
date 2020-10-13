/*
 * 77. 组合
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 */

package solFrom1To100.sol77;

import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        // 特判
        if (n <= 0 || k <= 0)
            return new LinkedList<>();
        // 从初始状态进行回溯算法
        ArrayList<Integer> blankTrack = new ArrayList<>();
        List<List<Integer>> results = new LinkedList<>();
        backtrack(blankTrack, n, k, 1, results);
        return results;
    }

    private static void backtrack(ArrayList<Integer> track,   // 路径
                                  int n, int k, int start,    // 选择列表
                                  List<List<Integer>> results) {
        // 判断是否为结果
        if (track.size() == k) {
            results.add(new ArrayList<>(track));
            return;
        }

        // 选择
        for (int i = start; i <= n; ++i) {
            // 做选择
            track.add(i);
            // 回溯
            backtrack(track, n, k, i + 1, results);
            // 撤销选择
            track.remove(track.size() - 1);
        }
    }
}