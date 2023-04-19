package pycro.usts.dataStructures.sort;

import java.util.Arrays;

/**
 * @author Pycro
 * @version 1.0
 * 2023-04-19 3:18 PM
 */
public class SortTest {
    public static void main(String[] args) {
        int len = 10;
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = (int) (Math.random() * 100);
        }
        //System.out.println(Arrays.toString(arr));
        //FuncUtil.consumerTimer(Arrays::sort, arr);//执行耗时为:6.970s
        //FuncUtil.consumerTimer(BubbleSort::bubbleSort, arr);
        //FuncUtil.consumerTimer(SelectSort::selectSort, arr);
        //FuncUtil.consumerTimer(InsertSort::insertSort, arr);
        //FuncUtil.consumerTimer(ShellSort::shellSort, arr);
        //FuncUtil.consumerTimer(ShellSort::shellSort2, arr);//执行耗时为:24.208s
        long start = System.currentTimeMillis();
        QuickSort.quickSort(arr, 0, arr.length - 1);
        long end = System.currentTimeMillis();
        System.out.printf("执行耗时为:%.3fs\n", (double) (end - start) / 1000);
        System.out.println(Arrays.toString(arr));
    }
}
