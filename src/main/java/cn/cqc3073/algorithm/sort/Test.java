package cn.cqc3073.algorithm.sort;

import java.util.Random;

public class Test {
    public static void main(String[] args) {
//        int[] arr = DataGen.gen(18);
//        MergeSort.sort(Arrays.copyOf(arr, arr.length));
//        InsertionSort.sort(Arrays.copyOf(arr, arr.length));
//        long start = System.currentTimeMillis();
//        Arrays.sort(Arrays.copyOf(arr, arr.length));
//        System.out.printf("Arrays.sort elapse %d ms, array length %d \n", System.currentTimeMillis() - start, arr.length);

//        int[] arr = new int[]{7, 5, 6, 8, 9, 1, 4, 3, 2, 0};
//        System.out.println(Arrays.toString(MergeSort.sort(arr)));

        for (int i = 0; i < 20; i++) {
            System.out.println(new Random().nextInt() % 100);

        }
    }
}
