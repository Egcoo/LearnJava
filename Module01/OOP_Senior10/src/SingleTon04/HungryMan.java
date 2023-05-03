package SingleTon04;

/**
 * @ author Egcoo
 * @ date 2022/4/24 - 9:51
 */
public class HungryMan {
    public static void main(String[] args) {
//        GirlFriend girlFriend = new GirlFriend();

        GirlFriend instance = GirlFriend.getInstance();
        System.out.println(instance);
    }
    //这是单例模式中饿汉式的实现方式
    //特点就是：即使你没有使用这个实例，它也会帮你创建好了，缺点就是容易导致资源的浪费。

}
class GirlFriend{
    //1.构造器私有化
    //2.在类的内部直接创建对象（对象必须是static，方便后面的静态方法调用）
    //3.提供一个公认的static方法，返回上面的对象

    private String name;
    private static int n1 = 100;

    private GirlFriend(String name) {
        System.out.println("这是构造器的私有化");
        this.name = name;
    }

    private static GirlFriend gf = new GirlFriend("小红");

    public static GirlFriend getInstance(){
        return gf;
    }

    @Override
    public String toString() {
        return "GirlFriend{" +
                "name='" + name + '\'' +
                '}';
    }
}