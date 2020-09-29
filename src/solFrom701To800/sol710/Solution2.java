/*
710. 黑名单中的随机数
给定一个包含 [0，n ) 中独特的整数的黑名单 B，写一个函数从 [ 0，n ) 中返回一个不在 B 中的随机整数。

对它进行优化使其尽量少调用系统方法 Math.random() 。

提示:

1 <= N <= 1000000000
0 <= B.length < min(100000, N)
[0, N) 不包含 N，详细参见 interval notation 。

 */

package solFrom701To800.sol710;

import java.util.Arrays;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution2 {
    /*
    方法： 制作出白名单并在其中随机选择
    预处理的时间复杂度为O(N)，超出题目限制
     */

    private final int[] selectableArray;
    private final Random random;

    public Solution2(int N, int[] blacklist) {
        Set<Integer> blackSet = Arrays.stream(blacklist).boxed().collect(Collectors.toSet());
        this.selectableArray = new int[N - blacklist.length];
        int arrSize = 0;  // selectableArray 当前的大小
        // 构建出 selectableArray
        for (int i = 0; i < N; i++) {
            if (!blackSet.contains(i)) {
                selectableArray[arrSize] = i;
                ++arrSize;
            }
        }

        this.random = new Random();
    }

    public int pick() {
        return selectableArray[random.nextInt(selectableArray.length)];
    }
}
