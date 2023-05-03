package Hashtable05.ArrayNum01;

/**
 * @ author Egcoo
 * @ date 2022/7/19 - 15:50
 * <p>
 * 将普通数组 转换为 稀松数组
 */
public class SparseArray {
    public static void main(String[] args) {
        int[][] arr = new int[10][10];
        arr[1][2] = 1;
        arr[3][1] = 2;
        arr[2][2] = 2;

        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + "\t");
            }
            System.out.println();
        }

        System.out.println("输出稀松数组");
        int[][] result = toSparse(arr);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i][0] + "\t" + result[i][1] + "\t" + result[i][2]);
        }
    }

    public static int[][] toSparse(int[][] arr) {

        //需要(n+1) *3 列的数组  初始化
        //需要先求 非零元素的个数
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                //这里的arr.length 还是在行列都相同的情况下，如果行列不相同，应该是 arr[0].length
                //这里的 count++ 是统计不为零的元素的个数
                if (arr[i][j] != 0) {
                    count++;
                }
            }
        }

        int[][] result = new int[count + 1][3];
        result[0][0] = arr.length;
        result[0][1] = arr[0].length;
        result[0][2] = count;

        //先遍历，找到所有非零元素
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] != 0) {
                    index++;
                   result[index][0] = i;
                   result[index][1] = j;
                   result[index][2] = arr[i][j];
                }
            }
        }


        return result;
    }
}
