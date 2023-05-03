package Tree;

import java.util.Scanner;

/**
 * @ author Egcoo
 * @ date 2022/9/18 - 8:51
 */
// 由简单到复杂，先局部后整体，先粗糙后精细

public class apple19091 {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        int n = myScanner.nextInt();
        int m = myScanner.nextInt();

        //就是使用两个一维数组 + 几个小模块
        int[] tree = new int[n];
        int[] drop = new int[n];
        int temp;
        int sum = 0;
        int AppleSum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m + 1; j++) {
                if (j == 0) {
                    tree[i] = myScanner.nextInt();
                } else {
                    temp = myScanner.nextInt();
                    tree[i] += temp;
                    sum += Math.abs(temp);
                }
            }
            drop[i] = sum;
            sum = 0;
        }

        for (int i = 0; i < n; i++) {
            AppleSum += tree[i];
        }

        int k = 0;
        int max = drop[0];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (drop[j] > max) {
                    max = drop[j];
                    k = j;
                }
            }
        }

        System.out.println(AppleSum + " " + (k + 1) + " " +drop[k]);
    }
}
