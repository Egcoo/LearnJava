package Array;

/**
 * @ author Egcoo
 * @ date 2022/1/21 - 16:22
 */
public class ArrayReverse {
    public static void main(String[] args) {
        //数组反转
        /*
        int arr [] = {11,22,33,44,55,66}
        调转过来，找规律，两个数相加必然==5
        一次可以调换两个
        for循环整上
         */

        int arr[] = {11, 22, 33, 44, 55, 66};
        int len = arr.length - 1 ;

        for (int i = 0; i < arr.length/2; i++) {
            int temp = arr[i];
            arr[i] = arr[len];
            arr[len] = temp;
            len--;
            //System.out.println( arr[i] + " ");
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
