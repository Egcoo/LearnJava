package Queue03;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ author Egcoo
 * @ date 2022/7/27 - 18:41
 * 在java 常用的队列中，最常用的队列仍然是linkedList
 */
public class LinkedListTest {
    public static void main(String[] args) {

        Queue<Integer> queue = new LinkedList<>();

        queue.add(1);
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        //区别 ，当队列满的时候，add 会抛出异常，而offer 会返回false 更友好

        //取出元素，分两种
        //只获取队头元素，不取出
        queue.peek();
        queue.element();

        //区别 ，当队列空的时候，element 会抛出异常，而peek 会返回null 更友好
        // 获取队头元素，取出

        queue.poll();
        queue.remove();
        //区别 ，当队列空的时候，remove 会抛出异常，而poll 会返回null 更友好

    }
}
