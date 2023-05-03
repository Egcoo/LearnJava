package Static_01;

/**
 * @ author Egcoo
 * @ date 2022/4/17 - 10:53
 */
public class StaticMethodDetail {
    public static void main(String[] args) {

        D.hi();
    }
}

class D {

    private int n1 = 100;
    private static int n2 = 100;
    public void say() { //普通方法需要先创建对象再调用,普通成员既可以访问静态也可以访问非静态
        System.out.println(n1 + " " + n2);
    }

    public static void hi() { //静态方法
//        this.n1;
        System.out.println(n2);
        System.out.println(D.n2);
    }
}