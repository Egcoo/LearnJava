package Stack.nextGreaterElement;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @ author Egcoo
 * @ date 2022/8/3 - 18:26
 * 496. 下一个更大元素 I
 * 如果新元素更小，直接入栈，等待后面出现的更大元素
 * 如果找到更大元素，存入 map ，
 */
public class nextGreaterElement {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        //暂时忽略 nums1 ，直接求取 nums2 中 每个元素的下一个更大值
        Stack<Integer> stack = new Stack<>();
        Map<Integer,Integer> map = new HashMap<>();

        int[] result = new int[nums1.length];

        for (int i = 0; i < nums2.length; i++) {
            //循环比较元素
            while (!stack.isEmpty() && nums2[i] > stack.peek()){
                map.put(stack.pop(),nums2[i]);
            }
            stack.push(nums2[i]);
        }

        while (!stack.isEmpty()){
            map.put(stack.pop(),-1);
        }

        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.get(nums1[i]);
        }

        return result;
    }
}
