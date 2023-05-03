package Interface_07.InterfacePoly;

/**
 * @ author Egcoo
 * @ date 2022/4/27 - 21:57
 */
public class InterfacePoly {
    public static void main(String[] args) {
        //接口体现多态，接口类型的变量，可以指向 实现了 接口类的对象实例
        IF if01 = new Monster();
        if01 = new NewCar();

        //继承体现多态，可以指向继承了子类的对象实例
        AAA a = new CCC();
        a = new DDD();
    }
}

interface IF {
}

class Monster implements IF {

}

class NewCar implements IF {

}

class AAA{}
class CCC extends AAA{

}
class DDD extends AAA{

}