package Stack;

import java.util.Stack;

/**
 * @ author Egcoo
 * @ date 2022/8/1 - 15:22
 */
public class StackTest {
    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
