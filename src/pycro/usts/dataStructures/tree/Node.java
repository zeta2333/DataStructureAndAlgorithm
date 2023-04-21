package pycro.usts.dataStructures.tree;

/**
 * @author Pycro
 * @version 1.0
 * 2023-04-21 7:08 PM
 */
public class Node {
    private int no;
    private String name;
    private Node left;
    private Node right;

    public Node(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    /**
     * 前序遍历
     */
    public void preOrder() {
        System.out.println(this);
        if (left != null) left.preOrder();
        if (right != null) right.preOrder();
    }

    /**
     * 中序遍历
     */
    public void inOrder() {
        if (left != null) left.inOrder();
        System.out.println(this);
        if (right != null) right.inOrder();
    }

    /**
     * 后序遍历
     */
    public void postOrder() {
        if (left != null) left.postOrder();
        if (right != null) right.postOrder();
        System.out.println(this);
    }

    /**
     * 前序遍历查找
     *
     * @param no
     * @return
     */
    public Node preSearch(int no) {
        if (this.no == no) return this;
        Node leftRes = left == null ? null : left.preSearch(no);
        if (leftRes != null) return leftRes;
        Node rightRes = right == null ? null : right.preSearch(no);
        return rightRes;
    }
    //中序遍历和后序遍历类似
}
