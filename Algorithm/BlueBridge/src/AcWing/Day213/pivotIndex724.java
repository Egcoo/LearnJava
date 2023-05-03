package AcWing.Day213;

/**
 * @ author Egcoo
 * @ date 2023/2/19 - 11:40
 * 1.因为这里要返回某个元素具体的位置，所以要按照元素原有的顺序来排列
 * 2.
 */
public class pivotIndex724 {

    int N = 10010;
    int[] s = new int[N];

    public int pivotIndex(int[] nums) {
        int n = nums.length;
        s[0] = nums[0];
        for (int i = 1; i < n; i++) {
            s[i] = s[i - 1] + nums[i];
        }

        //判断开头的0位置是不是
        if (s[n - 1] - s[0] == 0) {
            return 0;
        }
        for (int i = 1; i < n; i++) {
            if (s[i - 1] == (s[n - 1] - s[i])) {
                return i;
            }
        }
        //判断末尾是不是
        if (s[n - 2] == 0) {
            return (n - 1);
        }
        return -1;
    }
}
