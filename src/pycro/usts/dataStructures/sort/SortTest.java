package pycro.usts.dataStructures.sort;

import pycro.usts.dataStructures.uitl.FuncUtil;

/**
 * @author Pycro
 * @version 1.0
 * 2023-04-19 3:18 PM
 */
public class SortTest {
    public static void main(String[] args) {
        int len = 79999;
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = (int) (Math.random() * Integer.MAX_VALUE + Integer.MIN_VALUE);
            //arr[i] = (int) (Math.random() * 100);
        }
        int[] arrPrint = {8, 4, 5, 7, 1, 3, 6, 2};
        //System.out.println(Arrays.toString(arr));
        //FuncUtil.consumerTimer(Arrays::sort, arr);//执行耗时为:6.970s
        //FuncUtil.consumerTimer(BubbleSort::bubbleSort, arr);
        //FuncUtil.consumerTimer(SelectSort::selectSort, arr);
        //FuncUtil.consumerTimer(InsertSort::insertSort, arr);
        //FuncUtil.consumerTimer(ShellSort::shellSort, arr);
        //FuncUtil.consumerTimer(ShellSort::shellSort2, arr);//执行耗时为:24.208s
        //FuncUtil.biConsumerTimer(QuickSort::quickSortTwoArgs, arr, new int[]{0, arr.length - 1});
        FuncUtil.biConsumerTimer(MergeSort::mergeSortTwoArgs, arr, new int[]{0, arr.length - 1});
        //System.out.println(Arrays.toString(arr));
    }
}
