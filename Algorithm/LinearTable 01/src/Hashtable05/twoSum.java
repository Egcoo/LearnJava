package Hashtable05;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ author Egcoo
 * @ date 2022/8/5 - 16:36
 */
public class twoSum {
    public static void main(String[] args) {
        int[] num = {2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum(num, 26)));
    }

    //1.暴力破解法
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }

            }
        }
        return new int[]{-1, -1};
    }

    //2.倒推法
    // 使用额外的容器存储，快速找到是否存在某个值
    //<元素值，索引位置> hashmap
    // [2,7,11,15]
    // 26
    // 2  26 - 2 = 24
    // 7  26 - 7 = 19
    // 11 26 - 11 = 15

    public static int[] twoSum1(int[] nums, int target) {
        //使用map存储
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int needNum = target - nums[i];
            //防止一个元素重复使用
            if (map.containsKey(needNum) && map.get(needNum) == i) {
                return new int[]{i, map.get(needNum)};
            }
        }

        return new int[]{-1, -1};
    }

    //3.一次哈希法
    //边遍历边修改添加 map 值，能达到最好效率
    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        //这里就不会产生数组使用两次的情况
        for (int i = 0; i < nums.length; i++) {
            int needNum = target - nums[i];
            if (map.containsKey(needNum)) {
                //needNum 一定是先出现
                return new int[]{map.get(needNum), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}
