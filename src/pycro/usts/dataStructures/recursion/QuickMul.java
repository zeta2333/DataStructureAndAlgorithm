package pycro.usts.dataStructures.recursion;

import java.util.function.BiFunction;

/**
 * @author Pycro
 * @version 1.0
 * 2023-04-18 10:04 PM
 */
public class QuickMul {
    public static void main(String[] args) {
        MulWithTime(1234567890.0, 987654321000L, QuickMul::commonMul);
        MulWithTime(123456789.0, 987654321L, QuickMul::quickMulByRecurse);
        MulWithTime(123456789.0, 987654321L, QuickMul::quickMulByIterate);
    }

    public static void MulWithTime(double x, long n, BiFunction<Double, Long, Double> mulMethod) {
        long start = System.currentTimeMillis();
        Double apply = mulMethod.apply(x, n);
        System.out.println("计算结果为" + apply);
        long end = System.currentTimeMillis();
        System.out.println("耗时" + (double) (end - start) / 1000 + "秒");
    }

    //普通乘法
    public static double commonMul(double x, long n) {
        double res = 1;
        for (long i = 0; i < n; i++) {
            res *= x;
        }
        return res;
    }

    //快速幂 + 递归
    public static double quickMulByRecurse(double x, long n) {
        if (n == 0) return 1;
        double y = quickMulByRecurse(x, n / 2);
        return n % 2 == 0 ? y * y : y * y * x;
    }


    //快速幂 + 迭代
    public static double quickMulByIterate(double x, long n) {
        double res = 1;
        //二进制拆分的同时计算答案
        while (n > 0) {
            //如果n为奇数，即n的最低位为1，则对res进行操作
            if (n % 2 == 1) res *= x;
            x *= x;//x每次自乘
            n >>= 1;//n每次右移一位，去掉最低位
        }
        return res;
    }
}
