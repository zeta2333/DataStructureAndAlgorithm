package pycro.usts.dataStructures.sort;

import java.util.Arrays;

/**
 * @author Pycro
 * @version 1.0
 * 2023-04-20 3:49 PM
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {53, 3, 542, 748, 14, 214};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void radixSort(int[] arr) {
        //找到最大的数
        int maxNum = arr[0];
        for (int item : arr) {
            if (item > maxNum) maxNum = item;
        }
        //得到最大数的位数，即循环次数
        int maxLength = String.valueOf(maxNum).length();

        //二维数组bucket表示十个桶，其中的每一个元素（一维数组）都表示一个桶
        int[][] bucket = new int[10][arr.length];
        //表示每个桶中元素的数量
        int[] counts = new int[10];

        //循环maxLength次
        for (int k = 0, n = 1; k < maxLength; k++, n *= 10) {
            //第k轮循环，取倒数第k位数
            //将arr中的数据放入到桶中
            for (int value : arr) {
                //取arr中每个元素的个位数
                int digit = value / n % 10;
                //添加到指定桶中的指定位置
                bucket[digit][counts[digit]++] = value;
            }
            int arrIdx = 0;
            //将所有桶中的数据再依次放回到arr中
            for (int i = 0; i < 10; i++) {
                //每个桶中有counts[i]个数据
                for (int j = 0; j < counts[i]; j++) {
                    arr[arrIdx++] = bucket[i][j];
                }
                counts[i] = 0;
            }
        }
    }
}
