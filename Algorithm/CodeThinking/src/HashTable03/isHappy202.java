package HashTable03;

import java.util.HashSet;
import java.util.Set;

/**
 * @ author Egcoo
 * @ date 2022/8/18 - 15:25
 */
public class isHappy202 {

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (true){
            int sum = getSum(n);
            if (sum == 1){
                return true;
            }
            //如果 sum 出现过，说明已经进入了无限循环，直接return false
            if (set.contains(sum)){
                return false;
            } else {
                set.add(sum);
            }
            n = sum;
        }
    }
    public static int getSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += (n % 10) * (n % 10);
            n /= 10;
        }
        return sum;
    }


    //1.暴力解法
    // 我能想到的就是循环赋值,如果是快乐数，那么在一定次数内就会快乐，
    // 在一定次数内不快乐，那就是不快乐数
    public boolean isHappy1(int n) {
        int ans = 0;
        for (int i = 0; i < 100; i++) {
            while (n > 0) {
                ans += (n % 10) * (n % 10);
                n = n / 10;
            }
            n = ans;
            ans = 0;
            if (n == 1) {
                return true;
            }
        }
        return false;
    }
}
