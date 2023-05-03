package Array01.slidingWindow;

/**
 * @ author Egcoo
 * @ date 2022/8/12 - 16:20
 */
public class minSubArrayLen209 {

    public static void main(String[] args) {
        int[] num = {2, 3, 1, 2, 4, 3};
        minSubArrayLen(7, num);

    }

    //首先要思考 如果用一个for循环，那么应该表示 滑动窗口的起始位置，还是终止位置
    //如果只用一个for循环来表示 滑动窗口的起始位置，那么如何遍历剩下的终止位置
    // 自此又陷入了暴力解法，所以只使用一个 for 循环 表示的一定是终止位置
    // 普通的暴力解法，for循环里的代码费大劲在移动最后那个位置；而滑动窗口里的代码主要在研究 移动起始的位置

    public static int minSubArrayLen0(int target, int[] nums) {
        int result = Integer.MAX_VALUE;
        int sum = 0;
        int subLength = 0;
        for (int i = 0, j = 0; j < nums.length; j++) {
            sum += nums[j];
            while (sum <= target) {
                subLength = j - i + 1;
                result = Math.min(result,subLength);
                sum -= nums[i];
                i++;
            }
        }
        return result == Integer.MAX_VALUE ? 0 : subLength;

    }

    public static int minSubArrayLen(int target, int[] nums) {
        int result = Integer.MAX_VALUE;
        int sum = 0;
        int subLength = 0;
        //终止位置在往前走
        for (int i = 0, j = 0; j < nums.length; j++) {
            sum += nums[j];
            while (sum >= target) {
                subLength = j - i + 1;
                result = Math.min(result, subLength);
                //起始位置往前移动
                sum -= nums[i];
                i++;
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    //1.暴力解法时间超时
    // 两个 for 循环遍历得出最大值
    //
    public int minSubArrayLen1(int target, int[] nums) {
        int result = Integer.MAX_VALUE;
        int sum = 0;
        int subLength = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = 0; //每次调整的时候，重新置零
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= target) {
                    subLength = j - i + 1;
                    //result = result < subLength ? result : subLength;
                    result = Math.min(result, subLength); //我们找的是符合条件的最小子序列，找到就break
                    break;
                }
            }
        }
        // 如果result没有被赋值的话，就返回0，说明没有符合条件的子序列
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
