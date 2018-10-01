package cn.cqc3073.algorithm.recurse;

import cn.cqc3073.algorithm.DataGen;

import java.util.Arrays;

/**
 * 给出一个数组，计算出数组中的一个连续子数组，使其满足这个子数组和最大
 * 采用分治策略, 解题思路是将原数组拆成规模大致的两个子数组，那么最大的那个子数组可能的分布情况存在下面三种情况：
 * 1. 左边数组
 * 2. 右边数组
 * 3. 跨左右数组
 * 然后分别计算这三种情况下的最大数组，对比这三种情况下的最大数组，取最大数组做为解值
 * 递归拆分的底线则是当子数组只有一个元素时，最大数组则是其自身
 */
public class FindMaxSubArray {

    public static void main(String[] args) {
        int[] arr = DataGen.gen(10, 128);
        System.out.println(Arrays.toString(arr));
        int[] max = find(arr);
        System.out.println(Arrays.toString(max));

    }

    public static int[] find(int[] arr) {
        return findMaxSubArray(arr, 0, arr.length);
    }

    private static int[] findMaxSubArray(int[] arr, int startIncludeIdx, int endExcludIdx) {
        int len = endExcludIdx - startIncludeIdx;
        if (len == 1) {//说明只有一个元素
            return arr;
        } else if (len == 2) {
            int left = arr[startIncludeIdx];
            int right = arr[startIncludeIdx + 1];
            int sum = left + right;
            if (left > right && left > sum) {
                return new int[]{left};
            } else if (right > left && right > sum) {
                return new int[]{right};
            } else {
                return new int[]{left, right};
            }
        }

        int mid = startIncludeIdx + len / 2;
        int[] leftMaxSubArray = findMaxSubArray(arr, startIncludeIdx, mid);
        int leftSum = Arrays.stream(leftMaxSubArray).sum();
        int[] rightMaxSubArray = findMaxSubArray(arr, mid, endExcludIdx);
        int rightSum = Arrays.stream(rightMaxSubArray).sum();
        int[] crossMaxSubArray = findCrossMaxSubArray(arr, startIncludeIdx, mid, endExcludIdx);
        int crossSum = Arrays.stream(crossMaxSubArray).sum();

        if (leftSum > rightSum && leftSum > crossSum) {
            return leftMaxSubArray;
        } else if (rightSum > leftSum && rightSum > crossSum) {
            return rightMaxSubArray;
        } else {
            return crossMaxSubArray;
        }
    }

    //要获得跨左右数组的最大子数组的关键是这个数组必然有包含mid
    //所以这个问题又可以拆成 获取固定mid-1位开始到起始之间的最大数组 和 获取固定mid位开始到结束之间的最大数组
    //再将这两个数组合并起来即是最大数组
    private static int[] findCrossMaxSubArray(int[] arr, int startIncludeIdx, int mid, int endExcludIdx) {
        int leftSideMaxSum = Integer.MIN_VALUE;
        int leftSideMaxSumIdx = mid - 1;
        int leftSideSum = 0;
        for (int i = mid - 1; i >= startIncludeIdx; i--) {
            leftSideSum += arr[i];
            if (leftSideSum > leftSideMaxSum) {
                leftSideMaxSum = leftSideSum;
                leftSideMaxSumIdx = i;
            }
        }

        int rightSideMaxSum = Integer.MIN_VALUE;
        int rightSideMaxSumIdx = mid;
        int rightSideSum = 0;
        for (int i = mid; i < endExcludIdx; i++) {
            rightSideSum += arr[i];
            if (rightSideSum > rightSideMaxSum) {
                rightSideMaxSum = rightSideSum;
                rightSideMaxSumIdx = i;
            }
        }

        return Arrays.copyOfRange(arr, leftSideMaxSumIdx, rightSideMaxSumIdx + 1);
    }
}
