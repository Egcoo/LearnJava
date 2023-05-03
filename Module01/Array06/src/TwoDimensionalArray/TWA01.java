package TwoDimensionalArray;

/**
 * @ author Egcoo
 * @ date 2022/1/22 - 15:27
 */
public class TWA01 {
    public static void main(String[] args) {
        int [][] arr = {{0,0,0,0,0},
                        {0,0,1,0,0,0},
                        {0,2,0,3,0,0},
                {0,0,0,0,0,0,}};

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "");
            }
            System.out.println();//换行
        }
    }
}
