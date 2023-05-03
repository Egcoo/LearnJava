package Array01.DoublePointer;

/**
 * @ author Egcoo
 * @ date 2022/8/11 - 17:24
 */
public class sortedSquares977 {

    public static void main(String[] args) {
        int[] num = {-4, -1, 0, 3, 10};
        sortedSquares(num);

        System.out.println();

    }

    //方法二 双指针由外向内移动
    // 是需要开辟一个新数组的，不然你原本的数据在比较的过程中就会被覆盖
    public static int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int k = nums.length - 1;
        for (int i = 0, j = nums.length - 1; i <= j; ) {
            if (nums[i] * nums[i] > nums[j] * nums[j]) {
                result[k] = nums[i] * nums[i];
                k--;
                i++;
            } else {
                result[k] = nums[j] * nums[j];
                k--;
                j--;
            }
        }
        return nums;
    }

    //1.暴力解法
    public int[] sortedSquares1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        return nums;

    }
}
