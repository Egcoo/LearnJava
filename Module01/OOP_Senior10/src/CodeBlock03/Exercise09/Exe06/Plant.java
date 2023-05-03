package CodeBlock03.Exercise09.Exe06;

/**
 * @ author Egcoo
 * @ date 2022/5/9 - 22:25
 */
public class Plant {

    //不过正常情况下马可以一直用，不过船可以不断更换
    public static Horse horse = new Horse(); //属于是饿汉式，在类加载时就创建了对象实例

    private Plant() {}
    //这里我们将方法做成静态，在调用时就可以直接通过类名.方法名来调用，就不用创建一个类

    public static Horse getHorse(){

        return horse;
    }

    public static Boat getBoat(){
        return new Boat();
    }

    public static Plane getPlane(){
        return new Plane();
    }
}
