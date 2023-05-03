package Array;

/**
 * @ author Egcoo
 * @ date 2022/1/21 - 11:46
 */

public class ArrayChar {
    public static void main(String[] args) {
        //用char数组得到26个字母，并且for循环输出
        //化繁为简
        /*
        1.你得先有一个char数组
        2.使用for 循环得到26个字母、
        3.不换行输出的
         */

        char table[] = new char[26];
        for (int i = 0; i < table.length; i++) {
            table[i] = (char) ('A' + i);//需要强制转换。
            System.out.print(table[i] + " ");
        }


        //数组找出最大值
        int arr[] = {11, 12, 23, 44, 55};
        int max = arr[0];
        int maxIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if( max < arr[i]){
                max = arr[i];
                maxIndex = i;
            }
        }
        System.out.println( max + " " + maxIndex);

    }
}
