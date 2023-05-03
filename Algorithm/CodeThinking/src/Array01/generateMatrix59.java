package Array01;

/**
 * @ author Egcoo
 * @ date 2022/11/2 - 21:54
 */

// 坚持一个循环不变量原则，就是坚持一个规则来处理每一条边
// 这里我们是每一条边不处理最后一个点
public class generateMatrix59 {
    public static void main(String[] args) {


    }
    public int[][] generateMatrix(int n) {

        int[][] nums = new int[n][n];
        int startX = 0, startY = 0; // 起始位置
        int offset = 1; //终止位置随着每一次的循环而改变
        int count = 1;
        int loop = n / 2;

        while (loop > 0) {
            int i = startX;
            int j = startY;


            for (j = startY; j < n - offset; j++) {
                nums[startX][j] = count;
                count++;
            }
            for (i = startX; i < n - offset; i++) {
                nums[i][j] = count;
                count++;
            }
            //j 此时已经等于j = n - offset
            for (; j > startY; j--) {
                nums[i][j] = count;
                count++;
            }
            for (; i > startX; i--) {
                nums[i][j] = count;
                count++;
            }
            startX++;
            startY++;
            offset++;
            loop--;
        }
        if (n % 2 == 1) {
            nums[startX][startY] = count;
        }


        return nums;
    }
}
