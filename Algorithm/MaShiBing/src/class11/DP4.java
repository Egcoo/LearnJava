package class11;

/**
 * @ author Egcoo
 * @ date 2023/2/1 - 21:29
 * <p>
 * 本题是给一个数组如[7,3,100,50] 数组中数值可重复使用，组成某一个数字（如1000）有多少种解法
 * <p>
 * 尝试的时候先举出具体例子，具体例子想明白，抽象例子就想明白了,
 * 分析暴力递归，每一步都按照原始题意去分析的，可能性来自于具体的题
 */
public class DP4 {
    public static void main(String[] args) {

    }

    public static int ways(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        return process(arr, 0, aim);
    }

    // 可以自由使用 arr[index....] 所有的面值，每一种面值都可以使用任意张
    // 组成rest， 有多少种方法
    public static int process(int[] arr, int index, int rest) {
//        if (rest < 0) {
//            return 0;
//        }
        //rest >= 0
        // 没有货币可以选择了
        if (index == arr.length) {
            return rest == 0 ? 1 : 0;
        }
        // 当前有货币
        int ways = 0;
        // for循环中 结果不可能让 rest<0
        for (int zhang = 0; zhang * arr[index] <= rest; zhang++) {
            ways += process(arr, index + 1, rest - (zhang * arr[index]));
        }
        return ways;
    }

    //----------------------------------------------------------------
    // 改DP ，没算过就算，算过就直接拿值
    // 自顶向下的动态规划，
    public static int waysDP(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        return process(arr, 0, aim);
    }

    public static int process1(int[] arr, int index, int rest) {
        if (index == arr.length) {
            return rest == 0 ? 1 : 0;
        }
        // 当前有货币
        int ways = 0;
        // for循环中 结果不可能让 rest<0
        for (int zhang = 0; zhang * arr[index] <= rest; zhang++) {
            ways += process(arr, index + 1, rest - (zhang * arr[index]));
        }
        return ways;
    }
}
