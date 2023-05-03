package HashTable03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ author Egcoo
 * @ date 2022/8/19 - 19:18
 */
public class fourSum18 {
    public static void main(String[] args) {
        int[] nums = {2, 2, 2, 2, 2};
        fourSum(nums,8);
        System.out.println();
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();

        for (int k = 0; k < nums.length; k++) {
            //一级剪枝：这一步是给 k 做一个剪枝，省略掉不必要的判断
            if (nums[k] > target && nums[k] > 0) break;
            // 一级去重
            if (k > 0 && nums[k] == nums[k - 1]) continue;

            for (int i = k + 1; i < nums.length; i++) {
                //二级剪枝
                if (nums[k] + nums[i] > target && nums[k] + nums[i] > 0) break;
                //二级去重
                if (i > k + 1 && nums[i] == nums[i - 1]) continue;

                int left = i + 1;
                int right = nums.length - 1;
                while (right > left) {
                    if (nums[k] + nums[i] + nums[left] + nums[right] > target) {
                        right--;
                    } else if (nums[k] + nums[i] + nums[left] + nums[right] < target) {
                        left++;
                    } else {
                        //Arrays.asList 可以将一系列数，转换为数组
                        list.add(Arrays.asList(nums[k], nums[i], nums[left], nums[right]));
                        //这里是给 right 和 left 去重
                        while (right > left && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        while (right > left && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        right--;
                        left++;
                    }
                }

            }
        }
        return list;

    }
}
