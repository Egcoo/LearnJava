package Hashtable05.ArrayNum01;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @ author Egcoo
 * @ date 2022/7/17 - 16:35
 */
public class RepeatNum {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        findRepeatNumber(nums);

    }


    //方法5：
    public static int findRepeatNumber(int[] nums) {

        for (int i = 0; i < nums.length; i++) {

            //如果索引正好等于元素本身，是期望的结果 跳过
            if (nums[i] == i)continue;

            //i = 0
            int num = nums[i];//2
            // 如果要交换位置 已经有期望值 说明重复
            if (nums[num] == num){
                return num;
            }
            int tmp = nums[num];//1
            nums[num] = num;
            nums[i] = tmp;

            //交换后依然需要从头开始遍历，抵消i++,需要i--
            i--;
        }
        return -1;
    }

    //法4：使用临时数组
//    在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内,
//    临时数组（动态数组，默认数组元素全为0）的大小和传入数组一样，
//    遍历时将出现的数字对应到临时数组的索引位置,将其默认的0改为1（比如nums[0] = 2,就将temp[2] = 1）
//    当遍历到某一个元素所对应的索引位置的值不为0时，说明已经出现过该元素了
    public static int findRepeatNumber4(int[] nums) {
        int[] temp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (temp[num] == 1) {
                return num;
            }
            temp[num] = 1;
        }
        return -1;
    }



    //法3，先排序，后查找
    public static int findRepeatNumber3(int[] nums) {
        // 使用Java 中的操作数组的工具类，进行排序
        Arrays.sort(nums);
        // itar 快捷键，判断相邻元素是否相等，返回是否重复
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == nums[i + 1]) {
                return nums[i];
            }
        }
        return -1;
    }




//    2.方法2：根据业务特点（一组对象且不允许重复）使用Java中的set，虽然用不到set的特有的方法，但是看起来更合适
    public static int findRepeatNumber2(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        //遍历数组的for循环
        for (int num : nums) {
            if (set.contains(num)) {
                return num;
            }
            set.add(num);
        }
        //数组中没有重复出现
        return -1;

    }



//    1.第一种解法使用双重循环。
    public static int findRepeatNumber1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (temp == nums[j]) {
                    return temp;
                }
            }
        }
        return -1;
    }


}
