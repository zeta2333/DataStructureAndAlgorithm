package pycro.usts.dataStructures.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author Pycro
 * @version 1.0
 * 2023-03-27 21:26
 */
public class PolandNotation {
    public static void main(String[] args) {
        //先定义一个逆波兰表达式
        //(3+4)*5-6 => 3 4 + 5 * 6 -
        //为了方便，逆波兰表达式的数字和符号使用空格隔开
        String suffixExpression = " 3 4 + 5 * 6 - ";
        //思路：
        //1.先将“3 4 + 5 * 6 -”放入ArrayList中
        //2.将ArrayList传递给一个方法，配合栈完成计算
        List<String> listString = getListString(suffixExpression);
        int res = calc(listString);
        System.out.println(res);
    }

    //将逆波兰表达式，依次将数据和运算符放入到ArrayList中
    public static List<String> getListString(String suffixExpression) {
        String[] split = suffixExpression.strip().split(" ");
        return new ArrayList<>(Arrays.asList(split));
    }

    //完成对逆波兰表达式的计算
    public static int calc(List<String> list) {
        //创建一个栈
        Stack<String> stack = new Stack<>();
        //遍历list
        for (String item : list) {
            //这里使用正则表达式来取出数
            if (item.matches("\\d+")) {//可以匹配多位数
                //入栈
                stack.push(item);
            } else {
                //弹出两个数计算，再重新运算
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res;
                switch (item) {
                    case "+" -> res = num1 + num2;
                    case "-" -> res = num1 - num2;
                    case "*" -> res = num1 * num2;
                    case "/" -> res = num1 / num2;
                    default -> throw new RuntimeException("运算符有误");
                }
                stack.push("" + res);
            }
        }
        //最后留在stack中的数据就是运算结果
        return Integer.parseInt(stack.pop());
    }
}
