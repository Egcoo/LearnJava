package SingleTon04;

/**
 * @ author Egcoo
 * @ date 2022/4/25 - 12:37
 */
public class LazyMan {
    public static void main(String[] args) {
        Cat instance = Cat.getInstance();
        System.out.println(instance);

        Cat instance1 = Cat.getInstance();
        System.out.println(instance1);
    }
}

class Cat{
    public String name;
    private static int n1 = 999;
    private static Cat cat;

    //1.仍旧是构造器私有化
    //2.定义一个static 的静态属性方法
    //3.提供一个 public 的static 方法，用于返回 cat 对象
    //4.懒汉式的要点在于，只有当用户使用 getInstance 时，才返回cat对象，
    // 下面再次调用时，会返回已经创建好的对象


    public Cat(String name) {
        System.out.println("构造器被调用。。。。");
        this.name = name;
    }

    public static Cat getInstance(){
        //这里要加入一个判断语句，
        if (cat == null){
            cat = new Cat("666");
        }
        return cat;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
    }
}