package Recursion;

/**
 * @ author Egcoo
 * @ date 2022/8/22 - 19:03
 */
public class isPowerOfTwo231 {

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(17));
    }

    public static boolean isPowerOfTwo(int n) {

        if (n == 1) return true;
        if (n == 0 || n % 2 != 0) return false;
        return isPowerOfTwo(n/2);
    }
}
