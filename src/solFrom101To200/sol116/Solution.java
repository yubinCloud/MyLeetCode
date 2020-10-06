/*
 * 116. 填充每个节点的下一个右侧节点指针
 * 给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有 next 指针都被设置为 NULL。
 */

package solFrom101To200.sol116;

class Solution {
    public Node connect(Node root) {
        if (root == null)
            return null;

        connectTwoNode(root.left, root.right);
        return root;
    }

    private static void connectTwoNode(Node node1, Node node2) {
        if (node1 == null || node2 == null) {
            return;
        }

        // 将node1与node2先直接连起来
        node1.next = node2;

        // 连接node1的左右子节点、node2的左右子节点和node1与node2的跨节点
        connectTwoNode(node1.left, node1.right);
        connectTwoNode(node2.left, node2.right);
        connectTwoNode(node1.right, node2.left);
    }
}
