package solFrom1501To1600.sol1541;

class Solution {
    public int minInsertions(String s) {
        int res = 0;    // 插入次数
        int need = 0;   // 对右括号的需求量

        for (char c: s.toCharArray()) {
            if (c == '(') {
                need += 2;
                if (need % 2 == 1) {
                    res++;
                    need--;
                }
            }
            if (c == ')') {
                need--;
                if (need == -1) {  // 当右括号过多的时候
                    res++;
                    need = 1;
                }
            }
        }
        return res + need;
    }
}