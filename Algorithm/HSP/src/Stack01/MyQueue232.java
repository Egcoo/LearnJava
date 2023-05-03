package Stack01;

import java.util.Stack;

/**
 * @ author Egcoo
 * @ date 2022/8/4 - 23:10
 * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
 * <p>
 * 实现 MyQueue 类：
 * <p>
 * void push(int x) 将元素 x 推到队列的末尾
 * int pop() 从队列的开头移除并返回元素
 * int peek() 返回队列开头的元素
 * boolean empty() 如果队列为空，返回 true ；否则，返回 false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/implement-queue-using-stacks
 *
 */
//1.思路，一个是存储数据的栈，一个是记录临时数据的栈
// 记录临时数据的 做循环交换
public class MyQueue232 {

    //这是一个存储数据的栈
    Stack<Integer> dataStack = new Stack<>();
    // 临时栈
    Stack<Integer> tempStack = new Stack<>();
    public void MyQueue() {

    }

    public void push(int x) {
        dataStack.push(x);

    }

    public int pop() {
        //如果 tempStack 栈为空，则将dataStack 压入 tempStack，然后弹出
        if (tempStack.isEmpty()){
            while (!dataStack.isEmpty()){
                tempStack.push(dataStack.pop());
            }
        }
        return tempStack.pop();

    }

    public int peek() {
        if (tempStack.isEmpty()){
            while (!dataStack.isEmpty()){
                tempStack.push(dataStack.pop());
            }
        }
        return tempStack.peek();

    }

    public boolean empty() {
        return (dataStack.isEmpty() && tempStack.isEmpty());
    }
}
