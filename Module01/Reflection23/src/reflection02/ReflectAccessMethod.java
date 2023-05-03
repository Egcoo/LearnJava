package reflection02;

import java.lang.reflect.Method;

/**
 * @ author Egcoo
 * @ date 2022/10/27 - 21:58
 */
public class ReflectAccessMethod {
    public static void main(String[] args) throws Exception {
        // 1.得到 Boss 对象的 Class 对象
        Class<?> bossClass = Class.forName("reflection02.Boss");
        // 2.创建对象
        Object o = bossClass.newInstance();
        // 3.调用 public 的hi 方法
        Method hi = bossClass.getDeclaredMethod("hi", String.class);
        // 3.2 调用
        hi.invoke(o,"fsj");

        // 调用 private static 方法
        // 4.1 得到 say 方法对象
        Method say = bossClass.getDeclaredMethod("say", int.class, String.class, char.class);
        // 4.2 因为 say 方法是 private ，所以需要暴破
        say.setAccessible(true);
        System.out.println(say.invoke(o,100,"张三",'男'));
        // 4.3 因为 say 方法是static 的，还可以这样调用，可传入 null

        // 5. 在反射中，如果方法有返回值，统一返回 Object，但是他运行类型和方法类型一致
        Object reVal = say.invoke(null, 300, "王五", '男');
        System.out.println("reVal 的运行类型=" + reVal.getClass());

        // 演示一个返回的案例
        Method m1 = bossClass.getDeclaredMethod("m1");
        Object reVal2 = m1.invoke(o);
        System.out.println("reVal2 的运行类型=" + reVal2.getClass());
    }
}

class Monster {
}

class Boss {//类
    public int age;
    private static String name;

    public Boss() {//构造器
    }

    public Monster m1() {
        return new Monster();
    }

    private static String say(int n, String s, char c) {//静态方法
        return n + " " + s + " " + c;
    }

    public void hi(String s) {//普通 public 方法

        System.out.println("hi " + s);
    }
}