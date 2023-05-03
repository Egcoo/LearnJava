package Interface_07.InterfaceDetail;

/**
 * @ author Egcoo
 * @ date 2022/4/27 - 13:02
 */
public class interfaceDetail01 {
    public static void main(String[] args) {
        cat cat = new cat();
        cat.hello();
    }

}

interface IA{
    public void hi();
    public void hello();
}

class cat implements IA{

    @Override
    public void hi() {
        System.out.println("66666666");
    }

    @Override
    public void hello() {
        System.out.println("66666666");
    }
}

abstract class tiger implements IA{

}