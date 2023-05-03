package Stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ author Egcoo
 * @ date 2022/8/2 - 17:13
 * 225. 用队列实现栈
 * 这个要做到的是用队列实现栈的操作
 * 使用额外的队列 作为临时的空间，在取数据时，存储队列中其他元素，直到找到队尾元素以后，再将临时队列中的元素移回
 */

public class QueueStack {
    //这是一个存储数据的队列
    Queue<Integer> dataQueue = new LinkedList<>();
    // 临时队列
    Queue<Integer> tempQueue = new LinkedList<>();
    //记录栈顶元素
    int top;
    public void push(int x) {
        dataQueue.add(x);
        top = x;
    }

    public int pop() {
        //你要让两个队列做交换
        while (dataQueue.size() > 1) {
            top = dataQueue.poll();
            tempQueue.add(top);
        }

        int num = dataQueue.poll();
        Queue temp = dataQueue;
        dataQueue = tempQueue;
        tempQueue = temp;
        return num;
    }

    public int top() {
        return top;

    }

    public boolean empty() {
        return (dataQueue.size() == 0);
    }
}
