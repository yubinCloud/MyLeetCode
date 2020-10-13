/*
 * 1109. 航班预订统计
 * 这里有 n 个航班，它们分别从 1 到 n 进行编号。
 *
 * 我们这儿有一份航班预订表，表中第 i 条预订记录 bookings[i] = [i, j, k] 意味着我们在从 i 到 j 的每个航班上预订了 k 个座位。
 *
 * 请你返回一个长度为 n 的数组 answer，按航班编号顺序返回每个航班上预订的座位数。
 *
 *
 *
 * 示例：
 *
 * 输入：bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
 * 输出：[10,55,45,25,25]
 *
 */

package solFrom1101To1200.sol1109;


class Solution {

    /**
     * 差分数组类
     */
    private static class Difference {
        private final int[] diff;  // 内部维护的差分数组

        public Difference(int[] nums) throws IllegalArgumentException {
            if (nums.length == 0)
                throw new IllegalArgumentException();

            diff = new int[nums.length];
            diff[0] = nums[0];
            for (int i = 1; i < nums.length; ++i) {
                diff[i] = nums[i] - nums[i - 1];
            }
        }

        /**
         * 对 nums[start, ..., end] 增加 num
         * @param val 增加的值
         * @param start 起始的索引
         * @param end  结束的索引
         */
        public void increase(int start, int end, int val) {
            diff[start] += val;
            if (end + 1 < diff.length) {
                diff[end + 1] -= val;
            }
        }

        /**
         * 将差分数组转换成原数组
         * @return 转换后的原数组
         */
        public int[] toResult() {
            int[] res = new int[diff.length];
            res[0] = diff[0];
            for (int i = 1; i < diff.length; ++i) {
                res[i] = res[i - 1] + diff[i];
            }
            return res;
        }
    }

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] nums = new int[n];  // 初始化为全0
        Difference df = new Difference(nums);  // 构造差分解法

        for (int[] booking: bookings) {
            int start = booking[0] - 1;  // 转化成索引值，因此需要减去1
            int end = booking[1] - 1;
            int val = booking[2];

            df.increase(start, end, val);
        }
        return df.toResult();  // 返回最终结果
    }
}
