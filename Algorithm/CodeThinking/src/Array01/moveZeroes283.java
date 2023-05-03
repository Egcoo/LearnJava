package Array01;

/**
 * @ author Egcoo
 * @ date 2022/10/26 - 20:58
 */
public class moveZeroes283 {

    public void moveZeroes(int[] nums) {
        int val = 0;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val){
                nums[index] = nums[i];
                index++;
            }
        }

        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
