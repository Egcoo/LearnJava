package TwoDimensionalArray;

/**
 * @ author Egcoo
 * @ date 2022/1/23 - 14:51
 */
public class Homework02 {
    public static void main(String[] args) {
        //随机生成10个数，放到一个数组里，顺序+倒序打印+找出最大最小值的下表+找一下是否有8

        int[] arr = new int[10];
        //(int)(Math.random() *100) + 1; 可以产生随机数。

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * 100) + 1;
        }

        //顺序输出
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        //倒序
        System.out.println();
        for (int i = arr.length -1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }

        //找出最大值+ 求和
        double sum = 0;
        int max = arr[0];
        int maxIndex = -1;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if(max < arr[i]){
                max = arr[i];
                maxIndex = i;
            }
        }

        //输出最大值和平均值
        System.out.println("最大值是：" + max + "下标是：" + maxIndex);
        System.out.println("平均值是：" + sum / arr.length);

        int FindNum = 8;

        for (int i = 0; i < arr.length; i++) {
            if(FindNum == arr[i]){
                System.out.println("找到了，下标是： " + i);
                break;
            }
        }
    }
}
