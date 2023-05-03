package Queue03;

/**
 * @ author Egcoo
 * @ date 2022/7/31 - 18:34
 */
public class MyCircularQueue {
    //首先你得有存储的数组
    int[] queue;
    //设置一个最大容量
    int capacity;
    //头尾指针
    int head;
    //实际长度
    int count;

    public MyCircularQueue(int k) {
        capacity = k;
        queue = new int[k];
        head = 0;
        count = 0;
    }

    public boolean enQueue(int value) {
        if (isFull()) return false;

        int index = (head + count) % capacity;
        queue[index] = value;
        count++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) return false;
        //删除头部元素只需要将头指针向后移动即可
        head = (head + 1) % capacity;
        count--;
        return true;

    }
    public int Front() {
        if (isEmpty()) return -1;
        return queue[head];
    }

    public int Rear() {
        if (isEmpty()) return -1;

        int tail = (head + count - 1) % capacity;
        return queue[tail];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == capacity;
    }
}
