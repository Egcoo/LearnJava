package Arrays06;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ author Egcoo
 * @ date 2022/7/1 - 11:25
 */
public class ArraySortCustom02 {
    public static void main(String[] args) {
        int[] arr = {1, -1, 8, 0, 20};
        //bubble01(arr);


        bubble02(arr, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                int n1 = (Integer) o1;
                int n2 = (Integer) o2;
                return n1 - n2;
            }
        });

        System.out.println("==定制排序的最后情况==");
        System.out.println(Arrays.toString(arr));

    }

    public static void bubble01(int[] arr) {
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                //从小到大
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    //说白了就是调用了一个系统做的接口，传入匿名内部类的时候，我制定了一个我的规则
    public static void bubble02(int[] arr, Comparator c) {
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                //数组排序由 c.compare(arr[j],arr[j+1]) 返回的值决定

                if (c.compare(arr[j], arr[j + 1]) > 0) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
