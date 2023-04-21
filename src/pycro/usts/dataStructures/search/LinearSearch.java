package pycro.usts.dataStructures.search;

/**
 * @author Pycro
 * @version 1.0
 * 2023-04-21 8:17 AM
 */
public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = new int[]{7, 3, 5, 8, 1, 6, 4, 2};
        System.out.println(linearSearch(arr, 0));
    }

    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) return i;
        }
        return -1;
    }
}
