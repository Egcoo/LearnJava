package CodeBlock03.Exercise09.Exe06;

/**
 * @ author Egcoo
 * @ date 2022/5/9 - 22:21
 */
public class Person {

    private String name;
    private Vehicles Vehicles;

    public Person(String name, Vehicles vehicles) {
        this.name = name;
        Vehicles = vehicles;
    }

    //这里实例化一个唐僧对象，要求一般情况下以马作为交通工具，遇到大河时用船作为交通工具
    //这里就涉及到一个编程思想，就是可以把具体的要求封装为方法 -》这里就是编程思想
    //这里就出现一个问题，就是这样会造成资源的浪费，就是你在构造器里已经传入了一匹马，然后你调用common
    //                   又调出来一匹马

    public void passRiver() {
        //本质还是 向上转型 和 动态绑定
        //判断当前的属性是不是 null，不过这里还有一个问题，先调用common 以后啊，这个属性就不是空了，
        // 这个时候再调用 Boat 输入的还是tmd common的方法，所以就要调整一下
        //还是得看运行类型，如果运行类型不是 Boat 就调用应有的

        if (!(Vehicles instanceof Boat)) {
            Vehicles = Plant.getBoat();
        }
        Vehicles.work();
    }

    public void common() {

        //判断一下当前的 vehicle 属性是null ，就获取一匹马
        //如果不是空直接调用就行
        /*
        if (Vehicles == null) {
            Vehicles = Plant.getHorse();
        }
         */
        if (!(Vehicles instanceof Horse)) {
            Vehicles = Plant.getHorse();
        }

        Vehicles.work();
    }

    public void passFireHill(){
        if (!(Vehicles instanceof Plane)){
            Vehicles = Plant.getPlane();
        }

        Vehicles.work();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CodeBlock03.Exercise09.Exe06.Vehicles getVehicles() {
        return Vehicles;
    }

    public void setVehicles(CodeBlock03.Exercise09.Exe06.Vehicles vehicles) {
        Vehicles = vehicles;
    }
}

