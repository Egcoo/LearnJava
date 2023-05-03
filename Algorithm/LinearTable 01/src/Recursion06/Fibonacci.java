package Recursion06;

/**
 * @ author Egcoo
 * @ date 2022/8/6 - 11:30
 * 返回第 n 个月有多少只兔子
 */
public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fib(8));
    }

    public static int fib(int N) {
        if (N == 1) {
            return 1;
        }
        if (N == 2) {
            return 1;
        }
        return fib(N - 1) + fib(N - 2);
    }


    //解法2：使用迭代来处理 ，用数组来记录效率会高一些，逆向存储 （n-1）和 （n-1）的值
    // 但是我们使用迭代往往是找到递归的规律以后
    public static int fib1(int N) {

        if (N <= 2) {
            return 1;
        }
        int[] arr = new int[N];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i < arr.length; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[N - 1];
    }

}
