package Queue03;

import java.util.LinkedList;

/**
 * @ author Egcoo
 * @ date 2022/7/30 - 18:08
 */
public class MaxQueue {

    //原始队列
    LinkedList<Integer> queue;
    //最大值的候选值
    LinkedList<Integer> max;

    public MaxQueue() {
        queue = new LinkedList<>();
        max = new LinkedList<>();
    }

    public int max_value() {
        if (max.isEmpty()) return -1;
        return max.peekFirst();
    }

    //
    // 新增元素 ele时, ele > max 取队列中队尾元素比较,如果满足,进行覆盖并循环比较
    //                      直到把所有比它小的值都覆盖为止
    // ele < max 将其存到max 队列中

    public void push_back(int value) { //push_back 意思是向队尾添加元素
        queue.offer(value);

        while (!max.isEmpty() && max.peekLast() < value){
            max.pollLast();//将最后一个移除
        }
        max.add(value);
    }

    public int pop_front() {
        //如果删除元素是最大值,就将其从 max 队列中同时删除
        if (!max.isEmpty() && queue.peekFirst().equals(max.peekFirst())){
            max.pollFirst();
        }
        if (queue.isEmpty()) return -1;
        return queue.poll();
    }
}
