package pycro.usts.dataStructures.tree;

/**
 * @author Pycro
 * @version 1.0
 * 2023-04-21 10:14 PM
 */
public class ArrayBinaryTree {
    private int[] array;

    public ArrayBinaryTree(int[] array) {
        this.array = array;
    }

    /**
     * 前序遍历
     */
    public void preOrder(int idx) {
        System.out.println(array[idx]);
        if (2 * idx + 1 < array.length) preOrder(2 * idx + 1);
        if (2 * idx + 2 < array.length) preOrder(2 * idx + 2);
    }

    public void preOrder() {
        preOrder(0);
    }

    /**
     * 中序遍历
     */
    public void inOrder(int idx) {
        if (2 * idx + 1 < array.length) inOrder(2 * idx + 1);
        System.out.println(array[idx]);
        if (2 * idx + 2 < array.length) inOrder(2 * idx + 2);
    }

    public void inOrder() {
        inOrder(0);
    }

    /**
     * 后序遍历
     */
    public void postOrder(int idx) {
        if (2 * idx + 1 < array.length) postOrder(2 * idx + 1);
        if (2 * idx + 2 < array.length) postOrder(2 * idx + 2);
        System.out.println(array[idx]);
    }

    public void postOrder() {
        postOrder(0);
    }
}
