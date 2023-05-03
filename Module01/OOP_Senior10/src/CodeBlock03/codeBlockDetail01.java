package CodeBlock03;

/**
 * @ author Egcoo
 * @ date 2022/4/23 - 20:26
 */
public class codeBlockDetail01 {
    public static void main(String[] args) {
        AA aa = new AA();
    }
}

class AA{
    public int n2 = getN2();

    public static int n1 = getN1();

    static {
        System.out.println("静态代码块被调用");
    }

    public static int getN1(){
        System.out.println("静态方法被调用1");
        return 100;
    }

    public int getN2(){
        System.out.println("普通方法被调用");
        return 1;
    }

    {
        System.out.println("普通代码块被调用");
    }

    public AA() {
        System.out.println("最低级的构造器");
    }
}