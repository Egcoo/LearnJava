package Queue03;

/**
 * @ author Egcoo
 * @ date 2022/7/27 - 18:13
 */
public class ArrayQueue {

    //最大容量
    int maxCapacity;

    //声明头尾指针
    int head;
    int tail;
    //存储元素
    int[] arr;

    public ArrayQueue(int maxCapacity) {
        arr = new int[maxCapacity];
        maxCapacity = maxCapacity;

        head = 0;
        tail = 0;
    }

    //先判断队列的容量大小
    public boolean isFull() {
        return tail == maxCapacity;
    }

    public void add(int n) {
        if (!isFull()) {
            arr[tail] = n;
            tail++;
        }
    }

    public boolean isEmpty() {
        return head == tail;
    }

    public int get() {
        //先判断队列是否为空
        if (isEmpty()) {
            return -1;
        } else {
            int result = arr[head];
            head++;
            return result;
        }
    }

}
