package Hashtable05.ArrayNum01;

import java.util.Arrays;

/**
 * @ author Egcoo
 * @ date 2022/7/19 - 18:18
 * 当我们删除重复元素时，我们需要有一个前面的元素进行比较，看后面的元素是否相同
 * 所以我们覆盖的是下一个位置
 * 但是当我们移除元素时，我们是直接覆盖掉当前位置
 */
public class removeElement {
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        System.out.println(removeElement1(nums, 2));
        System.out.println(Arrays.toString(nums));
    }

    //只删除有效的元素
    //
    //
    //
    public static int removeElement1(int[] nums, int val) {
        int index = 0;
        //记录有效的元素个数
        int len = nums.length;
        while (true) {
            if (index >= len) return len;

            if (nums[index] == val) {
                nums[index] = nums[len - 1];
                System.out.println("替换了" + index + "和" + (len - 1) + "的元素");
                len--;
            } else {
                index++;
            }
        }
    }

    //解法1：双指针本质上是覆盖，寻找要留下的元素，并移动要留下的元素到数组的前半部分
    //弊端就是 相对而言效率较低比如 [4,1,2,3,5] val = 4
    // result = [1,2,3,5,5] 后面的元素都需要覆盖

    public static int removeElement(int[] nums, int val) {
        // 记录要覆盖的索引位置
        if (nums.length == 0) return 0;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                System.out.println(nums[i] + "覆盖 " + nums[index]);
                //覆盖的是当前位置
                nums[index] = nums[i];
                index++;
            }

        }
        //新数组长度大小
        return index;
    }

}

