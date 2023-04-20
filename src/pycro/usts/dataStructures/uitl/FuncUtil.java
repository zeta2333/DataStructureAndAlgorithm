package pycro.usts.dataStructures.uitl;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @author Pycro
 * @version 1.0
 * 2023-04-19 12:05 PM
 */
public class FuncUtil {
    public static <T, R> void funcTimer(Function<T, R> func, T arg) {
        long start = System.currentTimeMillis();
        func.apply(arg);
        long end = System.currentTimeMillis();
        System.out.printf("执行耗时为:%.3fs\n", (double) (end - start) / 1000);
    }

    public static <T> void consumerTimer(Consumer<T> consumer, T arg) {
        long start = System.currentTimeMillis();
        consumer.accept(arg);
        long end = System.currentTimeMillis();
        System.out.printf("执行耗时为:%.3fs\n", (double) (end - start) / 1000);
    }

    public static void biConsumerTimer(BiConsumer<int[], int[]> bic, int[] arr, int[] args) {
        long start = System.currentTimeMillis();
        bic.accept(arr, args);
        long end = System.currentTimeMillis();
        System.out.printf("执行耗时为:%.3fs\n", (double) (end - start) / 1000);
    }
}
