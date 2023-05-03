package Abstract_06;

/**
 * @ author Egcoo
 * @ date 2022/4/24 - 12:35
 */
public class abstract01 {
    public static void main(String[] args) {
        //   new animal() 3.抽象类不能被实例化
    }
}

abstract class animal {
    private String name;
    private int age;

    public animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public abstract void eat();
//    {
//        System.out.println("我也不知道吃什么");
//    }
}

//1.抽象类不一定要有abstract 方法，但是有abstract 方法一定是抽象类
abstract class A {
    public void hi() {
        System.out.println("我也不知道吃什么");
    }
}

abstract class C {
    //public abstract int c =  100; 2.abstract只能修饰方法，不可以修饰属性
}