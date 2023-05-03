package Stack;

/**
 * @ author Egcoo
 * @ date 2022/8/2 - 16:48
 */
public class ArrayStack {

    int[] array;
    //最大容量
    int MaxSize;
    //记录当前的情况
    int top;

    public ArrayStack(int size) {
        array = new int[size];
        MaxSize = size;
        int top = -1;
    }

    //进行压栈操作
    public void push(int value) {
        if (top < MaxSize - 1) {
            top++;
            array[top] = value;
        }
    }

    //出栈操作
    public int pop() {
        if (!isEmpty()) {
            int result = array[top];
            top--;
            return result;
        }
        return -1;
    }

    public int peek() {
        return array[top];
    }

    public boolean isEmpty() {
        return array[top] == -1;
    }

    public boolean isFull() {
        return top == (MaxSize - 1);
    }
}
