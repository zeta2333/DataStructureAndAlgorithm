package pycro.usts.dataStructures.search;

/**
 * @author Pycro
 * @version 1.0
 * 2023-04-21 8:56 AM
 * 插值查找：可以视为"加权"的二分查找
 */
public class InsertValueSearch {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i + 1;
        }
        int index = insertValueSearch(arr, 78);
        System.out.println(index);
    }

    public static int insertValueSearch(int[] arr, int target) {
        int l, r, mid;
        l = 0;
        r = arr.length - 1;
        while (l <= r) {
            mid = l + (r - l) * (target - arr[l]) / (arr[r] - arr[l]);//mid按比例移动
            if (arr[mid] == target) return mid;
            if (arr[mid] > target) r = mid - 1;
            else l = mid + 1;
        }
        return -1;
    }
}
