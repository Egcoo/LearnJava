package Question01;

import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @ author Egcoo
 * @ date 2022/10/11 - 20:55
 */
public class ReflectionQuestion {
    public static void main(String[] args) throws Exception {

        //根据配置文件 re.properties 指定信息, 创建 Cat 对象并调用方法 hi
        //这样的需求其实还比较多，就是通过外部文件配置，在不修改源码的情况下配置程序

        //传统的方式 new 对象
        // Cat cat = new Cat();
        // cat.hi();

        // 1.使用Properties 类，可以读写配置文件
        Properties properties = new Properties();
        properties.load(new FileInputStream("E:\\Java_Project\\Module01\\Reflection23\\src\\re.properties"));
        String classfullpath = properties.get("classfullpath").toString();
        String methodName = properties.get("method").toString();
        System.out.println("classfullpath = " + classfullpath);
        System.out.println("method= " + methodName);

        // 2.创建对象，传统的方法，行不通
        // new classfullpath();
        Cat cat = new Question01.Cat();

        // 3.使用反射机制解决
        // (1) 加载类，返回 Class 类型的对象 cls
        Class cls = Class.forName(classfullpath);

        // (2) 通过 cls 得到你加载的类 Question01.Cat 的对象实例
        Object o = cls.newInstance();
        System.out.println("o 的运行类型= " + o.getClass());

        //(3) 通过 cls 得到你加载的类 Question01.Cat 的 methodName "hi" 的方法对象
        //  即：在反射中，可以把方法视为对象（万物皆对象）
        Method method = cls.getMethod(methodName);

        //(4) 通过 method 调用方法：即通过方法对象来实现调用方法
        System.out.println("=========================");
        method.invoke(o); //传统方法，对象.方法() ，反射机制 方法.invoke(对象)

        //java.long.reflect.field；代表类的成员变量，Field对象表示某个类的成员变量
        // 得到 name 字段
        // getField 不能得到私有属性
        Field nameField = cls.getField("age");
        System.out.println(nameField.get(o)); // 传统写法 对象，成员变量，反射：成员变量对象.get(对象)

        //java.long.reflect.Constructor；代表类的成员变量，Field对象表示某个类的成员变量
        Constructor constructor = cls.getConstructor(); //()中可以指定构造器类型，返回
        System.out.println(constructor);

        Constructor constructor2 = cls.getConstructor(String.class); //()中可以指定构造器类型，返回
        System.out.println(constructor2);



    }
}
