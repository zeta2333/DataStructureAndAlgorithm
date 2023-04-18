import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int a = (int) '1';
        System.out.println(a);
    }

    //计算
    public static BigInteger bigNumberPower(int a, int e) {
        BigInteger base = new BigInteger(String.valueOf(a));
        return base.pow(e);
    }

    //将数组写入data.txt中
    public static void writeArrToFile(String data, String fileName) {
        FileWriter fw = null;
        try {
            //1.提供File类的对象
            File file = new File(fileName);
            //2.提供FileWriter类的对象
            fw = new FileWriter(file);
            //3.写入数组内容
            fw.write(data);
            System.out.println("写入成功！");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.流资源的关闭
            try {
                if (fw != null) fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

class   MergeSort {
    public static void main(String[] args) {
        int[] arr = {1,0};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr)); // 输出：[3, 4, 5, 6, 8]
    }

    /**
     * 归并排序
     * @param arr 待排序数组
     * @param left 左边界
     * @param right 右边界
     */
    public static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid); // 对左半部分进行归并排序
        mergeSort(arr, mid + 1, right); // 对右半部分进行归并排序
        merge(arr, left, mid, right); // 合并两个已排序的子数组
    }

    /**
     * 合并两个已排序的子数组
     * @param arr 待排序数组
     * @param left 左边界
     * @param mid 中间位置
     * @param right 右边界
     */
    public static void merge(int[] arr, int left, int mid, int right) {
        int[] tmp = new int[right - left + 1]; // 临时数组，用于存储合并后的结果
        int i = left; // 第一个子数组的起始位置
        int j = mid + 1; // 第二个子数组的起始位置
        int k = 0; // 临时数组的下标
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                tmp[k++] = arr[i++];
            } else {
                tmp[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            tmp[k++] = arr[i++];
        }
        while (j <= right) {
            tmp[k++] = arr[j++];
        }
        for (int m = 0; m < tmp.length; m++) {
            arr[left + m] = tmp[m];
        }
    }

}
