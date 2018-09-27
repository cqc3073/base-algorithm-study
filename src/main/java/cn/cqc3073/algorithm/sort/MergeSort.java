package cn.cqc3073.algorithm.sort;

/**
 * 归并排序算法，采用分治设计。 时间复杂度O(n*logn),空间复杂度也是O(n*logn)
 */
public class MergeSort {
    public static int[] sort(int[] nums) {
        long start = System.currentTimeMillis();
        int[] arr = sort(nums, 0, nums.length);
        System.out.printf("MergeSort elapse %d ms, array length %d \n", System.currentTimeMillis() - start, nums.length);
        return arr;
    }

    private static int[] sort(int[] nums, int includeStartIdx, int excludeStopIdx) {

        switch (excludeStopIdx - includeStartIdx) {
            case 1:
                return new int[]{nums[includeStartIdx]};
            case 2:
                //后面的小于前面的
                if (nums[includeStartIdx + 1] < nums[includeStartIdx]) {
                    return new int[]{nums[includeStartIdx + 1], nums[includeStartIdx]};
                }
                return new int[]{nums[includeStartIdx], nums[includeStartIdx + 1]};
            default:
                //对includeStartIdx和excludeStopIdx之间分成两半分别排序
                int binaryIdx = includeStartIdx + (excludeStopIdx - includeStartIdx) / 2;
                int[] leftArr = sort(nums, includeStartIdx, binaryIdx);
                int[] rightArr = sort(nums, binaryIdx, excludeStopIdx);
                int[] newArr = new int[leftArr.length + rightArr.length];

                //再将两半排过序的归并到新的数组中
                for (int i = 0, leftIdx = 0, rightIdx = 0; i < newArr.length; i++) {
                    int leftVal = leftArr[leftIdx];
                    int rightVal = rightArr[rightIdx];
                    if (leftVal < rightVal) {
                        newArr[i] = leftVal;
                        leftIdx++;
                    } else {
                        newArr[i] = rightVal;
                        rightIdx++;
                    }

                    if (leftIdx >= leftArr.length) {
                        System.arraycopy(rightArr, rightIdx, newArr, ++ i, rightArr.length - rightIdx);
                        return newArr;
                    } else if (rightIdx >= rightArr.length) {
                        System.arraycopy(leftArr, leftIdx, newArr, ++ i, leftArr.length - leftIdx);
                        return newArr;
                    }
                }

                return newArr;
        }
    }


}
