package CodeBlock03.Exercise09;

/**
 * @ author Egcoo
 * @ date 2022/5/9 - 21:52
 */
public class Exe05 {
    public static void main(String[] args) {
        A a = new A();
        a.f1();
    }

}

class A {
    private static final String NAME = "66666666";

    public void f1() {
        class B {
            private static final String NAME = "scientist";

            public void show(){
                System.out.println("NAME = " + NAME + " 外部类的名字 = " + A.this.NAME);
            }
        }

        B b = new B();
        b.show();
    }

}
