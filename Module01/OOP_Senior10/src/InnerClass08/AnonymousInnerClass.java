package InnerClass08;

/**
 * @ author Egcoo
 * @ date 2022/4/30 - 11:19
 */
public class AnonymousInnerClass {
    public static void main(String[] args) {
        Outer04 outer04 = new Outer04();
        outer04.method();

    }
}

//老韩解读,我感觉更多的作用还是简化开发。
//1.需求： 想使用 IA 接口,并创建对象
//2.传统方式，是写一个类，实现该接口，并创建对象
//3.老韩需求是 Tiger/Dog 类只是使用一次，后面再不使用
//4. 可以使用匿名内部类来简化开发
//5. tiger 的编译类型 ? IA
//6. tiger 的运行类型 ? 就是匿名内部类 Outer04$
/*
    我们看底层 会分配 类名 Outer04$1
    class Outer04$1 implements IA {
        @Override
        public void cry() {
         System.out.println("老虎叫唤...");
        }
    }
*/
//7.jdk在底层创建匿名内部类，创建好以后就直接实例化，
//8.匿名内部类只能使用一次，就不能再使用。
class Outer04 {
    private int n1 = 10;

    public void method() {
        A tiger = new A() {
            @Override
            public void cry() {
                System.out.println("老虎叫唤.......");
            }
        };
        System.out.println("tiger 的运行类型是：" + tiger.getClass());
        tiger.cry();

        //基于类的匿名内部类
        Father jack = new Father("jack"){
            @Override
            public void test() {
                System.out.println("这是重写了test方法.....");
            }
        };
        System.out.println("father的运行类型：" + jack.getClass());

        //基于抽象类的匿名内部类
        Animal animal = new Animal(){
            @Override
            public void eat() {
                System.out.println("小狗吃骨头.........");
            }
        };
        animal.eat();

    }
}

interface A {
    public void cry();
}

class Father {
    public Father(String name) {
        System.out.println("接收到name = " + name);
    }

    public void test() {

    }
}
abstract class Animal{
    public abstract void eat();
}