package pycro.usts.dataStructures.search;

/**
 * @author Pycro
 * @version 1.0
 * 2023-04-21 8:28 AM
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < 1000; i++) {
            arr[i] = i + 1;
        }
        System.out.println(binarySearch(arr, 1));
    }

    public static int binarySearch(int[] arr, int target) {
        int l = 0, r = arr.length - 1, mid;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (arr[mid] == target) return mid;
            if (arr[mid] < target) l = mid + 1;
            else r = mid - 1;
        }
        return -1;
    }
}
