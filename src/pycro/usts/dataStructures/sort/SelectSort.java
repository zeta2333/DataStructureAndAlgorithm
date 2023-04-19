package pycro.usts.dataStructures.sort;

/**
 * @author Pycro
 * @version 1.0
 * 2023-04-19 3:13 PM
 */
@SuppressWarnings("all")
public class SelectSort {

    public static void selectSort(int[] arr) {
        int minVal, minIdx = 0;
        for (int i = 0; i < arr.length; i++) {
            minVal = arr[i];
            //每次循环，找出当前范围的最小值
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < minVal) {
                    minVal = arr[j];
                    minIdx = j;
                }
            }
            //交换，将最小值放到当前范围的最前面
            arr[minIdx] = arr[i];
            arr[i] = minVal;
        }
    }
}
