package pycro.usts.dataStructures.sort;

/**
 * @author Pycro
 * @version 1.0
 * 2023-04-20 11:36 AM
 */
@SuppressWarnings("all")
public class MergeSort {

    public static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        //先对数组进行拆分
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        //拆分完毕后进行合并
        merge(arr, left, right);
    }


    private static void merge(int[] arr, int left, int right) {
        int mid = left + (right - left) / 2;
        int[] tmp = new int[right - left + 1];//tmp的长度即为当前分组的长度
        int i = left, j = mid + 1, k = 0;//三个指针

        //两边填充
        while (i <= mid && j <= right) tmp[k++] = arr[i] < arr[j] ? arr[i++] : arr[j++];

        //一边填充完毕后，另一边剩余直接加入tmp
        while (i <= mid) tmp[k++] = arr[i++];
        while (j <= right) tmp[k++] = arr[j++];

        //将tmp中的数组再加回到arr中
        for (int m = 0; m < tmp.length; m++) arr[left + m] = tmp[m];

    }

    public static void mergeSortTwoArgs(int[] arr, int[] args) {
        int left = args[0], right = args[1];
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        mergeSortTwoArgs(arr, new int[]{left, mid});
        mergeSortTwoArgs(arr, new int[]{mid + 1, right});
        merge(arr, left, right);
    }
}
