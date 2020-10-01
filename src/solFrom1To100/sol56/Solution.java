/* 56. 合并区间
 *
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 *
 *
 * 示例 1:
 *
 * 输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例2:
 *
 * 输入: intervals = [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * 注意：输入类型已于2019年4月15日更改。 请重置默认代码定义以获取新方法签名。
 *
 */

package solFrom1To100.sol56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intvs) {
        if (intvs.length == 0) {
            return new int[][]{};
        }
        // 首先对intvs按照start进行排列
        Arrays.sort(intvs, Comparator.comparingInt(a -> a[0]));
        // 初始化变量
        int start = intvs[0][0];
        int end = intvs[0][1];
        List<int[]> res = new ArrayList<>();

        for (int i = 1; i < intvs.length; ++i) {
            int[] intv = intvs[i];
            // 需要合并的情况
            if (end >= intv[0] && end <= intv[1]) {
                end = intv[1];
            }
            // 需要将当前的[start, end]区间加入结果的情况
            else if (end <= intv[0]) {
                res.add(new int[]{start, end});
                start = intv[0];
                end = intv[1];
            }
        }
        res.add(new int[]{start, end});

        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        int[][] intvs = {{1,3}, {2,6}, {8,10}, {15,18}};
        int[][] result = new Solution().merge(intvs);
        System.out.println(Arrays.deepToString(result));
    }
}