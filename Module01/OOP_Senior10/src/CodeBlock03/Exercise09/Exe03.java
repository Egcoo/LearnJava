package CodeBlock03.Exercise09;

/**
 * @ author Egcoo
 * @ date 2022/5/8 - 9:44
 */
public class Exe03 {
    public static void main(String[] args) {
        dog dog = new dog();
        dog.shout();
        cat cat = new cat();
        cat.shout();
    }
}

abstract class Animal{
    public abstract void shout();
}

class dog extends Animal{

    @Override
    public void shout() {
        System.out.println("狗在汪汪叫");
    }
}

class cat extends Animal{

    @Override
    public void shout() {
        System.out.println("猫在叫");
    }
}

