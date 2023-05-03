package InnerClass08;

/**
 * @ author Egcoo
 * @ date 2022/5/1 - 10:24
 */
public class StaticInnerClass {
    public static void main(String[] args) {
        Outer10 outer10 = new Outer10();
        outer10.m1();

        System.out.println("=======第一种======");
        //通过类名直接访问
        Outer10.Inner10 inner10 = new Outer10.Inner10();
        inner10.say();

        System.out.println("==========第二种=========");
        //编写方法，可以返回静态类的对象实例
        Outer10.Inner10 instance = outer10.getInstance();
        instance.say();


    }
}

class Outer10 {
    //1. 放在外部类的成员位置
    //2. 使用 static 修饰
    //3. 可以直接访问外部类的所有静态成员，包含私有的，但不能直接访问非静态成员
    //4. 可以添加任意访问修饰符(public、protected 、默认、private),因为它的地位就是一个成员
    //5. 作用域 ：同其他的成员，为整个类
    private int n1 = 10;
    private static String name = "张三";

    private static void cry() {
    }
    //静态内部类依然是放在成员的位置，不过要加上Static

    static class Inner10 {
        public int n1 = 10;

        public void say() {
            System.out.println(n1 + "外部类的n1 = " + Outer10.name);
        }
    }

    public void m1() {
        Inner10 inner10 = new Inner10();
        inner10.say();
    }

    public Inner10 getInstance() {
        return new Inner10();
    }
}