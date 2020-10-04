package solFrom1To100.sol26;

public class Solution {
    public int removeDuplicates(int[] nums) {
        // 特判
        if (nums.length == 0) {
            return 0;
        }
        // 一般情况
        int fastPtr = 0, slowPtr = 0;
        while (fastPtr < nums.length) {
            if (nums[fastPtr] != nums[slowPtr]) {
                ++slowPtr;
                // 更新 num[0, ..., slow] 使其无重复
                nums[slowPtr] = nums[fastPtr];
            }
            ++fastPtr;
        }
        return slowPtr + 1;  // 长度为 索引 + 1
    }
}
