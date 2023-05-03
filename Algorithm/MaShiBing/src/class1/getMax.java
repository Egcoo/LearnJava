package class1;

/**
 * @ author Egcoo
 * @ date 2023/1/2 - 14:19
 */
public class getMax {
    public static void main(String[] args) {


    }

    //递归可以理解为一个利用系统栈的过程
    public static int process(int[] arr, int L, int R) {
        if (L == R) { //如果数组中只有一个数，则直接返回
            return arr[L];
        }
        int mid = L + ((R - L) / 2);
        int leftMax = process(arr, L, mid);
        int rightMax = process(arr, mid + 1, R);
        return Math.max(leftMax, rightMax);
    }


}
