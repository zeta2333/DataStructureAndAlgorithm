package pycro.usts.dataStructures.sort;

/**
 * @author Pycro
 * @version 1.0
 * 2023-04-19 11:50 AM
 */
public class BubbleSort {

    //时间复杂度O(n^2)
    public static void bubbleSort(int[] arr) {
        //优化：判断当前轮次是否已经有序
        boolean isSorted;
        int temp;//临时变量
        for (int i = arr.length - 1; i > 0; i--) {
            isSorted = true;
            //每一轮排序，将当前范围中最大的数排到最后
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    isSorted = false;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            //如果数组已经有序，则直接结束循环
            if (isSorted) break;
        }
    }
}
