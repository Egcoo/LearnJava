package Array01.BinarySearch;

/**
 * @ author Egcoo
 * @ date 2022/8/10 - 16:29
 * <p>
 * 给定一个排序数组和一个目标值，
 * 在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 */
    // 首先 无重复元素 + 有序数组 = 二分法
public class searchInsert35 {
    public int searchInsert(int[] nums, int target) {
        if (target > nums[nums.length - 1]) return nums.length;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            int middle = (left + right) / 2;
            if (nums[middle] > target){
                right = middle - 1;
            } else if (nums[middle] < target){
                left = middle + 1;
            } else {
                return middle;
            }
        }

        // 分别处理如下四种情况
        // 目标值在数组所有元素之前  [0, -1]
        // 目标值等于数组中某一个元素  return middle;
        // 目标值插入数组中的位置 [left, right]，return  right + 1
        // 目标值在数组所有元素之后的情况 [left, right]， 因为是右闭区间，所以 return right + 1
        return right + 1;
    }
}
