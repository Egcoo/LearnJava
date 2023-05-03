package reflection02;

import Question01.Cat;

import java.lang.reflect.Method;

/**
 * @ author Egcoo
 * @ date 2022/10/22 - 10:28
 */
public class Reflection02 {
    public static void main(String[] args) throws Exception {

        m1();
        m2();
    }

    public static void m1() {

        Cat cat = new Cat();
        long start = System.currentTimeMillis();

        for (int i = 0; i < 10000000; i++) {
            cat.hi();
        }
        long end = System.currentTimeMillis();
        System.out.println("m1 耗时=" + (end - start));
    }

    public static void m2() throws Exception {
        //加载类
        Class cls = Class.forName("Question01.Cat");
        //加载对象实例
        Object o = cls.newInstance();
        //(3) 通过 cls 得到你加载的类 Question01.Cat 的 methodName "hi" 的方法对象
        Method hi = cls.getMethod("hi");
        //取消方法调用时的安全检查
        hi.setAccessible(true);

        long start = System.currentTimeMillis();

        for (int i = 0; i < 10000000; i++) {
            hi.invoke(o);
        }
        long end = System.currentTimeMillis();
        System.out.println("m1 耗时=" + (end - start));
    }

}
