package pycro.usts.dataStructures.recursion;

/**
 * @author Pycro
 * @version 1.0
 * 2023-04-18 4:20 PM
 */
public class RecursionTest {
    public static void main(String[] args) {
        test(17648);
        //System.out.println(factorial(-1));
    }

    public static void test(int n) {
        if (n > 1) {
            test(n - 1);
        }
        System.out.println("n = " + n);
    }

    public static int factorial(int n) {
        if (n > 0) return n * factorial(n - 1);
        else return 1;
    }
}
