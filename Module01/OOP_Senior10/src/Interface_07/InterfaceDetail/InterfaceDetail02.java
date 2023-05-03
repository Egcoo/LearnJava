package Interface_07.InterfaceDetail;

/**
 * @ author Egcoo
 * @ date 2022/4/27 - 13:20
 */
public class InterfaceDetail02 {

}

interface IAA{
    public void hi();
}
interface IBB{
    public void say();
}
interface ICC extends IAA{
    public void hello();
}

class dog implements IAA,IBB{

    @Override
    public void hi() {

    }

    @Override
    public void say() {

    }
}