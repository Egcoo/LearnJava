package Stack;

import java.util.Stack;

/**
 * @ author Egcoo
 * @ date 2022/8/3 - 17:01
 * 面试题 03.02. 栈的最小值
 * * 请设计一个栈，除了常规栈支持的pop与push函数以外，还支持min函数，
 * * 该函数返回栈元素中的最小值。执行push、pop和min操作的时间复杂度必须为O(1)。
 * * <p>
 * * 来源：力扣（LeetCode）
 * * 链接：https://leetcode.cn/problems/min-stack-lcci
 * * <p>
 * * 分析：不使用额外的栈，使用变量来标记栈的最小元素
 */
public class MinStack2 {

    Stack<Integer> dataStack = new Stack<>();
    //默认初始值给 min 一个最大值
    int min = Integer.MAX_VALUE;

    public MinStack2() {

    }

    public void push(int x) {
        //如果新元素使最小值发生变化，则会储存两个值（原来最小值，当前的最小值）
        if (min >= x) {
            if (!dataStack.isEmpty()){
                //如果不是空即代表 min 已经不是默认值
                dataStack.push(min);
            }
            min = x;
        }
        //如果栈为空就直接进
        dataStack.push(x);

    }

    //如果不是最小值，直接pop
    //如果是最小值，移除最小之后，需要再移除之前保存的最小值
    public void pop() {
        if (!dataStack.isEmpty()){
            //最小值重新恢复默认值
            if ( dataStack.size() == 1){
                min = Integer.MAX_VALUE;
            } else if (min == dataStack.peek()){
                dataStack.pop();
                min = dataStack.peek();
            }

            dataStack.pop();
        }

    }

    public int top() {
        return dataStack.peek();
    }

    public int getMin() {
        return min;
    }
}
