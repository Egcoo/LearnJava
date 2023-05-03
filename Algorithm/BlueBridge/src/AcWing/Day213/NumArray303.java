package AcWing.Day213;

/**
 * @ author Egcoo
 * @ date 2023/2/19 - 10:42
 */
public class NumArray303 {
    int N = 10010;
    int[] s = new int[N];

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray303 obj = new NumArray303(nums);
        obj.sumRange(0, 2);
        obj.sumRange(2, 5);
        obj.sumRange(0, 5);
    }

    public NumArray303(int[] nums) {
        s[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            s[i] = s[i - 1] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        if (left == 0) {
            return s[right];
        } else {
            return s[right] - s[left - 1];
        }
    }
}
