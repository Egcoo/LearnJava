package Stack.evalRPN;

import java.util.Arrays;
import java.util.Stack;

/**
 * @ author Egcoo
 * @ date 2022/8/3 - 20:13
 * 150. 逆波兰表达式求值 （后缀转中缀）
 * <p>
 * 根据 逆波兰表示法，求表达式的值。
 * 有效的算符包括 +、-、*、/ 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 * 注意 两个整数之间的除法只保留整数部分。
 * <p>
 * 可以保证给定的逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 */
public class ReversePolishNotation {
    public static void main(String[] args) {
        Transfer("1+((2+3)*4)-5");
    }

    public int evalRPN(String[] tokens) {
        int num1;
        int num2;
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            //判断数组中的加减乘除属于哪一个
            switch (tokens[i]) {
                case "+":
                    num1 = Integer.parseInt(stack.pop());
                    num2 = Integer.parseInt(stack.pop());
                    stack.push(String.valueOf((num2 + num1)));
                    break;
                case "-":
                    num1 = Integer.parseInt(stack.pop());
                    num2 = Integer.parseInt(stack.pop());
                    stack.push(String.valueOf((num2 - num1)));
                    break;
                case "*":
                    num1 = Integer.parseInt(stack.pop());
                    num2 = Integer.parseInt(stack.pop());
                    stack.push(String.valueOf((num2 * num1)));
                    break;
                case "/":
                    num1 = Integer.parseInt(stack.pop());
                    num2 = Integer.parseInt(stack.pop());
                    stack.push(String.valueOf((num2 / num1)));
                    break;
                default:
                    stack.push(tokens[i]);
            }

        }

        return Integer.parseInt(stack.pop());
    }

    //中缀转后缀,目前只考虑一位数字的情况

    public static void Transfer(String str) {
        //运算符栈
        Stack<Character> stack1 = new Stack<>();
        //中间结果栈
        Stack<Character> stack2 = new Stack<>();

        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            switch (chars[i]) {
                //判断 是运算符 还是操作数 以及具体的加减乘除或括号
                case '+':
                case '-':
                case '*':
                case '/':
                    //有两种情况 直接存入 s1
                    // 如果 s1 为空 或者栈顶元素是左括号
                    // 如果 当前的运算符 优先级比栈顶元素高 直接存入
                    while (true) {
                        if (stack1.isEmpty() || stack1.peek().equals('(')
                                || compare(chars[i], stack1.peek()) > 0) {
                            stack1.push(chars[i]);
                            break;
                        }
                        stack2.push(stack1.pop());
                    }
                    break;
                case '(':
                    stack1.push(chars[i]);
                    break;
                case ')':
                    //找到 stack 中 左括号的位置
                    while (!stack1.peek().equals('(')) {
                        //中间运算符 取出并存入 s2
                        stack2.push(stack1.pop());
                    }
                    //此时左括号被抵消，所以取出
                    stack1.pop();
                    break;
                default:
                    //是数字
                    stack2.push(chars[i]);
            }
        }
        while (!stack1.empty()) {
            stack2.push(stack1.pop());
        }
        // 将栈中的元素 倒序输出到数组中
        String[] arr = new String[stack2.size()];
        int size = stack2.size() - 1;
        while (!stack2.isEmpty()) {
            arr[size] = stack2.pop() + "";
            size--;
        }

        System.out.println(Arrays.toString(arr));
    }

    public static int compare(char c1, char c2) {
        if (c1 == '+' || c1 == '-') {
            if (c2 == '*' || c2 == '/') {
                return -1;
            }
            return 0;
        }
        if (c1 == '*' || c1 == '/') {
            if (c2 == '+' || c2 == '-') {
                return 1;
            }
            return 0;
        }
        return 0;
    }
}
