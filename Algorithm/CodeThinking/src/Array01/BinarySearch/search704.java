package Array01.BinarySearch;

/**
 * @ author Egcoo
 * @ date 2022/8/10 - 15:40
 * 704. 二分查找
 * <p>
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，
 * 写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 * 示例 1:
 * <p>
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 */
public class search704 {

    //补充部分

    //搜索的是一个左闭右闭的区间
    public int search(int[] nums, int target) {
        if (target < nums[0] || target > nums[nums.length - 1]) {
            return -1;
        }
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
        return -1;
    }


    public int search1(int[] nums, int target) {

        // 避免当 target 小于nums[0] nums[nums.length - 1]时多次循环运算
        if (target < nums[0] || target > nums[nums.length - 1]) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int middle = (left + right) / 2;

            if (nums[middle] > target) {
                right = middle - 1;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else return middle;
        }

        return -1;
    }
}
