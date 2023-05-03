package TwoDimensionalArray;

import javax.swing.plaf.FontUIResource;

/**
 * @ author Egcoo
 * @ date 2022/1/22 - 17:28
 */
public class TDA02 {
    public static void main(String[] args) {
        //一个二维数组，包含三个一维数组，每个一维数组的元素不一样
        //定义的时候没有直接给一维数组开数据空间
        /*
        i1 = 1
        i2 = 2 2;
        i3 = 3 3 3;
        1.现有一个二维数组
        2.一维数组的元素肯定不是开始就定义好的
        3.遍历的时候才会开空间+赋值，先开空间，后赋值
         */
        int[][] arr = new int[10][];

        for (int i = 0; i < arr.length; i++) {

            //现在给一维数组开空间,开空间必须有new，没有new 就是null
            arr[i] = new int[i + 1];

            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = i + 1;
            }
        }

        System.out.println("===========现在元素是");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }
}
