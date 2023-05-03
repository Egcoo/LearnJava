package TutorialClass.class15;

/**
 * @ author Egcoo
 * @ date 2023/3/29 - 14:48
 * <p>
 * 线性筛法：使用线性的时间复杂度找出质数
 */
public class getPrimes {

    static int N = 1000010;
    static int[] primes = new int[N]; // 存所有的质数
    static int cnt = 0; // 记录质数的个数
    static boolean[] st = new boolean[N]; // 记录质数是否被筛过，0没被筛过，1被筛过

    public static void main(String[] args) {
        get_Primes(100000);

        for (int i = 0; i < 20; i++) {
            System.out.println(primes[i]);
        }
    }

    public static void get_Primes(int n) {
        for (int i = 2; i <= n; i++) {
            if (!st[i]) {
                primes[cnt++] = i;
            }
            for (int j = 0; primes[j] * i <= n; j++) {
                st[primes[j] * i] = true; // 把质数的i倍筛掉
                if (i % primes[j] == 0) {
                    break; // 通过最小质因子来筛
                }
            }
        }

    }


    /*
      因为prime中素数是递增的，所以如果i%prime[j]!=0代表i的最小质因数还没有找到，
      即i的最小质因数大于prime[j]
      也就是说prime[j]就是i*prime[j]的最小质因数，于是i*prime[j]被它的最小质因数筛掉了
     */
    /*
      如果当i%prime[j]==0时，代表i的最小质因数是prime[j]，
      那么i*prime[j+k](k>0)这个合数的最小质因数就不是prime[j+k]而是prime[j]了
      所以i*prime[j+k]应该被prime[j]筛掉，而不是后续的prime[j+k]，于是在此时break
     */
}
