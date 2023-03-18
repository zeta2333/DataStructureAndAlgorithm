package pycro.usts.dataStructures.linkedlist;

import java.util.Stack;

public class TestStack {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        //入栈
        stack.push("Pycro");
        stack.push("Jack");
        stack.push("Tom");
        stack.push("Smith");
        //出栈
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }
}
