package pycro.usts.dataStructures.stack;

/**
 * @Author Pycro
 * @Create 2023-03-07  21:42
 * @Description
 * @Version 1.0
 */
public class LinkedListStackDemo {
    public static void main(String[] args) {
        LinkedListStack stack = new LinkedListStack(5);
//        stack.pop();
        stack.push(new Node(4));
        stack.push(new Node(2));
        stack.push(new Node(7));
        stack.push(new Node(5));
        stack.push(new Node(8));
        stack.push(new Node(9));
        stack.showStack();
        Node popNode = stack.pop();
        System.out.println("取出的值为" + popNode);
        stack.showStack();
    }
}

//链表实现栈
class LinkedListStack {
    int maxSize;//栈的大小
    SingleLinkedList stack = new SingleLinkedList();//链表，模拟栈

    //构造器
    public LinkedListStack(int maxSize) {
        this.maxSize = maxSize;
    }

    //栈满
    public boolean isFull() {
        return stack.size() == maxSize;
    }

    //栈空
    public boolean isEmpty() {
        return stack.size() == 0;
    }

    //入栈
    public void push(Node node) {
        if (isFull()) {
            System.out.println("栈已满！无法入栈");
            return;
        }
        //链表的加入操作
        stack.add(node);
    }

    //出栈
    public Node pop() {
        if (isEmpty()) throw new RuntimeException("栈已空！");
        Node res = stack.getLastNode();
        stack.remove();
        return res;
    }

    //遍历栈
    public void showStack() {
        stack.showList();
    }
}

//单链表
class SingleLinkedList {
    //由于是为了构建栈的链表，所以这里声明尾部节点（不含）
    private Node tail = new Node(0);

    public Node getTail() {
        return tail;
    }

    //添加节点（到尾部）
    public void add(Node node) {
        node.next = tail.next;
        tail.next = node;
    }

    //删除尾结点
    public void remove() {
        if (tail.next != null)
            tail.next = tail.next.next;
    }

    //返回尾节点
    public Node getLastNode() {
        if (size() == 0) throw new RuntimeException("链表为空！");
        return tail.next;
    }

    //求长度
    public int size() {
        int size = 0;
        Node temp = tail.next;
        while (temp != null) {
            temp = temp.next;
            size++;
        }
        return size;
    }

    //遍历
    public void showList() {
        Node temp = tail.next;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }
}

//节点类
class Node {
    public int value;
    public Node next;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}