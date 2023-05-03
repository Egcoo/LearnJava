package Main_;

/**
 * @ author Egcoo
 * @ date 2022/4/19 - 21:12
 */
public class main01 {

    public static int n1 = 1000;

    public static void hi() {
        System.out.println("这是一个静态方法。");
    }

    public static void main(String[] args) {

        for (int i = 0; i < args.length; i++) {
            System.out.println("第 " + (i + 1) + "个元素是：" + args[i]);
        }
        n1 = n1 + 1000;
        hi();

    }

}
