/*
 * 654. 最大二叉树
 * 给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
 *
 * 二叉树的根是数组中的最大元素。
 * 左子树是通过数组中最大值左边部分构造出的最大二叉树。
 * 右子树是通过数组中最大值右边部分构造出的最大二叉树。
 * 通过给定的数组构建最大二叉树，并且输出这个树的根节点。
 *
 *
 *
 * 示例 ：
 *
 * 输入：[3,2,1,6,0,5]
 * 输出：返回下面这棵树的根节点：
 *
 *       6
 *     /   \
 *    3     5
 *     \    /
 *      2  0
 *        \
 *         1
 *
 *
 * 提示：
 *
 * 给定的数组的大小在 [1, 1000] 之间。
 */

package solFrom601To700.sol654;

class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null)
            return null;

        return constructHelper(nums, 0, nums.length);
    }

    /**
     * 根据指定的索引范围来构建最大二叉树
     * @param nums 给定的所有数值
     * @param lo 指定的索引下界，包含该对应元素
     * @param hi 指定的索引上界，且不包含该对应元素
     * @return 构建出的最大二叉树的根节点
     */
    private TreeNode constructHelper(int[] nums, int lo, int hi) {
        if (lo >= hi) {
            return null;
        }

        int maxValue = Integer.MIN_VALUE;
        int maxIdx = lo;
        for (int i = lo; i < hi; i++) {
            if (nums[i] > maxValue) {
                maxIdx = i;
                maxValue = nums[i];
            }
        }
        TreeNode node = new TreeNode(maxValue);
        node.left = constructHelper(nums, lo, maxIdx);
        node.right = constructHelper(nums, maxIdx + 1, hi);

        return node;
    }
}