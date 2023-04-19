package pycro.usts.dataStructures.sort;

import pycro.usts.dataStructures.uitl.FuncUtil;

import java.util.Arrays;

/**
 * @author Pycro
 * @version 1.0
 * 2023-04-19 11:50 AM
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[100000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100000);
        }
        System.out.println(Arrays.toString(arr));
        FuncUtil.consumerTimer(BubbleSort::bubbleSort, arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr) {
        boolean isSorted;
        for (int i = arr.length - 1; i > 0; i--) {
            isSorted = true;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    isSorted = false;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (isSorted) break;
        }
    }
}
