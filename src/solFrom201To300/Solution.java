/*
 * 283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 */

package solFrom201To300;

class Solution {
    public void moveZeroes(int[] nums) {
        // 特判
        if (nums == null || nums.length == 0) {
            return;
        }
        // 一般情况
        int fastPtr = 0, slowPtr = 0;
        // 首先移除所有0元素
        while (fastPtr < nums.length) {
            if (nums[fastPtr] != 0) {
                nums[slowPtr] = nums[fastPtr];
                ++slowPtr;
            }
            ++fastPtr;
        }
        // 将尾后全部填充为0
        while (slowPtr < nums.length) {
            nums[slowPtr] = 0;
            ++slowPtr;
        }
    }
}