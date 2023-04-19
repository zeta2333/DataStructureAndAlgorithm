package pycro.usts.dataStructures.sort;

/**
 * @author Pycro
 * @version 1.0
 * 2023-04-19 4:24 PM
 */
public class InsertSort {
    public static void insertSort(int[] arr) {
        int insertVal, insertIdx;
        for (int i = 1; i < arr.length; i++) {
            //待插入的值
            insertVal = arr[i];
            //插入的位置
            insertIdx = i;
            //后移
            while (insertIdx > 0 && arr[insertIdx-1] > insertVal) {
                arr[insertIdx] = arr[insertIdx - 1];
                insertIdx--;
            }
            //找到插入位置，插入
            arr[insertIdx] = insertVal;
        }
    }
}
