package Hashtable05.ArrayNum01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @ author Egcoo
 * @ date 2022/7/18 - 15:24
 * <p>
 * 给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。
 * 请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。
 */
//对应第四节课的内容

public class findDisappearedNumbers {
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        findDisappearedNumbers1(nums);


    }

    //法3：2）不使用额外的空间？
    //
    //[1,2,4,5,1] 1-5 [3]
    //[1,2,4,5,1]
    // 0 1 2 3 4
    // 1 2 3 4 5能不能利用索引来记录已出现的数字？
    //元素   对应的索引  第0位的值进行变化  说明
    // 1      0        [-1,2,4,5,1]  1变为-1
    // 2      1        [-1,-2,4,5,1] 2变为-2
    // 4      3        [-1,-2,4,-5,1] 5变为-5
    // 5      4        [-1,-2,4,-5,-1] 倒数的1变为-1
    // 1      0        [-1,-2,4,-5,-1]
    //剩余还是正数的元素 索引对应的值从未出现过

    public static List<Integer> findDisappearedNumbers3(int[] nums) {
        ArrayList<Integer> result = new ArrayList<>();

        //通过元素的索引，将指定元素置为负数
        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]);
            int index = num - 1;

            // 将对应索引值位置的值设置为负数，前提是这个数是整数
            if (nums[index] > 0) {
                nums[index] = -nums[index];
                System.out.println("索引：" + index + " " + Arrays.toString(nums));
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }
        return result;
    }


    //法2：使用容器存储已经出现的数字 {4, 3, 2, 7, 8, 2, 3, 1};
    // 额外容器 {4, 3, 2, 7, 8, 1} 缺少5，6
    // 经常用到的容器 set list map
    //不重复无序 用set
    //可能重复且有序 使用list
    //映射关系（键值对）{例如：<元素，出现的次数>} 使用map
    public static List<Integer> findDisappearedNumbers2(int[] nums) {
        ArrayList<Integer> result = new ArrayList<>();
        //set 来存储已经出现的数字，无序且不重复
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        //从 1-n 开始遍历
        for (int i = 1; i <= nums.length; i++) {
            if (!set.contains(i)) {
                result.add(i);
            }
        }
        return result;
    }


    //1.临时数组做交换
    // 方法1在一个长度为 n 的数组 nums 里的所有数字都在 1～n 的范围内
    // 临时数组（动态数组，默认和传入的数组大小一样），
    // 遍历时将出现的数字，对应到临时数组 索引+1 的位置上去
    // 再遍历临时数组，将其中等于0的索引，添加到 arraylist
    public static List<Integer> findDisappearedNumbers1(int[] nums) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        int[] temp = new int[nums.length + 1];
        temp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            temp[num] = 1;
        }

        for (int i = 0; i < temp.length; i++) {
            if (temp[i] == 0) {
                arrayList.add(i);
            }

        }
        return arrayList;
    }


}
