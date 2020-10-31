/**
 * 剑指 Offer 22. 链表中倒数第k个节点
输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。



示例：

给定一个链表: 1->2->3->4->5, 和 k = 2.

返回链表 4->5.
 */

#include <stdio.h>

struct ListNode {
    int val;
    struct ListNode *next;
};

struct ListNode* getKthFromEnd(struct ListNode* head, int k){
    struct ListNode *fastPtr = head;
    struct ListNode *slowPtr = head;
    // 让快指针先提前走k步
    for (int i = 0; i < k; ++i) {
        if (fastPtr != NULL)
            fastPtr = fastPtr->next;
        else
            return NULL;
    }
    // 快慢指针等速前进，直到快指针碰到终点
    while (fastPtr != NULL) {
        fastPtr = fastPtr->next;
        slowPtr = slowPtr->next;
    }

    return slowPtr;
}


int main()
{
    printf("Hello, World!\n");
    return 0;
}
