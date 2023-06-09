package pycro.usts.dataStructures.sort;

/**
 * @author Pycro
 * @version 1.0
 * 2023-04-19 9:46 PM
 */
@SuppressWarnings("all")
public class QuickSort {
    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) return;
        //取最右侧元素作为支点
        int i = left, j = right, pivot = arr[right];
        while (i < j) {
            //先左侧，依次往右移动
            while (pivot >= arr[i] && i < j) i++;
            //再右侧，依次往左移动
            while (pivot <= arr[j] && j > i) j--;
            if (i < j) {//i和j移动到指定位置后，若i仍在j前面，则交换
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        //跳出循环，此时i必然等于j
        arr[right] = arr[i];
        arr[i] = pivot;
        //i的位置归位，之后左右分别递归排序
        quickSort(arr, left, i - 1);
        quickSort(arr, i + 1, right);
    }

    public static void quickSortTwoArgs(int[] arr, int[] args) {
        int left = args[0];
        int right = args[1];
        if (left > right) return;
        int i = left, j = right, pivot = arr[right];
        while (i < j) {
            //左侧，依次往右移动
            while (pivot >= arr[i] && i < j) i++;
            //右侧，依次往左移动
            while (pivot <= arr[j] && j > i) j--;
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        //只有当i==j时才会跳出循环
        arr[right] = arr[i];
        arr[i] = pivot;
        quickSortTwoArgs(arr, new int[]{left, i - 1});
        quickSortTwoArgs(arr, new int[]{i + 1, right});
    }

}
