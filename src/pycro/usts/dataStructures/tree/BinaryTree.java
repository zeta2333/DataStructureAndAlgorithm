package pycro.usts.dataStructures.tree;

/**
 * @author Pycro
 * @version 1.0
 * 2023-04-21 7:50 PM
 */
public class BinaryTree {
    private Node root;//根节点

    //设置根节点
    public void setRoot(Node node) {
        this.root = node;
    }

    /**
     * 前序遍历
     */
    public void preOrder() {
        if (root != null) preOrder(root);
        else System.out.println("空二叉树");
    }

    public void preOrder(Node node) {
        if (node == null) return;
        System.out.println(node);
        preOrder(node.getLeft());
        preOrder(node.getRight());
    }

    /**
     * 中序遍历
     */
    public void inOrder() {
        if (root != null) inOrder(root);
        else System.out.println("空二叉树");
    }

    public void inOrder(Node node) {
        if (node == null) return;
        inOrder(node.getLeft());
        System.out.println(node);
        inOrder(node.getRight());
    }

    /**
     * 后序遍历
     */
    public void postOrder() {
        if (root != null) postOrder(root);
        else System.out.println("空二叉树");
    }

    public void postOrder(Node node) {
        if (node == null) return;
        postOrder(node.getLeft());
        postOrder(node.getRight());
        System.out.println(node);
    }

    /**
     * 前序遍历查找
     *
     * @param node
     * @param no
     * @return
     */
    public Node preSearch(Node node, int no) {
        if (node == null) return null;
        //中
        if (node.getNo() == no) return node;
        //左
        Node leftRes = preSearch(node.getLeft(), no);
        if (leftRes != null) return leftRes;
        //右
        return preSearch(node.getRight(), no);
    }

    /**
     * 中序遍历查找
     *
     * @return
     */
    public Node inSearch(Node node, int no) {
        if (node == null) return null;
        //左
        Node leftRes = inSearch(node.getLeft(), no);
        if (leftRes != null) return leftRes;
        //中
        if (node.getNo() == no) return node;
        //右
        return inSearch(node.getRight(), no);
    }

    public Node postSearch(Node node, int no) {
        if (node == null) return null;
        //左
        Node leftRes = postSearch(node.getLeft(), no);
        if (leftRes != null) return leftRes;
        //右
        Node rightRes = postSearch(node.getRight(), no);
        if (rightRes != null) return rightRes;
        //中
        if (node.getNo() == no) return node;
        return null;
    }

    /**
     * 根据no删除节点（子树）
     *
     * @param node
     * @param no   1.如果当前节点的左子节点不为空且恰好为要删除的节点，则将左子节点置为null
     *             2.如果当前节点的右子节点不为空且恰好为要删除的节点，则将右子节点置为null
     *             3.如果上述情况不满足，则对左子树递归删除
     *             3.如果上述情况不满足，则对右子树递归删除
     */
    public void delNode(Node node, int no) {
        Node left = node.getLeft();
        if (left != null && left.getNo() == no) node.setLeft(null);
        Node right = node.getRight();
        if (right != null && right.getNo() == no) node.setRight(null);
        if (left != null) delNode(left, no);
        if (right != null) delNode(right, no);
    }

    public void delNode(int no) {
        if (root != null && root.getNo() == no) root = null;
        else delNode(root, no);
    }

}
