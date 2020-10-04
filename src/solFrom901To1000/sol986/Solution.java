package solFrom901To1000.sol986;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int aIdx = 0, bIdx = 0;  // 设置两个指针
        List<int[]> result = new ArrayList<>();  // 存储结果
        // 开始遍历
        while (aIdx < A.length && bIdx < B.length) {
            int[] a = A[aIdx];
            int[] b = B[bIdx];
            // 求相交区间
            int[] curResult = intersect(a, b);
            if (curResult != null) {
                result.add(curResult);
            }
            // 前进
            if (a[1] < b[1])
                aIdx++;
            else if (a[1] > b[1])
                bIdx++;
            else {
                aIdx++;
                bIdx++;
            }
        }
        return result.toArray(new int[result.size()][]);
    }

    /**
     * 求两个小区间 a 与 b 的交集，若无交集则返回 null
     * @param a: A 中的区间
     * @param b: B 中的区间
     * @return 两个区间的交集，若无交集则返回 null
     */
    private int[] intersect(int[] a, int[] b) {
        // 不相交的情况
        if (a[1] < b[0] || b[1] < a[0])
            return null;
        // 相交的情况
        return new int[]{Math.max(a[0], b[0]), Math.min(a[1], b[1])};
    }
}