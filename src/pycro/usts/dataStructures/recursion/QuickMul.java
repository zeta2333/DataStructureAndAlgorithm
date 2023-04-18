package pycro.usts.dataStructures.recursion;

/**
 * @author Pycro
 * @version 1.0
 * 2023-04-18 10:04 PM
 */
public class QuickMul {
    public static void main(String[] args) {
        System.out.println(commonMul(2, 10));
        System.out.println(quickMulByRecurse(2, 10));
        System.out.println(quickMulByIterate(2, 10));
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
