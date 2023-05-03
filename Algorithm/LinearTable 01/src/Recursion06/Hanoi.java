package Recursion06;

/**
 * @ author Egcoo
 * @ date 2022/8/6 - 15:47
 * Make it work,Make it right,Make it fast.
 */
public class Hanoi {
    public static void main(String[] args) {
        //三个圆盘先做尝试
        hanoi(64,'A','B','C');

    }

    //推导出递推公式，找到递推的出口
    public static void hanoi(int n, char A, char B, char C) {
        //出口
        if (n == 1) {
            System.out.println(A + " -> " + C);
            return;
        }
        //  先把前 n-1 个圆盘  从 A 移动到 B （经由C）
        //  再把最大的圆盘 从A 移动到 C
        //  最后把前 n-1 个圆盘，从 B 移动到 C （经由A）
        hanoi(n - 1, A, C, B);
        System.out.println(A + " -> " + C);
        hanoi(n - 1, B, A, C);
    }
}
