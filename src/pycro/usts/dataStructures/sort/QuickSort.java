package pycro.usts.dataStructures.sort;

/**
 * @author Pycro
 * @version 1.0
 * 2023-04-19 9:46 PM
 */
public class QuickSort {
    public static void quickSort(int[] arr, int left, int right) {
        if (left > right) return;
        int i, j, pivot, temp;
        i = left;
        j = right;
        pivot = arr[right];
        while (i < j) {
            //左侧，依次往右移动
            while (pivot >= arr[i] && i < j) i++;
            //右侧，依次往左移动
            while (pivot <= arr[j] && j > i) j--;
            if (i != j) {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        //只有当i==j时才会跳出循环
        arr[right] = arr[j];
        arr[j] = pivot;
        quickSort(arr, left, j - 1);
        quickSort(arr, j + 1, right);
    }
}
