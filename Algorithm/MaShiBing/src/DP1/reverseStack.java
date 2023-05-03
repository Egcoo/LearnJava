package DP1;

import java.util.Stack;

/**
 * @ author Egcoo
 * @ date 2023/1/19 - 17:56
 * <p>
 * 递归过程就是你想怎么试，你就能怎么写。但你必须保证，你的子问题和你描述的事是一个事
 * 一个大问题拆分成同样的但是数据量更小的小问题。
 */
public class reverseStack {

    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()){
            return;
        }
        int i = f(stack);
        reverse(stack);
        stack.push(i);
    }

    public static int f(Stack<Integer> stack) {
        int result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        } else {
            int last = f(stack);
            stack.push(result);
            return last;
        }
    }
}
