package cn.cqc3073.algorithm.sort;

import java.util.Arrays;

/**
 * 插入式排序算法, 也是冒泡排序
 * 该算法就如同平时我们打牌的时候，摸牌，将牌按顺序和手中的牌依次比较，然后插入到牌中合适的位置
 */
public class InsertionSort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sort(new int[]{2, 1, 434, 21, 143})));
    }

    private static int[] sort(int[] nums) {
        if (nums.length < 2) {
            return nums;
        }

        for (int pos = 1; pos < nums.length; pos++) {
            int val = nums[pos];
            int i = pos - 1; //从pos位置的上一个位置开始比较，理论上pos之前的位置都是已经排过序的

            //从pos位置开始，向上依次和目标值比较，比目标值大的往下调整一位，如果小则目标值直接插入当前的位置
            while (i >= 0 && nums[i] > val) {
                nums[i + 1] = nums[i];
                i--;
            }
            nums[i + 1] = val;
        }

        return nums;
    }
}
