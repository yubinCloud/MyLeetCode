/*
 * 78. 子集
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */

package solFrom1To100.sol78;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new LinkedList<>();  // 保存算法结果
        List<Integer> blankTrack = new ArrayList<>();  // 当前空白的路径
        backtrack(nums, 0, blankTrack, results);
        return results;
    }

    private void backtrack(int[] nums, int start, List<Integer> track, List<List<Integer>> results) {
        // 所有节点都是一个结果的元素
        List<Integer> result = new ArrayList<>(track);
        results.add(result);

        for (int i = start; i < nums.length; ++i) {  // 遍历可选列表
            // 做选择
            track.add(nums[i]);
            // 回溯
            backtrack(nums, i + 1, track, results);
            // 撤销选择
            track.remove(track.size() - 1);
        }
    }
}