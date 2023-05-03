package InnerClass08;

/**
 * @ author Egcoo
 * @ date 2022/4/30 - 14:50
 */
public class MemberInnerClass {
    public static void main(String[] args) {

        Outer01 outer01 = new Outer01();
        outer01.f3();

        //外部其他类，使用成员内部类的三种方式
        //老韩解读
        // 第一种方式
        // outer01.new Inner(); 相当于把 new Inner()当做是 outer01 成员
        // 这就是一个语法，不要特别的纠结.
        Outer01.Inner inner = outer01.new Inner();
        inner.f2();
        // 第二方式 在外部类中，编写一个方法，可以返回 Inner08 对象
        Outer01.Inner innerInstance = outer01.getInnerInstance();
        innerInstance.f2();
    }
}

class Outer01 {
    private int n1 = 100;
    public String name = "张三";

    class Inner {
        public void f2() {
            System.out.println("n1 = " + n1 + " name= " + name);
        }
    }

    public Inner getInnerInstance(){
        return new Inner();
    }
    public void f3(){
        Inner inner = new Inner();
        inner.f2();
    }
}