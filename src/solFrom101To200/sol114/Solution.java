/*
 * 114. 二叉树展开为链表
 * 给定一个二叉树，原地将它展开为一个单链表。
 *
 *
 *
 * 例如，给定二叉树
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * 将其展开为：
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 */


package solFrom101To200.sol114;

class Solution {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        // 先将左右子树展开
        this.flatten(root.left);
        this.flatten(root.right);

        // ------后序遍历位置-------
        // 将左子树换到右子树上
        TreeNode oldLeft = root.left;
        TreeNode oldRight = root.right;
        root.right = oldLeft;
        root.left = null;
        // 将原先的右子树接到当前右子树的末端
        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        p.right = oldRight;
    }
}