/*
 * 106. 从中序与后序遍历序列构造二叉树
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */

package solFrom101To200.sol106;


class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // 特判
        if (inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0) {
            return null;
        }
        return buildHelper(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }

    private TreeNode buildHelper(int[] inorder, int inStart, int inEnd,
                                 int[] postorder, int postStart, int postEnd) {
        // base case
        if (inStart >= inEnd || postStart >= postEnd) {
            return null;
        }
        // 构造根节点
        int rootVal = postorder[postEnd - 1];
        TreeNode root = new TreeNode(rootVal);
        // 分别找出左右子树的节点范围
        int idx = 0;  // rootVal 在 inorder 中的索引
        for (int i = inStart; i < inEnd; ++i) {
            if (rootVal == inorder[i]) {
                idx = i;
                break;
            }
        }
        int leftSize = idx - inStart;  // 左子树的节点个数
        // 构造左右子树
        root.left = buildHelper(inorder, inStart, idx, postorder, postStart, postStart + leftSize);
        root.right = buildHelper(inorder, idx + 1, inEnd, postorder, postStart + leftSize, postEnd - 1);

        return root;
    }
}