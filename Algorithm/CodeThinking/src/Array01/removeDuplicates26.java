package Array01;

/**
 * @ author Egcoo
 * @ date 2022/10/26 - 20:23
 */
public class removeDuplicates26 {


    //本题的解法依然是快慢指针
    // 快指针获取数组的新元素，慢指针更新数组元素
    // 这里和 26 题的区别在于这里数组的第一个元素是不动的。
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[index]){
                index++;
                nums[index] = nums[i];
            }
        }

        return index + 1;
    }
}
