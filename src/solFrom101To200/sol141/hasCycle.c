/*
 * 141. 环形链表
给定一个链表，判断链表中是否有环。

如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。

如果链表中存在环，则返回 true 。 否则，返回 false 。
 */


#include <stdio.h>
#include <stdbool.h>

struct ListNode {
    int val;
    struct ListNode *next;
};

/**
 * 快慢指针方法来判断是否有环
 * @param head 链表的头结点
 * @return 是否有环
 */
bool hasCycle(struct ListNode *head) {
    struct ListNode *fast, *slow;
    fast = slow = head;
    while (fast != NULL && fast->next != NULL) {
        fast = fast->next->next;
        slow = slow->next;

        if (fast == slow)
            return true;
    }
    return false;
}


int main()
{
    printf("Hello, World!\n");
    return 0;
}
