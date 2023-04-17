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
        //完成将一个中缀表达式转成后缀表达式的功能
        //说明
        //1. 1+((2+3)*4)-5  ==> 1 2 3 + 4 * 5 -
        //2. 因为直接对str操作不方便，所以先将str转换为List
        // 即 "1+((2+3)*4)-5"  ==> ArrayList [1,+,2,....]
        //3. 将得到的中缀表达式对应的List ==> 后缀表达式对应的List
        // 即ArrayList [1,+,(,(,2,3....] ==> ArrayList [1,2,3,+,4,...]
        String expression = "1+((2+3)*4)-5";
        List<String> infixExpressionList = toInfixExpressionList(expression);
        System.out.println("中缀表达式：" + toInfixExpressionList(expression));
        List<String> parseSuffixExpressionList = parseSuffixExpressionList(infixExpressionList);
        System.out.println("后缀表达式：" + parseSuffixExpressionList);
        //计算
        System.out.printf("计算结果为：%d", calc(parseSuffixExpressionList));

        /*
        //先定义一个逆波兰表达式
        //(30+4)*5-6 => 3 4 + 5 * 6 -
        // 4 * 5 - 8 + 60 + 8 / 2 => 4 5 * 8 - 6 + 8 - 60 + 8 2 / +
        //为了方便，逆波兰表达式的数字和符号使用空格隔开
        String suffixExpression = " 30 4 + 5 * 6 - ";
        suffixExpression = "4 5 * 8 - 60 + 8 2 / +";
        //思路：
        //1.先将“3 4 + 5 * 6 -”放入ArrayList中
        //2.将ArrayList传递给一个方法，配合栈完成计算
        List<String> listString = getListString(suffixExpression);
        int res = calc(listString);
        System.out.println(res);
         */
    }

    //将得到的中缀表达式对应的List ==> 后缀表达式对应的List
    public static List<String> parseSuffixExpressionList(List<String> ls) {
        //定义两个栈
        Stack<String> s1 = new Stack<>();//符号栈
        //因为s2这个栈在整个转换过程中没有pop操作，而且后面还需要逆序输出
        //因此比较麻烦，这里不使用Stack，直接用List操作
        //Stack<String> s2 = new Stack<>();//存储中间结果的栈
        List<String> s2 = new ArrayList<>();//存储中间结果的栈

        //遍历ls
        for (String item : ls) {
            //如果是一个数，就加入s2
            if (item.matches("\\d+")) {
                s2.add(item);
            } else if (item.equals("(")) {
                s1.push(item);
            } else if (item.equals(")")) {
                //如果是")",则依次弹出s1栈顶的运算符，并压入s2，直到遇到左括号为止，此时将这一对括号丢弃
                while (!s1.peek().equals("(")) {
                    s2.add(s1.pop());//弹出s1栈顶的运算符，并压入s2
                }
                s1.pop();//将"("弹出s1，消除小括号
            } else {
                //当item的优先级小于等于栈顶运算符的优先级
                //将s1栈顶的运算符弹出并加入s2，再次与s1中新的栈顶运算符比较
                while (s1.size() != 0 && Operation.getValue(s1.peek()) >= Operation.getValue(item)) {
                    s2.add(s1.pop());
                }
                //还需要将item压入栈
                s1.push(item);
            }
        }
        //将s1中剩余的运算符加入到s2中
        while (s1.size() != 0) {
            s2.add(s1.pop());
        }
        return s2;//因为是存放到List中，所以按序输出即为对应的逆波兰表达式
    }

    //将中缀表达式转成对应的List
    public static List<String> toInfixExpressionList(String s) {
        //定义一个List存放中缀表达式对应的内容
        List<String> list = new ArrayList<>();
        int i = 0;//指针，用于遍历中缀表达式字符串
        StringBuilder str;//对多位数的拼接
        do {
            //如果c非数字，就需要加入到ls中
            if (!Character.isDigit(s.charAt(i))) {
                list.add(String.valueOf(s.charAt(i++)));
            } else {//如果是数字，则需要考虑多位数的问题
                str = new StringBuilder();//先将str置空
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    str.append(s.charAt(i++));//拼接
                }
                list.add(str.toString());
            }
        } while (i < s.length());
        return list;
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

//编写一个类Operation，返回一个运算符对应的优先级
class Operation {
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    //写一个方法，返回对应的优先级数字
    public static int getValue(String operation) {
        return switch (operation) {
            case "+" -> ADD;
            case "-" -> SUB;
            case "*" -> MUL;
            case "/" -> DIV;
            default -> 0;
        };
    }
}