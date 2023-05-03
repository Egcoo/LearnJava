package reflection02;


/**
 * @ author Egcoo
 * @ date 2022/10/22 - 14:44
 */
public class GetClass03 {
    public static void main(String[] args) throws Exception {

        // 获取类对象的几种方式
        // 1.代码阶段/编译阶段： class.forName() ： 多用于配置文件，读取类的全路径，加载类
        String classAllPath = "reflection02.Car"; //通过读取配置文件获取
        Class<?> cls1 = Class.forName(classAllPath);

        // class 类的加载阶段：类.class ：多用于参数传递，比如通过反射得到构造器对象
        Class cls2 = Car.class;
        System.out.println(cls2);

        // Runtime运行阶段 对象.getClass()
        Car car = new Car();
        Class cls3 = car.getClass();
        System.out.println(cls3);

        // 4.通过类加载器 [4种] 来获取到类的对象
        // (1) 显得都类加载器 car
        ClassLoader classLoader = car.getClass().getClassLoader();
        // (2) 通过类加载器得到 class 对象
        Class<?> cls4 = classLoader.loadClass(classAllPath);
        System.out.println(cls4);


        //cls1 , cls2 , cls3 , cls4 其实是同一个对象
        System.out.println(cls1.hashCode());
        System.out.println(cls2.hashCode());
        System.out.println(cls3.hashCode());
        System.out.println(cls4.hashCode());
    }
}
