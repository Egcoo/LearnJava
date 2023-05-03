package Array01;

/**
 * @ author Egcoo
 * @ date 2022/10/13 - 22:25
 */
public class removeElement27 {
    public static void main(String[] args) {
        int[] arr = {3, 2, 2, 3};
        int n = removeElement(arr, 2);
        System.out.println(n);

    }

    //快慢指针对同一个数组进行操作
    // 快指针用来获取新数组的元素，慢指针是构造新数组中需要更新的位置
    public static int removeElement(int[] nums, int val) {
        if (nums.length == 0) return 0;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }
}
