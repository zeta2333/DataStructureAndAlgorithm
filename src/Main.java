import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;

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