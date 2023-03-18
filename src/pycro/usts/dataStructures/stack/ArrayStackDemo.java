package pycro.usts.dataStructures.stack;

/**
 * @Author Pycro
 * @Create 2023-03-07  21:13
 * @Description
 * @Version 1.0
 */
public class ArrayStackDemo {
    public static void main(String[] args) {
        //测试栈的方法
        ArrayStack stack = new ArrayStack(5);
//        stack.pop();
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(9);
        stack.push(5);
        stack.push(2);
        stack.showStack();
        System.out.printf("从栈中取出的值为:%d\n",stack.pop());
        stack.showStack();
    }
}

//创建一个类ArrayStack表示栈
class ArrayStack {
    private int maxSize;//栈的大小
    protected int[] stack;//数组，模拟栈，数据放在该数组中
    protected int top = -1;//top表示栈顶，初始化为-1

    //构造器
    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    //栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    //栈空
    public boolean isEmpty() {
        return top == -1;
    }

    //入栈
    public void push(int value) {
        if (isFull()) {
            System.out.printf("栈已满！元素:%d 无法入栈\n", value);
            return;
        }
        stack[++top] = value;
    }

    //出栈
    public int pop() {
        //栈空则抛出异常
        if (isEmpty()) throw new RuntimeException("栈已空！无法取出元素！");
        return stack[top--];
    }

    //遍历，从栈顶往下遍历
    public void showStack() {
        if (isEmpty()) {
            System.out.println("栈已空！无法取出元素！");
            return;
        }
        //辅助变量cur标记当前遍历到的位置
        int cur = top;
        while (cur != -1) {
            System.out.printf("stack[%d]=%d\n", cur, stack[cur--]);
        }
    }
}
