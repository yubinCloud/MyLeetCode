/*
sol380: 常数时间插入、删除和获取随机元素
 */

package solFrom301To400.sol380;

import java.util.*;


class RandomizedSet {

    private final List<Integer> nums;
    private final Map<Integer, Integer> numToIdx;
    private final Random random;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        this.nums = new ArrayList<>();
        this.numToIdx = new HashMap<>();
        this.random = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        // 检查val是否已存在
        if (numToIdx.containsKey(val)) {
            return false;
        }
        // 不存在时在nums的结尾插入
        nums.add(val);
        numToIdx.put(val, nums.size() - 1);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!numToIdx.containsKey(val)) {
            return false;
        }

        int valIdx = numToIdx.get(val);
        int lastElem = nums.get(nums.size() - 1);
        nums.set(valIdx, lastElem);
        nums.remove(nums.size() - 1);
        numToIdx.remove(val);
        numToIdx.replace(lastElem, valIdx);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int randIntValue = random.nextInt(nums.size());
        return nums.get(randIntValue);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        RandomizedSet obj = new RandomizedSet();
        while (in.hasNextInt()) {
            int way = in.nextInt();

            if (way == 0) {
                int val = in.nextInt();
                System.out.println(obj.insert(val));
                System.out.println(obj.nums);
            } else if (way == 1) {
                int val = in.nextInt();
                System.out.println(obj.remove(val));
                System.out.println(obj.nums);
            } else {
                System.out.println(obj.getRandom());
                System.out.println(obj.nums);
            }
        }
    }
}
