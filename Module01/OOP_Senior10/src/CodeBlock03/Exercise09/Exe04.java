package CodeBlock03.Exercise09;

/**
 * @ author Egcoo
 * @ date 2022/5/8 - 9:49
 */
public class Exe04 {
    //匿名内部类最神奇之处就在于可以当成一个参数直接传入
    public static void main(String[] args) {

        Cellphone cellphone = new Cellphone();
        //在这里你使用了接口，所以匿名内部类创建的对象，一定是基于接口的
        cellphone.testWork(new ICalculate() {
            @Override
            public double work(double n1, double n2) {
                return n1 * n2;
            }
        }, 10, 3);


        /*
        cellphone cellphone = new cellphone();
        cellphone.testWork();
         */
    }
}

interface ICalculate {
    //work 只是一个方法，具体需要什么方法没有细说，所以具体要自己设计
    public double work(double n1, double n2);
}

class Cellphone {
    //该匿名内部类可以准确实现相应的各种方法
    public void testWork(ICalculate calculate, double n1, double n2) {
        double result = calculate.work(n1, n2);
        System.out.println("计算的结果是：" + result);
    }
}
/* 这是修改之前的代码
interface calculate{
    public void work();
}

class cellphone implements calculate{

    @Override
    public void work() {
        System.out.println("手机正在运算..........");
    }

    public void testWork(){
        calculate cellphone01 = new calculate() {
            @Override
            public void work() {
                System.out.println("手机正在运算。。。。。。。。。");
            }
        };
        cellphone01.work();
    }
}

 */

