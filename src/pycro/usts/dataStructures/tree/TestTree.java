package pycro.usts.dataStructures.tree;

/**
 * @author Pycro
 * @version 1.0
 * 2023-04-21 7:54 PM
 */
public class TestTree {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        Node n1 = new Node(1, "天枢");
        Node n2 = new Node(2, "天璇");
        Node n3 = new Node(3, "天玑");
        Node n4 = new Node(4, "天权");
        Node n5 = new Node(5, "玉衡");
        Node n6 = new Node(6, "开阳");
        Node n7 = new Node(7, "摇光");
        n1.setLeft(n2);
        n1.setRight(n3);
        n2.setLeft(n4);
        n2.setRight(n5);
        n3.setLeft(n6);
        n3.setRight(n7);
        binaryTree.setRoot(n1);
        //System.out.println("前序遍历");
        //binaryTree.preOrder();
        //System.out.println("中序遍历");
        //binaryTree.inOrder();
        //System.out.println("后序遍历");
        //binaryTree.postOrder();

        //binaryTree.preOrder();
        //binaryTree.delNode(1);
        //System.out.println("---------------------------");
        //binaryTree.postOrder();

        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        ArrayBinaryTree arrayBinaryTree = new ArrayBinaryTree(arr);
        arrayBinaryTree.postOrder();
    }
}
