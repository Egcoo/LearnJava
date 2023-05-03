package Final05;

/**
 * @ author Egcoo
 * @ date 2022/4/24 - 11:50
 */
public class final01 {
    public static void main(String[] args) {
        System.out.println(DD.num);
    }
}

class AA{
    //1.final 修饰的属性一般叫做常量，一般用大写字母来表示
    //2.final 属性在定义时必须赋值，不过有三种方式，1）定义直接复制 2）构造器赋值 3）代码块赋值
    //3.如果静态属性使用 final 则不能使用构造器赋值，因为static 在类加载的时候就完成，

    public final double TAX_RATE = 0.08;//定义时赋值
    public final double TAX_RATE2;//
    public final double TAX_RATE3;//
    public final double TAX_RATE4 = 0.08;//

    public AA(){
        TAX_RATE2 = 2.4;
    }

    {
        TAX_RATE3 = 44.3;
    }
}

class BB{
    public static final double test;
    public static final double test2 = 4;

    static {
        test = 3.3;
    }
//
//    public BB() {
//        test2 = 4.4;
//    }
}

class DD{
    public final static int num = 10000; //往往搭配使用，不会导致类被加载
    static {
        System.out.println("BBB 静态代码块被执行");
    }

}