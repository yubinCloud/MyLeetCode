/**
 * 167. 两数之和 II - 输入有序数组
给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。

函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。

说明:

返回的下标值（index1 和 index2）不是从零开始的。
你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
示例:

输入: numbers = [2, 7, 11, 15], target = 9
输出: [1,2]
解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 */

#include <stdlib.h>

int* twoSum(int* nums, int numsSize, int target, int* returnSize){
    int* left = nums;  // 指向数组最左边
    int* right = nums + (numsSize - 1);  // 指向数组最右边

    int* result = (int*) malloc(sizeof(int) * 2);
    *returnSize = 2;
    while (left < right) {
        int sum = *left + *right;
        if (sum == target) {
            result[0] = left - nums + 1;
            result[1] = right - nums + 1;
            return result;
        } else if (sum > target) {
            right--;
        } else if (sum < target) {
            left++;
        }
    }
    result[0] = -1;
    result[1] = -1;
    return result;
}

int main() {
    return 0;
}