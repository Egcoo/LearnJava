package InnerClass08.InnerClassExe;

/**
 * @ author Egcoo
 * @ date 2022/4/30 - 14:18
 */
public class exe01 {
    public static void main(String[] args) {

        f1(new IS() {
            @Override
            public void say() {
                System.out.println("这是一幅名画......");
            }
        });

        f1(new picture());



    }
    public static void f1(IS is){
        is.say();
    }
}

interface IS{
    public void say();
}

//通过类来实现 在编程领域---》硬编码
class picture implements IS{
    @Override
    public void say() {
        System.out.println("这是一幅名画。。。。");
    }
}