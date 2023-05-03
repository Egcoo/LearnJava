package HashTable03;

import java.util.HashMap;
import java.util.Map;

/**
 * @ author Egcoo
 * @ date 2022/8/18 - 17:37
 */
public class twoSum1 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int needNum = target - nums[i];
            if (map.containsKey(needNum)) {
                return new int[]{map.get(needNum), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1,-1};
    }
}
