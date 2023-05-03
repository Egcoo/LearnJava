package Array01.BinarySearch;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ author Egcoo
 * @ date 2022/8/10 - 17:15
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * <p>
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。
 * 请你找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 */

//寻找target在数组里的左右边界，有如下三种情况：
//
//情况一：target 在数组范围的右边或者左边，例如数组{3, 4, 5}，
// target为2或者数组{3, 4, 5},target为6，此时应该返回{-1, -1}
//情况二：target 在数组范围中，且数组中不存在target，例如数组{3,6,7},target为5，此时应该返回{-1, -1}
//情况三：target 在数组范围中，且数组中存在target，例如数组{3,6,7},target为6，此时应该返回{1, 1}
//
//这三种情况都考虑到，说明就想的很清楚了。
public class searchRange34 {
    public int[] searchRange(int[] nums, int target) {
        int leftBorder = getLeftBorder(nums, target);
        int rightBorder = getRightBorder(nums, target);
        //情况一
        if (leftBorder == -2 || rightBorder == -2) return new int[]{-1, -1};
        //情况二
        if (rightBorder - leftBorder > 1) return new int[]{leftBorder + 1, rightBorder - 1};
        //情况三
        return new int[]{-1, -1};

    }

    public static int getRightBorder(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int rightBorder = -2; //记录 target没有被赋值的情况
        while (left <= right) {
            int middle = (right + left) / 2;
            if (nums[middle] > target){
                right = middle - 1;
            } else {
                left = middle + 1;
                rightBorder = left;
            }
        }

        return rightBorder;
    }

    public static int getLeftBorder(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int leftBorder = -2; //记录一下 target 没有被赋值的情况
        while (left <= right) {
            int middle = (left + right) / 2;
            if (nums[middle] >= target) {
                right = middle - 1;
                leftBorder = right;
            } else {
                left = middle + 1;
            }
        }
        return leftBorder;
    }
}
