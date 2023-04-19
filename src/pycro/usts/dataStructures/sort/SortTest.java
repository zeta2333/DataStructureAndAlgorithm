package pycro.usts.dataStructures.sort;

import pycro.usts.dataStructures.uitl.FuncUtil;

import java.util.Arrays;

/**
 * @author Pycro
 * @version 1.0
 * 2023-04-19 3:18 PM
 */
public class SortTest {
    public static void main(String[] args) {
        int len = 80000;
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = (int) (Math.random() * 800_0000);
        }
        FuncUtil.consumerTimer(SelectSort::selectSort, arr);
        System.out.println(Arrays.toString(arr));
    }
}
