package cn.cqc3073.algorithm;

import java.util.Random;

public class DataGen {
    /**
     * 随机生成2^pow个长度的数组,数值介于(-bound, bound)
     * @param pow
     * @return
     */
    public static int[] gen(int pow, int bound){
        Random random = new Random();
        int[] arr = new int[1 << pow];
        for (int i = 0, len = arr.length; i < len; i++) {
            arr[i] = random.nextInt() % bound;
        }
        return arr;
    }
}
