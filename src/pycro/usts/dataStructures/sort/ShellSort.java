package pycro.usts.dataStructures.sort;

/**
 * @author Pycro
 * @version 1.0
 * 2023-04-19 7:56 PM
 */
public class ShellSort {
    //逐步推导，希尔排序(交换式)
    public static void shellSort(int[] arr) {
        //gap
        int temp;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //遍历各组中所有的元素，共gap组，每组约arr.length/gap个元素
            for (int i = gap; i < arr.length; i++) {
                //大于则交换
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
        }
    }

    //改进：希尔排序(移位式)
    public static void shellSort2(int[] arr) {
        int temp, idx;
        //增量gap，逐步缩小增量
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                //待插入的值
                temp = arr[i];
                //插入的位置
                idx = i;
                //后移
                while (idx - gap >= 0 && arr[idx - gap] > temp) {
                    arr[idx] = arr[idx - gap];
                    idx -= gap;
                }
                //插入
                arr[idx] = temp;
            }
        }
    }
}
