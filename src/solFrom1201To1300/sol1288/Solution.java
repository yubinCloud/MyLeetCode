/*
 * 给你一个区间列表，请你删除列表中被其他区间所覆盖的区间。
 *
 * 只有当c <= a且b <= d时，我们才认为区间[a,b) 被区间[c,d) 覆盖。
 *
 * 在完成所有删除操作后，请你返回列表中剩余区间的数目。
 *
 *
 *
 * 示例：
 *
 * 输入：intervals = [[1,4],[3,6],[2,8]]
 * 输出：2
 * 解释：区间 [3,6] 被区间 [2,8] 覆盖，所以它被删除了。
 *
 *
 * 提示：
 *
 * 1 <= intervals.length <= 1000
 * 0 <= intervals[i][0] <intervals[i][1] <= 10^5
 * 对于所有的i != j：intervals[i] != intervals[j]
 *
 * 讲解：https://app.yinxiang.com/shard/s58/nl/30699092/860ced1b-bde4-404a-8505-c394adc3a2a2
 */

package solFrom1201To1300.sol1288;


import java.util.Arrays;

class Solution {
    public int removeCoveredIntervals(int[][] intvs) {
        // 对intvs进行排序
        Arrays.sort(intvs, (a, b) -> {
            if (a[0] == b[0])
                return b[1] - a[1];
            else
                return a[0] - b[0];
        });

        int count = 0;  // 被删除的区间的数量
        int left = intvs[0][0];  // 左边界
        int right = intvs[0][1];  // 右边界

        for (int i = 1; i < intvs.length; i++) {
            int[] intv = intvs[i];  // 本轮检测的区间
            // 被覆盖的情况
            if (left <= intv[0] && right >= intv[1]) {
                ++count;
            }
            // 需要合并的情况
            else if (right >= intv[0] && right <= intv[1]) {
                right = intv[1];
            }
            else if (right < intv[0]) {
                left = intv[0];
                right = intv[1];
            }
        }

        return intvs.length - count;
    }
}