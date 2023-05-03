package Abstract_06;

/**
 * @ author Egcoo
 * @ date 2022/4/24 - 14:01
 */
public class abstract02 {
    public static void main(String[] args) {

    }
}

abstract class FFF{
    //5.抽象类的本质还是类，可以有类的各种属性、方法
    //6.抽象类本身就没有方法体
    //7.一旦子类继承了抽象类，必须重写抽象类里的所有的方法
    //8.抽象方法不能使用 private static final 来修饰
    public int n1 = 100;

    public abstract void hi();



}