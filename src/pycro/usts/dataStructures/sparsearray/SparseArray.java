package pycro.usts.dataStructures.sparsearray;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class SparseArray {

    public static void main(String[] args) {
        //创建一个原始的二维数组11*11
        //0表示没有棋子，1表示黑子，2表示白子
        int[][] chessArr1 = new int[15][15];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[4][5] = 3;
        chessArr1[14][14] = 9;
        //输出原始的二维数组
        System.out.println("原始的二维数组为:");
        for (int i = 0; i < chessArr1.length; i++) {
            System.out.println(Arrays.toString(chessArr1[i]));
        }

        //将二维数组转为稀疏数组
        int[][] sparseArr = arrToSparse(chessArr1);

        //输出稀疏数组内容
        System.out.println("得到的稀疏数组为:");
        for (int i = 0; i < sparseArr.length; i++) {
            System.out.println(Arrays.toString(sparseArr[i]));
        }

        //将稀疏数组还原为原来的二维数组

        int[][] chessArr2 = sparseToArr(sparseArr);

        //输出恢复后的二维数组
        System.out.println("恢复后的二维数组为:");
        for (int i = 0; i < chessArr2.length; i++) {
            System.out.println(Arrays.toString(chessArr2[i]));
        }

        //写入
        writeArrToFile(chessArr2);

        //读取
        System.out.println("读取的值为:");
        int[][] resArr = readArrFromFile("map.dat");
        for (int i = 0; i < resArr.length; i++) {
            System.out.println(Arrays.toString(resArr[i]));
        }
    }

    //二维数组转为稀疏数组
    public static int[][] arrToSparse(int[][] arr) {
        //1.先遍历二维数组，得到非0数据的个数
        int sum = 0;
        for (int[] ints : arr) {
            for (int anInt : ints) {
                sum += anInt != 0 ? 1 : 0;
            }
        }

        //2.创建对应的稀疏数组
        int[][] sparseArr = new int[sum + 1][3];
        //给稀疏数组赋值
        sparseArr[0] = new int[]{arr.length, arr[0].length, sum};
        //遍历二维数组，将非0值存放到稀疏数组中
        int cnt = 0;//cnt用于记录是第几个非0数据
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != 0) {
                    sparseArr[++cnt] = new int[]{i, j, arr[i][j]};
                }
            }
        }
        return sparseArr;
    }

    public static int[][] sparseToArr(int[][] sparseArr) {
        //1.读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组
        int[][] arr = new int[sparseArr[0][0]][sparseArr[0][1]];

        //2.读取稀疏数组后几行的数据，并赋值给原始的是二维数组
        for (int i = 1; i < sparseArr.length; i++) {
            arr[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        return arr;
    }

    //将数组写入data.txt中
    public static void writeArrToFile(int[][] arr) {
        FileWriter fw = null;
        try {
            //1.提供File类的对象
            File file = new File("map.dat");
            //2.提供FileWriter类的对象
            fw = new FileWriter(file);
            //3.写入数组内容
            for (int i = 0; i < arr.length; i++) {
                fw.write(Arrays.toString(arr[i]) + "\n");
            }
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



    //读取数据
    public static int[][] readArrFromFile(String fileName) {
        FileReader fr = null;
        int[][] resArr;
        try {
            //1.File类的实例化
            File file = new File(fileName);
            //2.FileReader流的实例化
            fr = new FileReader(file);
            //3.读取的操作
            resArr = new int[15][15];
            int data;
            int cnt = 0;
            StringBuilder sb = new StringBuilder();
            while ((data = fr.read()) != -1) {
                char ch = (char) data;
                if (ch != '\n') {
                    sb.append(ch);
                } else {
                    String str = sb.toString();
                    sb = new StringBuilder();
                    str = str.substring(1, str.length() - 1).replace(" ", "");
                    String[] arrRow = str.split(",");
                    for (int i = 0; i < arrRow.length; i++) {
                        resArr[cnt][i] = Integer.parseInt(arrRow[i]);
                    }
                    cnt++;
                }

            }
            return resArr;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fr != null) fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
