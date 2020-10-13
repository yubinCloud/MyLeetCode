package solFrom1To100.sol46;

import sun.awt.image.ImageWatched;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        // 特判
        if (nums == null || nums.length == 0) {
            return new LinkedList<>();
        }
        // 从初始状态进行回溯算法
        List<Integer> blankTrack = new ArrayList<>();
        List<List<Integer>> results = new LinkedList<>();
        backtrack(blankTrack, nums, results);
        return results;
    }

    private static void backtrack(List<Integer> track, int[] nums, List<List<Integer>> results) {
        // 判断是否为结果
        if (track.size() == nums.length) {
            results.add(new LinkedList<>(track));
            return;
        }
        // 选择与回溯
        for (int num: nums) {
            // 筛选可以做的选择
            if (track.contains(num))
                continue;
            // 做选择
            track.add(num);
            // 回溯
            backtrack(track, nums, results);
            // 撤销选择
            track.remove(track.size() - 1);
        }
    }
}