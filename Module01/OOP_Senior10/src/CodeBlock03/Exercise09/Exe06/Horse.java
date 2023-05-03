package CodeBlock03.Exercise09.Exe06;

/**
 * @ author Egcoo
 * @ date 2022/5/9 - 22:17
 */
public class Horse implements Vehicles {


    @Override
    public void work() {
        System.out.println("普通路上就骑马.....");
    }
}

class Boat implements Vehicles {

    @Override
    public void work() {
        System.out.println("遇到河流就开船......");
    }
}

class Plane implements Vehicles{

    @Override
    public void work() {
        System.out.println("过火焰山就用飞机........");
    }
}