package solFrom601To700.sol652;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Solution {
    Map<String, Integer> memo = new HashMap<>();  // 记录所有子树及其重复次数
    List<TreeNode> result = new LinkedList<>();   // 记录所有重复的子树

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return result;
    }

    private String traverse(TreeNode root) {
        // base case
        if (root == null) {
            return "#";
        }
        // 后序遍历
        StringBuilder rootStrBuilder = new StringBuilder();
        String leftStr = traverse(root.left);
        rootStrBuilder.append(leftStr);
        rootStrBuilder.append(',');
        String rightStr = traverse(root.right);
        rootStrBuilder.append(rightStr);
        rootStrBuilder.append(',');
        rootStrBuilder.append(root.val);
        String rootStr = rootStrBuilder.toString();

        // 加入备忘录
        int freq = memo.getOrDefault(rootStr, 0);  // 获取rootStr出现的次数
        if (freq == 1) {
            result.add(root);  // 第二次出现时加入解集
        }
        memo.put(rootStr, freq + 1);

        return rootStr;
    }
}