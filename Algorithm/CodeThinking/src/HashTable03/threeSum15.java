package HashTable03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ author Egcoo
 * @ date 2022/8/19 - 16:04
 */
public class threeSum15 {

    //2.双指针
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            //这里应该 直接 return list 而不是null，这里是要判断是不是要继续
            if (nums[i] > 0) return list;
            //给 i 做去重操作
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = nums.length - 1;
            while (right > left) {
                if (nums[i] + nums[left] + nums[right] > 0) {
                    right--;
                } else if (nums[i] + nums[left] + nums[right] < 0) {
                    left++;
                } else {
                    //Arrays.asList 可以将一系列数，转换为数组
                    list.add(Arrays.asList(nums[i], nums[left], nums[right]));
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
        return list;
    }

    //1.尝试暴力解法，三层for循环, 但是结果没有去重
    public List<List<Integer>> threeSum1(int[] nums) {
        if (nums == null || nums.length < 3) return null;

        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        if (!list.contains(temp)) {
                            list.add(temp);
                        }
                        temp = null;
                    }
                }
            }
        }
        return list;
    }
}
