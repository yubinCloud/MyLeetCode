package solFrom101To200.sol105;

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        return buildHelper(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    private TreeNode buildHelper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        // base case
        if (preStart >= preEnd || inStart >= inEnd) {
            return null;
        }

        int rootVal = preorder[preStart];  // root 节点的值就是前序遍历数组的第一个元素
        int idx = 0;  // rootVal 在 inorder 中的索引
        for (int i = inStart; i < inEnd; i++) {
            if (inorder[i] == rootVal) {
                idx = i;
                break;
            }
        }

        TreeNode root = new TreeNode(rootVal);
        // 递归构造左右子树
        int leftSize = idx - inStart;  // 左子树中节点的个数
        root.left = buildHelper(preorder, preStart + 1, preStart + 1 + leftSize, inorder, inStart, idx);
        root.right = buildHelper(preorder, preStart + leftSize + 1, preEnd, inorder, idx + 1, inEnd);

        return root;
    }
}
