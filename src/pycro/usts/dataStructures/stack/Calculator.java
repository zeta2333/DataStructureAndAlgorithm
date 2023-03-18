package pycro.usts.dataStructures.stack;

/**
 * @Author Pycro
 * @Create 2023-03-08  14:43
 * @Description
 * @Version 1.0
 */
public class Calculator {
    public static void main(String[] args) {
        //根据思路，完成表达式的运算
        String expression = "70*20*20-50+10-500+30-400";//如何处理多位数的问题
        //创建两个栈，数栈，符号栈
        ArrayStackCalc numStack = new ArrayStackCalc(10);
        ArrayStackCalc operStack = new ArrayStackCalc(10);
        //定义需要的相关变量
        int index = 0;//用于扫描
        int num1, num2, oper;
        int res;
        char ch;//将每次扫描得到的char保存到ch
        StringBuilder keepNum = new StringBuilder();
        //开始while循环的扫描expression
        while (index < expression.length()) {
            ch = expression.substring(index, index + 1).charAt(0);
            //判断ch是什么，然后做相应的处理
            if (operStack.isOper(ch)) {//如果是运算符
                //栈非空的情况下判断，小于则pop出来计算
                while (!operStack.isEmpty() && operStack.priority(ch) <= operStack.priority(operStack.peek())) {
                    num1 = numStack.pop();
                    num2 = numStack.pop();
                    oper = operStack.pop();
                    res = numStack.cal(num2, num1, oper);
                    //运算结果入数栈
                    numStack.push(res);
                }
                //然后将当前运算符入符号栈
                operStack.push(ch);
            } else {
                //分析思路：
                /*
                1.当处理多位数时，需要判断是否为多位数
                2.如果是数，不能直接入栈，需要拼接，如果是符号，则直接入栈
                3. 定义一个字符串，用于拼接
                 */
                //处理多位数
                keepNum.append(ch);
                //如果ch已经是最后一位，则直接入栈
                if (index == expression.length() - 1) {
                    numStack.push(Integer.parseInt(keepNum.toString()));
                } else {//判断下一个是不是数字，是则继续扫描
                    if (operStack.isOper(expression.substring(index + 1, index + 2).charAt(0))) {
                        //如果后一位是运算符，则入栈
                        numStack.push(Integer.parseInt(keepNum.toString()));
                        //重要！！！：清空keepNum
                        keepNum = new StringBuilder();
                    }
                }
            }
            //index加1，并判断是否扫描到expression的最后
            index++;
        }
        //扫描完毕，则顺序从数栈和符号栈中pop出相应的数字和符号进行运算。
        while (!operStack.isEmpty()) {
            //如果符号栈为空，则计算结束，数栈只有一个数
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.cal(num2, num1, oper);
            numStack.push(res);//入栈
        }
        //数栈的最后一个数pop出，就是结果
        System.out.printf("表达式%s = %d", expression, numStack.pop());
    }
}

//创建一个栈，直接使用前面创建好的
class ArrayStackCalc extends ArrayStack {

    public ArrayStackCalc(int maxSize) {
        super(maxSize);
    }

    //返回运算符的优先级，由程序员确定，优先级使用数字表示
    //数字越大，则优先级越高
    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;//假设运算符只有+、-、*、/
        }
    }

    //判断是不是一个运算符
    public boolean isOper(char var) {
        return var == '+' || var == '-' || var == '*' || var == '/';
    }

    //计算方法
    public int cal(int num1, int num2, int oper) {
        int res = 0;//结果
        switch (oper) {
            case '+' -> res = num1 + num2;
            case '-' -> res = num1 - num2;
            case '*' -> res = num1 * num2;
            case '/' -> res = num1 / num2;
        }
        return res;
    }

    //返回当前栈顶的值，但不出栈
    public int peek() {
        return stack[top];
    }
}