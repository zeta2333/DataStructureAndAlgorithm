package pycro.usts.dataStructures.recursion;

/**
 * @author Pycro
 * @version 1.0
 * 2023-04-18 8:57 PM
 */
public class EightEmpresses {
    //定义一个max表示共有多少个皇后
    int NUM = 8;
    //定义数组array，保存皇后放置位置的结果，比如arr = {0,4,7,...}
    int[] array = new int[NUM];
    //定义一个变量，用于计算次数
    static int cnt = 0;
    //统计judge的次数
    static int judgeCnt = 0;

    public static void main(String[] args) {
        //    测试
        EightEmpresses queen = new EightEmpresses();
        queen.check(0);
        System.out.printf("一共判断了%d次", judgeCnt);
    }

    //编写一个方法，放置第n个皇后
    //特别注意：check方法中，每次进入一个递归，都有一个for循环
    private void check(int n) {
        if (n == NUM) {//n=8,其实8个皇后已经放好了
            print();
            return;
        }
        //按位置依次放入并判断是否冲突
        for (int i = 0; i < NUM; i++) {
            //    先把该皇后放在改行的第1列
            array[n] = i;
            //判断当前第n个皇后是否冲突
            if (judge(n)) {//不冲突
                //接着放置n+1个皇后，即开始递归
                check(n + 1);
            }
            //如果冲突，继续执行array[n] = i;即将第n和皇后，放置在本行的最后一个位置
        }
    }

    //查看当我们放置第n个皇后，就去检测该皇后是否和前面已经摆放的皇后冲突

    /**
     * @param n 表示第n个皇后
     * @return
     */
    private boolean judge(int n) {
        judgeCnt++;
        for (int i = 0; i < n; i++) {
            //说明
            //array[i] == array[n]判断是否在同一列
            //Math.abs(i - n) == Math.abs(array[i] - array[n])判断是否在同一斜线
            if (array[i] == array[n] || Math.abs(i - n) == Math.abs(array[i] - array[n])) return false;
        }
        return true;
    }

    //写一个方法，可以将皇后摆放的位置输出
    private void print() {
        System.out.print(++cnt + " : ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
