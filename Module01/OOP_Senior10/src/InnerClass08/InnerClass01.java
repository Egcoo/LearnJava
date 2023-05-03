package InnerClass08;

/**
 * @ author Egcoo
 * @ date 2022/4/30 - 9:45
 */
public class InnerClass01 {
    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.f1();
    }
}

class Outer{
    private int n1 = 100;

    private void m2(){
        System.out.println("Outer 02...");
    }

    //Outer.this 本质还是外部类的对象，那个对象调用了f1，Outer.this就是指那个对象
    public void f1(){
        class Inner{
            private int n1 = 800;
            public void f2(){
                System.out.println("n1 = " + n1 + " Outer.n1 =" + Outer.this.n1);
                m2();
            }
        }

        Inner inner = new Inner();
        inner.f2();
    }
}
