package Array;

/**
 * @ author Egcoo
 * @ date 2022/1/21 - 21:28
 */
public class BubbleSort {
    public static void main(String[] args) {

        //分析冒泡排序
        //给你一个数组{12,66,32,14,22}，让数组从小到大排序 {12,32,14,22,66}{12,14,22,32,66}
        //思路分析：化繁为简
        /*
        先得有一个数组，
        可以遍历比较，然后交换值，交换一次肯定不够、
        还得再来一个循环，交换第二次，不过这次交换肯定就是从数组的第二个值开始比较，因为第一次比较肯定选出来了最大的
         老韩思路
         1.一共有5个元素
         2.一共进行了4轮排序，可以看成是外层循环
         3.每一轮排序可以确定一个数的位置，比如第一轮可以确定最大数
         4.当进行比较时，如果前面的大于后面的数，交换
         5.每轮比较次数在减少
         */
       // int[] arr = {24, 69, 80, 57, 13};

        /*
        for (int count = 0; count < arr.length-1; count++) {//外层循环是四次

            for (int i = 0; i < arr.length; i++) {
                if (i == arr.length - 1 - count) {  //减count 还是为了提高效率
                    break;
                } else if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }

        for (int j = 0; j < arr.length; j++) {
            System.out.print(arr[j] + " ");
        }

         */

        //优化后

        int[] arr = {24, 69, 80, 57, 13};
        int n = arr.length - 1;
        for (int count = 0; count < n; count++) {  //外层循环（轮）

            for (int i = 0; i < n - count ; i++) { //内层循环是在这一轮要对比的次数
                if (arr[i] > arr[i + 1]) { // 每层循环的次数，如果是从大到小arr[i] < arr[i + 1]
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }

        for (int j = 0; j < arr.length; j++) {
            System.out.print(arr[j] + " ");
        }


    }
}
