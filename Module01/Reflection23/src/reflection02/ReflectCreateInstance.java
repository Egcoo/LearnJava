package reflection02;

import java.lang.reflect.Constructor;

/**
 * @ author Egcoo
 * @ date 2022/10/26 - 16:07
 */
public class ReflectCreateInstance {
    public static void main(String[] args) throws Exception {
        // 1.先获取User 类的 Class 对象
        Class userClass = Class.forName("reflection02.User");
        // 2.通过 public 的无参构造器创建实例
        Object o = userClass.newInstance();
        System.out.println(o);

        // 3.通过 public 的有参构造器创建实例
        /*
        public User(String name) {//public 的有参构造器
        this.name = name;
    }
         */
        // 3.1 先得到对应的构造器
        Constructor constructor = userClass.getConstructor(String.class);

        // 3.2 创建实例，并传入实参
        Object fsj = constructor.newInstance("fsj");
        System.out.println(" fsj = " + fsj);

        // 4.通过 非Public 的有参构造创建实例
        // 4.1 得到private 的构造器对象
        /*
         下面这种会报错，因为 class 对象的 getConstructor的 方法不可以访问私有的构造器/方法/属性
        Constructor constructor1 = userClass.getConstructor(int.class, String.class);
         只能通过 getDeclaredConstructor() 方法来访问
          */
        Constructor declaredConstructor = userClass.getDeclaredConstructor(int.class, String.class);

        // 4.2 创建实例
        // 暴破【暴力破解】 ,使用反射可以访问 private 构造器/方法/属性，反射面前，都是纸老虎
        // 不过问题也在于 暴破破坏了封装的完整性
        declaredConstructor.setAccessible(true);
        Object user2 = declaredConstructor.newInstance(100, "张三丰");
        System.out.println("user2 = " + user2);


    }
}

class User { //User 类
    private int age = 10;
    private String name = "韩顺平教育";

    public User() {//无参 public
    }

    public User(String name) {//public 的有参构造器
        this.name = name;
    }

    private User(int age, String name) {//private 有参构造器
        this.age = age;
        this.name = name;
    }

    public String toString() {
        return "User [age=" + age + ", name=" + name + "]";
    }
}