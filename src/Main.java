import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("输入上限（建议3位数到7位数之间）：");
        int limit = sc.nextInt();
        //开始计时
        long startTime = System.currentTimeMillis();
        //随机数生成
        int base = (int) (Math.random() * limit);
        int exp = (int) (Math.random() * limit);
        System.out.printf("底数为%d,指数为%d\n", base, exp);
        //计算
        BigInteger res = bigNumberPower(base, exp);
        //结束计时
        long endTime = System.currentTimeMillis();
        System.out.printf("耗时%fs\n", (double) (endTime - startTime) / 1000);
        String resStr = res.toString();
        System.out.printf("结果有%d位\n", resStr.length());

        //后续处理
        //判断是否将数据写入文件中
        System.out.print("是否将结果写入文件中(Y/N)：");
        if (sc.next().substring(0, 1).equalsIgnoreCase("y")) {
            System.out.print("请输入文件名：");
            writeArrToFile(resStr, sc.next());
        }
        sc.close();
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