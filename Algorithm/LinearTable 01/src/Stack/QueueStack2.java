package Stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ author Egcoo
 * @ date 2022/8/2 - 19:19
 * 225. 用队列实现栈
 * 请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。
 * 不使用额外队列，只在每次存数据时，颠倒其位置，保存的顺序满足栈的处理顺序
 */
public class QueueStack2 {

    Queue<Integer> queue = new LinkedList<>();

    public void push(int x) {
        queue.add(x);
        //把队头元素拿出来 放到队尾，颠倒 size -1 回
        int size = queue.size();
        while (size > 1){
            int tail = queue.poll();
            queue.offer(tail);
            size--;
        }

    }

    public int pop() {
        return queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
