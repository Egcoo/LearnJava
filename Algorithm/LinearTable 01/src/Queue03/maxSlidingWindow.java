package Queue03;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @ author Egcoo
 * @ date 2022/7/30 - 20:20
 */
public class maxSlidingWindow {
    public static void main(String[] args) {
        int[] arr = {1, 3, 1, 2, 0, 5};
        int[] res = maxSlidingWindow(arr,3);
        System.out.println(Arrays.toString(res));

    }
    //本题其实其实相较于形成窗口,反倒更关注最大值以及,把最大值收录的数组
    //[1,3,1,2,0,5]
    //3
    //输出：
    //[3,2,2,5]
    //预期结果：
    //[3,3,2,5]

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        //记录每个窗口的最大值 n-k+1 为形成窗口的个数
        int[] result = new int[nums.length - k + 1];

        //使用队列记录最大值的候选值
        Deque<Integer> deque = new ArrayDeque<>();

        //在窗口未形成的阶段
        for (int i = 0; i < k; i++) {
            // 每次都取 队尾元素和新元素 比较 如果队尾更小 删除
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.pollLast();
            }
            //如果比队尾元素更小,就加入队列中
            deque.offerLast(nums[i]);
        }

        //此时第一个窗口形成,deque的队头元素就是第一个窗口的最大值
        result[0] = deque.peekFirst();

        //窗口已经形成
        for (int i = k; i < nums.length; i++) {
            //System.out.println("------第 " + (i - k + 1) + "次滑动");
            if (nums[i - k] == deque.peekFirst()) {
                //如果删除的是最大值,同时从deque 删除
                deque.pollFirst();
            }
            //新增
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(nums[i]);

            result[i - k + 1] = deque.peekFirst();
        }
        return result;
    }
}
