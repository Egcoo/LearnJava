package Stack;

import java.util.Stack;

/**
 * @ author Egcoo
 * @ date 2022/8/3 - 16:30
 * 面试题 03.02. 栈的最小值
 * 请设计一个栈，除了常规栈支持的pop与push函数以外，还支持min函数，
 * 该函数返回栈元素中的最小值。执行push、pop和min操作的时间复杂度必须为O(1)。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/min-stack-lcci
 * <p>
 * 分析：使用额外的栈，来记录栈的最小值
 */
public class MinStack {

    //数据栈
    Stack<Integer> dataStack = new Stack<>();
    //最小值记录栈
    Stack<Integer> minStack = new Stack<>();

    public MinStack() {

    }

    public void push(int x) {
        //数据栈添加数据
        dataStack.push(x);
        if (!minStack.isEmpty() && minStack.peek() < x ){
            minStack.push(minStack.peek());
        }else {
            minStack.push(x);
        }

    }

    public void pop() {
        dataStack.pop();
        minStack.pop();

    }

    public int top() {
        return dataStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
