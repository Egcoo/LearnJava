package Hashtable05.ArrayNum01;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @ author Egcoo
 * @ date 2022/7/18 - 17:21
 * 给定一个大小为 n 的数组nums ，返回其中的多数元素。
 * 多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 */
public class majorityElement {
    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(majorityElement1(nums));

    }

    //法3：投票算法
    public static int majorityElement3(int[] nums) {
        int candidate = -1;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {

            //如果count =0 重置候选人
            if (count == 0){
                candidate = nums[i];
            }
            //根据新元素是否等于候选人，进行次数的加减操作
            if (candidate == nums[i]){
                count++;
            }else {
                count--;
            }
            System.out.println("元素" + nums[i] + ", 次数" +
                     ",候选人 "+ candidate);
        }
        return candidate;
    }

    //法2：先排序后取中间元素
    // 先利用 array.sort排成有顺序的
    // 之后利用数组，n/2 和 n/2 +1 的元素一定是一样的
    public static int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }


    //1.使用 HashMap,标配键值对 记录 < 元素，出现次数>
    // 如果次数超过 n/2 即为要查找到元素
    // [3,2,3]
    // <3,1> <2,1> <3,2>   2 > 3/2 = 1;
    public static int majorityElement2(int[] nums) {
        //map 记录元素出现的个数
        HashMap<Integer, Integer> map = new HashMap<>();

        // 统计 多数元素 满足结果
        int halfLen = nums.length / 2;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            //元素次数，初始化为1
            int count = 1;
            if (map.containsKey(num)) {
                count = map.get(num);
                count++;
            }
            if (count > halfLen) {
                return num;
            }
            System.out.println("元素：" + num + "存储次数：" + count);
            map.put(num, count);
        }
        return -1;
    }

}
